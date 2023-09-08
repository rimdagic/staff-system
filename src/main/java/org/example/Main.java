package org.example;

import org.example.menu.AddStaffMenu;
import org.example.menu.MainMenu;
import org.example.menu.MenuSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static final StaffRepo staffRepo = new ListBackedStaffRepo();
    //private static final UserInteraction userInteraction = new UserInteraction();
    public static MenuSystem menuSystem;

    public static void main(String[] args) {

        StartUp.printLogo();

        staffRepo.add(new Employee("Mr. Robot", "m", "1212", 22000, LocalDate.parse("2004-02-25", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Madonna", "f", "1214", 26000, LocalDate.parse("2014-07-10", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Winnie the puh", "m", "1213", 4000, LocalDate.parse("1989-10-03", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Margret 'The Iron Lady' Thatcher", "f", "1299", 82000, LocalDate.parse("1992-03-25", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Barak Obama", "m", "1232", 49000, LocalDate.parse("2020-07-18", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Employee("Andariel Maiden of Anguish", "f", "666", 19000, LocalDate.parse("2000-04-24", DateTimeFormatter.ISO_LOCAL_DATE)));

        staffRepo.add(new Intern("Random Pidgeon", "o", "1209", LocalDate.parse("2023-10-15", DateTimeFormatter.ISO_LOCAL_DATE), "Great commitment, work on your communication skills, your going to do great!"));
        staffRepo.add(new Intern("Donald Trump", "m", "1250", LocalDate.parse("2024-07-12", DateTimeFormatter.ISO_LOCAL_DATE), "Doing great, might offer you a job if a possibility comes up."));

        menuSystem = new MenuSystem(new MainMenu());



        while (true) {
            menuSystem.execute();
        }

 /*


        staffRepo.add(new Employee("Admir Agic", "m", "135", 22000, LocalDate.parse("2023-02-25", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Intern("Admir Agic", "m", "134", LocalDate.parse("2020-01-02", DateTimeFormatter.ISO_LOCAL_DATE), "You're simply the beest"));
        staffRepo.add(new Intern("Admir Agic", "m", "136", LocalDate.parse("2020-01-02", DateTimeFormatter.ISO_LOCAL_DATE), "You're simply the beest"));

        Staff employee1 = (staffRepo.getStaffById("135").get(0));
        System.out.println(employee1.getClass());
        System.out.println(staffRepo.getStaffById("136"));


        userInteraction.showLogo();

while(Objects.equals(userInteraction.getAnswer(), 'y')) {

    userInteraction.mainMenu(scanner, staffRepo);

    userInteraction.returnToMainMenu(scanner);
}


  */

    }
}