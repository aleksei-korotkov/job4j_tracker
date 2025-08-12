package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setPatronymic("Ivanovich");
        student.setGroup("Programming");
        student.setDateRegister(new Date());
        System.out.println(student.getSurname() + " "
                            + student.getName() + " "
                            + student.getPatronymic()
                            + ": Date of register: " + student.getDateRegister()
                            + " Group: " + student.getGroup());
    }
}