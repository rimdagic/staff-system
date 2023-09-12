package org.example;

import org.example.menu.MainMenu;
import org.example.menu.MenuSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static final StaffRepo staffRepo = new ListBackedStaffRepo();
    public static MenuSystem menuSystem;

    public static void main(String[] args) {

        StartUp.printLogo();

        staffRepo.add(new Employee("Mr. Robot", "m", "1212", 22000, LocalDate.parse("2004-02-25", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Madonna", "f", "1214", 26000, LocalDate.parse("2014-07-10", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Winnie the pooh", "m", "1216", 4000, LocalDate.parse("1989-10-03", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Margret 'The Iron Lady' Thatcher", "f", "1299", 82000, LocalDate.parse("1992-03-25", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Barak Obama", "m", "1218", 49000, LocalDate.parse("2020-07-18", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Andariel Maiden of Anguish", "f", "666", 19000, LocalDate.parse("2000-04-24", DateTimeFormatter.ISO_LOCAL_DATE)));

        staffRepo.add(new Intern("The Office Cat", "o", "1220", LocalDate.parse("2023-10-15", DateTimeFormatter.ISO_LOCAL_DATE), "Great commitment!"));
        staffRepo.add(new Intern("Donald Trump", "m", "1222", LocalDate.parse("2024-07-12", DateTimeFormatter.ISO_LOCAL_DATE), "Doing great."));

        menuSystem = new MenuSystem(new MainMenu());


        while (true) {
            menuSystem.execute();
        }

    }
}