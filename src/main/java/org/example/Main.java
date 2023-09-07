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



        staffRepo.add(new Employee("Admir Agic", "m", "135", 22000, LocalDate.parse("2023-02-25", DateTimeFormatter.ISO_LOCAL_DATE)));
        staffRepo.add(new Intern("Admir Agic", "m", "134", LocalDate.parse("2020-01-02", DateTimeFormatter.ISO_LOCAL_DATE), "You're simply the beest"));
        staffRepo.add(new Intern("Admir Agic", "m", "136", LocalDate.parse("2020-01-02", DateTimeFormatter.ISO_LOCAL_DATE), "You're simply the beest"));

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