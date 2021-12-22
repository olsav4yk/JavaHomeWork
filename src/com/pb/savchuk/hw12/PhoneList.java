package com.pb.savchuk.hw12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class PhoneList {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);

        //  Создаем телефонную книгу
        List<Pers> list = new ArrayList<>();
        boolean exit = true;

        //  Блок управления телефонной книгой
        while (exit) {

            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);

            System.out.println("1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Поиск контакта");
            System.out.println("4. Отсортировать телефонную книгу");
            System.out.println("5. Редактировать контакт");
            System.out.println("6. Запись телефонной книги в файл");
            System.out.println("7. Загрузка телефонной книги из файла");
            System.out.println("8. Выход из программы");
            int input = scan2.nextInt();


            // Добавляем контакт
            if (input == 1) {
                Pers pers = new Pers();
                pers.addToList(scan, pers);
                list.add(pers);
            }

            // Удаление контакта по по ФИО
            else if (input == 2) {
                System.out.println("Введите ФИО");
                String str1 = scan.nextLine();
                int size = list.size();
                list.removeIf(p -> str1.equals(p.getName()));
                  if (list.size()< size) {
                      System.out.println("Контакт успешно удален\n");
                  }
            }

            // Поиск контакта по по ФИО
            else if (input == 3) {
                System.out.println("Введите ФИО");
                String ss3 = scan.nextLine();
                list.forEach(p -> {
                    if (p.getName().equals(ss3)) {
                        System.out.println(p);
                    }
                });
            }

            // Сортировка телефонной книги по запрашиваемым параметрам
            else if (input == 4) {
                    System.out.println("1. Сортировать по ФИО");
                    System.out.println("2. Сортировать по дате заполнения");
                    int input2 = scan.nextInt();
                    if (input2 == 1) {
                        list.stream()
                                .sorted(Comparator.comparing(Pers::getName))
                                .forEach(System.out::println);
                    }
                    else if (input2 == 2) {
                        list.stream()
                                .sorted(Comparator.comparing(Pers::getDateOfEditing))
                                .forEach(System.out::println);
                    }
                    else {
                        System.out.println("Ошибочный параметр\n");
                    }
            }

            // Редактиование телефонной книги по запрашиваемым параметрам
            else if (input == 5) {
                System.out.println("Введите ФИО редактируемого контакта");
                String editionName = s2.nextLine();
                list.forEach(new Consumer<Pers>() {
                    @Override
                    public void accept(Pers p) {

                        if (p.getName().equals(editionName)){
                            p.changeContact(scan, p, list);
                        }
                    }
                });
            }
            // Запись в файл
            else if (input == 6) {
                try {
                String json = mapper.writeValueAsString(list);
                File file = Paths.get("src\\com\\pb\\savchuk\\hw11\\person.json").toFile();
                FileOutputStream outputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(json);
                objectOutputStream.close();
                System.out.println("Контакты успешно записаны в файл!");
                } catch (FileNotFoundException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                } catch (JsonProcessingException e1) {
                    System.out.println("Ошибка: " + e1.getMessage());
                } catch (IOException e2) {
                    System.out.println("Ошибка: " + e2.getMessage());
                }
            }

            else if (input == 7) {
                try {
                File file1 = Paths.get("src\\com\\pb\\savchuk\\hw11\\person.json").toFile();
                FileInputStream fileInputStream = new FileInputStream(file1);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                String persons = (String) objectInputStream.readObject();
                List<Pers> persons3 = mapper.readValue(persons, new TypeReference<List<Pers>>() {});
                list.addAll(persons3);
                System.out.println("Контакты успешно загружены из файла!\n");
                } catch (IOException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                } catch (ClassNotFoundException e1) {
                    System.out.println("Ошибка: " + e1.getMessage());
                }
            }
            // Выход из меню
            else if (input == 8) {
                exit = false;
            }
            else {
                System.out.println("Ошибочный параметр\n");
            }
        }
    }

}
