package com.pb.savchuk.hw11;

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

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);
        SimpleModule module1 = new SimpleModule();
        module1.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module1.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module1);

        //  Создаем телефонную книгу
        List<Pers> list = new ArrayList<>();
        boolean exit = true;

        //  Блок управления телефонной книгой
        while (exit) {

            Scanner s = new Scanner(System.in);
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);

            System.out.println("1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Поиск контакта");
            System.out.println("4. Отсортировать телефонную книгу");
            System.out.println("5. Редактировать контакт");
            System.out.println("6. Запись телефонной книги в файл");
            System.out.println("7. Загрузка телефонной книги из файла");
            System.out.println("8. Выход из программы");
            int input = s.nextInt();

            // Добавляем контакт
            if (input == 1) {
                System.out.println("Введите ФИО");
                String setName = s1.nextLine();
                System.out.println("Введите дату рождения: year-mm-dd");
                LocalDate t;
                t = LocalDate.parse(s1.next());
                System.out.println("Введите номер телефона");
                List<String> phoneList = new ArrayList<>();
                phoneList.add(s2.nextLine());

                // Создаем списак телефонов
                boolean exitForPhone = true;
                while (exitForPhone) {
                    System.out.println("1. Добавить дополнительный номер телефона");
                    System.out.println("2. Продолжить");
                    int input1 = s.nextInt();
                    if (input1 == 1) {
                        System.out.println("Введите дополнительный номер телефона");
                        phoneList.add(s.nextLine());
                    }
                    else if (input1 == 2) {
                        exitForPhone = false;
                    }
                    else {
                        System.out.println("Ошибочный переметр");
                    }
                }
                System.out.println("Введите адрес");
                String setAddress = s1.nextLine();
                LocalDateTime t1 = LocalDateTime.now();
                list.add(new Pers(setName, t, phoneList, setAddress, t1));
            }

            // Удаление контакта по по ФИО
            if (input == 2) {
                Scanner s4 = new Scanner(System.in);
                  System.out.println("Введите ФИО");
                  String str1 = s4.nextLine();
                  int size = list.size();
                  list.removeIf(p -> str1.equals(p.getName()));
                  if (size< list.size()) {
                      System.out.println("Контакт успешно удален");
                  }
            }

            // Поиск контакта по по ФИО
            else if (input == 3) {
                Scanner s3 = new Scanner(System.in);
                System.out.println("Введите ФИО");
                list.forEach(new Consumer<Pers>() {
                    @Override
                    public void accept(Pers p) {

                        if (p.getName().equals(s3.nextLine())){
                            System.out.println("Контакт найден: ");
                            System.out.println(p);
                        } else {
                            System.out.println("В телефонной книге нет данного контакта");
                        }
                    }
                });
            }

            // Сортировка телефонной книги по запрашиваемым параметрам
            else if (input == 4) {
                    System.out.println("1. Сортировать по ФИО");
                    System.out.println("2. Сортировать по дате заполнения");
                    int input2 = s.nextInt();
                    if (input2 == 1) {
                        list.sort(Comparator.comparing(p -> p.getName()));
                        System.out.println(list);
                    }
                    else if (input2 == 2) {
                        list.sort(Comparator.comparing(p -> p.getDateOfEditing()));
                        System.out.println(list);
                    }
                    else {
                        System.out.println("Ошибочный пареметр");
                    }
                }

            // Редактиование телефонной книги по запрашиваемым параметрам
            else if (input == 5) {
                System.out.println("Введите ФИО редактируемого контакта");
                list.forEach(new Consumer<Pers>() {
                    @Override
                    public void accept(Pers p) {
                        if (p.getName().equals(s2.nextLine())){
                            boolean exitForEdition = true;
                            while (exitForEdition) {
                                System.out.println("1. Изменить ФИО");
                                System.out.println("2. Изменить дату рождения");
                                System.out.println("3. Изменить номер телефона");
                                System.out.println("4. Изменить адрес");
                                System.out.println("5. Выйти из редактирования");
                                int index;
                                index = list.indexOf(p);
                                int input3 = s.nextInt();

                                if (input3 == 1) {
                                    System.out.println("Введите новое ФИО");
                                    p.setName(s1.nextLine());
                                    p.setDateOfEditing(LocalDateTime.now());
                                    list.set(index, p);
                                }
                                else if (input3 == 2) {
                                    System.out.println("Введите новую дату рождения: year-mm-dd");
                                    p.setDateOfBirth(LocalDate.parse(s2.next()));
                                    p.setDateOfEditing(LocalDateTime.now());
                                    list.set(index, p);
                                }
                                else if (input3 == 3) {
                                    System.out.println("Введите новый номер телефона");
                                    List<String> phoneList2 = new ArrayList<>();
                                    phoneList2.add(s1.nextLine());
                                    boolean exitForPhone = true;
                                    while (exitForPhone) {
                                        System.out.println("1. Добавить дополнительный номер телефона");
                                        System.out.println("2. Продолжить");
                                        int input4 = s.nextInt();
                                        if (input4 == 1) {
                                            System.out.println("Введите дополнительный номер телефона");
                                            phoneList2.add(s.nextLine());
                                        }
                                        else if (input4 == 2) {
                                            exitForPhone = false;
                                        }
                                        else {
                                            System.out.println("Ошибочный переметр");
                                        }
                                    }
                                    p.setPhoneNumbers(phoneList2);
                                    p.setDateOfEditing(LocalDateTime.now());
                                    list.set(index, p);
                                }
                                else if (input3 == 4) {
                                    System.out.println("Введите новый адрес");
                                    p.setAddress(s1.nextLine());
                                    p.setDateOfEditing(LocalDateTime.now());
                                    list.set(index, p);
                                }
                                else if (input3 == 5) {
                                    exitForEdition = false;
                                }
                                else {
                                    System.out.println("Ошибочный переметр");
                                }
                            }
                        } else {
                            System.out.println("В телефонной книге нет данного контакта");
                        }
                    }
                });
            }
            // Запись в файл
            else if (input == 6) {
                String json = mapper.writeValueAsString(list);
                File file = Paths.get("src\\com\\pb\\savchuk\\hw11\\person.json").toFile();
                FileOutputStream outputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(json);
                objectOutputStream.close();
                System.out.println("Контакты успешно записаны в файл!");
            }
            // Загрузка из файла
//            else if (input == 7) {
//                File file1 = Paths.get("src\\com\\pb\\savchuk\\hw11\\person.json").toFile();
//                FileInputStream fileInputStream = new FileInputStream(file1);
//                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//                String persons = (String) objectInputStream.readObject();
//                List persons2 = mapper.readValue(persons, List.class);
//                list.addAll(persons2);
//                System.out.println("Контакты успешно загружены из файла!");
//            }
            else if (input == 7) {
                File file1 = Paths.get("src\\com\\pb\\savchuk\\hw11\\person.json").toFile();
                FileInputStream fileInputStream = new FileInputStream(file1);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                String persons = (String) objectInputStream.readObject();
                List<Pers> persons3 = mapper.readValue(persons, new TypeReference<List<Pers>>() {});
                list.addAll(persons3);
                System.out.println("Контакты успешно загружены из файла!");
            }
            // Выход из меню
            else if (input == 8) {
                exit = false;
            }
            else {
                System.out.println("Ошибочный переметр");
            }

            System.out.println(list);
        }
    }
}
