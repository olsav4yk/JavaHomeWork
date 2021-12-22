package com.pb.savchuk.hw12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pers implements Comparable<Pers>{

        private String name;
        private LocalDate dateOfBirth;
        private List<String> phoneNumbers;
        private String address;
        private LocalDateTime dateOfEditing;

    public Pers(String name, LocalDate dateOfBirth, List<String> phoneNumbers, String address, LocalDateTime dateOfEditing) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
        this.dateOfEditing = dateOfEditing;
    }
    public Pers (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDateOfEditing() {
        return dateOfEditing;
    }

    public void setDateOfEditing(LocalDateTime dateOfEditing) {
        this.dateOfEditing = dateOfEditing;
    }

    @Override
    public String toString() {
        return "(" +
                "ФИО - '" + name + '\'' +
                ", дата рождения - '" + dateOfBirth + '\'' +
                ", номер телефона - " + phoneNumbers +
                ", адрес - '" + address + '\'' +
                ", дата и время редактирования - '" + dateOfEditing +
                "')";
    }
    @Override
    public int compareTo(Pers o) {
        return 0;
    }

    public static void addToList (Scanner scanner, Pers person) {
        System.out.println("Введите ФИО");
        String addName = scanner.nextLine();
        person.setName(addName);
        System.out.println("Введите дату рождения: year-mm-dd");
        try {
        LocalDate addDate;
        String addDate1 = scanner.nextLine();
        addDate = LocalDate.parse(addDate1);
        person.setDateOfBirth(addDate);
        } catch (DateTimeParseException e) {
            System.out.println("Неправильный ввод: " + e.getMessage());
        }
        System.out.println("Введите номер телефона");
        List<String> phoneList = new ArrayList<>();
        String addPhone = scanner.nextLine();
        phoneList.add(addPhone);

        // Создаем списак телефонов
        boolean exitForPhone = true;
        while (exitForPhone) {
            System.out.println("1. Добавить дополнительный номер телефона");
            System.out.println("2. Продолжить");
            Scanner s = new Scanner(System.in);
            int input = s.nextInt();

            if (input == 1) {
                System.out.println("Введите дополнительный номер телефона");
                String addPhone1 = scanner.nextLine();
                phoneList.add(addPhone1);
            }
            else if (input == 2) {
                exitForPhone = false;
            }
            else {
                System.out.println("Ошибочный параметр\n");
            }
        }
        person.setPhoneNumbers(phoneList);
        System.out.println("Введите адрес");
        String addAddress = scanner.nextLine();
        person.setAddress(addAddress);
        LocalDateTime addDateTime = LocalDateTime.now();
        person.setDateOfEditing(addDateTime);
    }
    public static void changeContact (Scanner scanner, Pers person, List <Pers> list1){
                     boolean exitForEdition = true;
                            while (exitForEdition) {
                                System.out.println("1. Изменить ФИО");
                                System.out.println("2. Изменить дату рождения");
                                System.out.println("3. Изменить номер телефона");
                                System.out.println("4. Изменить адрес");
                                System.out.println("5. Выйти из редактирования");
                                int index;
                                index = list1.indexOf(person);
                                Scanner s = new Scanner(System.in);
                                int input3 = s.nextInt();

                                if (input3 == 1) {
                                    System.out.println("Введите новое ФИО");
                                    person.setName(scanner.nextLine());
                                    person.setDateOfEditing(LocalDateTime.now());
                                    list1.set(index, person);
                                }
                                else if (input3 == 2) {
                                    System.out.println("Введите новую дату рождения: year-mm-dd");
                                    person.setDateOfBirth(LocalDate.parse(scanner.next()));
                                    person.setDateOfEditing(LocalDateTime.now());
                                    list1.set(index, person);
                                }
                                else if (input3 == 3) {
                                    Scanner s1 = new Scanner(System.in);
                                    System.out.println("Введите новый номер телефона");
                                    List<String> phoneList2 = new ArrayList<>();
                                    String str = s1.nextLine();
                                    phoneList2.add(str);
                                    boolean exitForPhone = true;
                                    while (exitForPhone) {
                                        System.out.println("1. Добавить дополнительный номер телефона");
                                        System.out.println("2. Продолжить");
                                        int input4 = s.nextInt();
                                        if (input4 == 1) {
                                            System.out.println("Введите дополнительный номер телефона");
                                            phoneList2.add(scanner.nextLine());
                                        }
                                        else if (input4 == 2) {
                                            exitForPhone = false;
                                        }
                                        else {
                                            System.out.println("Ошибочный параметр\n");
                                        }
                                    }
                                    person.setPhoneNumbers(phoneList2);
                                    person.setDateOfEditing(LocalDateTime.now());
                                    list1.set(index, person);
                                }
                                else if (input3 == 4) {
                                    System.out.println("Введите новый адрес");
                                    person.setAddress(scanner.nextLine());
                                    person.setDateOfEditing(LocalDateTime.now());
                                    list1.set(index, person);
                                }
                                else if (input3 == 5) {
                                    exitForEdition = false;
                                }
                                else {
                                    System.out.println("Ошибочный параметр\n");
                                }
                            }
    }
}

