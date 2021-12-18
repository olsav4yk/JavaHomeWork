package com.pb.savchuk.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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


}

