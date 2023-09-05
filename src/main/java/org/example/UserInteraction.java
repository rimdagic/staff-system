package org.example;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInteraction {

    private Character answer = 'y';

    public Character getAnswer() {
        return answer;
    }

    public void setAnswer(Character answer) {
        this.answer = answer;
    }

    private String logo =

            "\n\n\n\t ______                ___        _                         \n" +
            "\t(_____ \\              / __)      | |     _                  \n" +
            "\t _____) )____   ____ | |__  ____ | |  _ | |_   ____         \n" +
            "\t|  ____// _  ) / ___)|  __)/ _  )| | / )|  _) / _  |        \n" +
            "\t| |    ( (/ / | |    | |  ( (/ / | |< ( | |__( ( | |        \n" +
            "\t|_|     \\____)|_|    |_|   \\____)|_| \\_) \\___)\\_||_|        \n" +
            "\t ______                  _         _                        \n" +
            "\t(_____ \\                | |       | |     _                 \n" +
            "\t _____) )____  ___    _ | | _   _ | |  _ | |_   ____   ____ \n" +
            "\t|  ____// ___)/ _ \\  / || || | | || | / )|  _) / _  ) / ___)\n" +
            "\t| |    | |   | |_| |( (_| || |_| || |< ( | |__( (/ / | |    \n" +
            "\t|_|    |_|    \\___/  \\____| \\____||_| \\_) \\___)\\____)|_|    \n" +
                    "\n\t\t\t\tSTAFF MANAGEMENT SYSTEM";


    private String mainMenu =
            "\t__________________________________________________\n" +
            "\t| 1. Add staff                                   |\n" +
            "\t| 2. Remove staff                                |\n" +
            "\t| 3. Edit staff info                             |\n" +
            "\t|                                                |\n" +
            "\t| 4. Number of staff                             |\n" +
            "\t| 5. Median salary                               |\n" +
            "\t| 6. List of staff                               |\n" +
            "\t|________________________________________________|\n";
    
    public void returnToMainMenu(Scanner scanner){
        System.out.println("\tGo to main menu? (y / n)");
        answer = scanner.nextLine().charAt(0);
    }

    public void mainMenu(Scanner scanner, StaffRepo staffRepo){
        System.out.println(mainMenu);
        answer = scanner.nextLine().charAt(0);

        switch (answer) {
            case '1':
                System.out.println("\tAdd staff:\n\t1. New employee\n\t2. New intern");
                answer = scanner.nextLine().charAt(0);

                if(answer == '1') {
                    addEmployee(scanner, staffRepo);
                } else if(answer == '2') {
                    addIntern(scanner, staffRepo);
                }
                break;

            case '2':
                removeStaff(scanner, staffRepo);
                break;

            case '3':
                break;

            case '4':
                break;

            case '5':
                System.out.println("Current number of staff including interns: \t");
                break;

            case '6':
                //printList();
        }
    }

    public void addEmployee(Scanner scanner, StaffRepo staffRepo){
        System.out.println("\tEmployee full name:");
        String name = scanner.nextLine();

        System.out.println("\tGender: (m / f)");
        String gender = scanner.nextLine();

        System.out.println("\tUnique staff ID:");
        String staffId = scanner.nextLine();

        System.out.println("\tSalary:");
        int salary = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\tStart date: (yyyy-mm-dd)");
        String startDate = scanner.nextLine();

        staffRepo.add(new Employee(name, gender, staffId, salary, LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE)));

        System.out.println("\tEmployee successfully created!\n\t" + staffRepo.getStaffById(staffId) +"\n");
    }

    public void addIntern(Scanner scanner, StaffRepo staffRepo){
        System.out.println("\tIntern full name:");
        String name = scanner.nextLine();

        System.out.println("\tGender: (m / f)");
        String gender = scanner.nextLine();

        System.out.println("\tUnique staff ID:");
        String staffId = scanner.nextLine();

        System.out.println("\tAppreciative words:");
        String praise = scanner.nextLine();

        System.out.println("\tEnd date: (yyyy-mm-dd)");
        String endDate = scanner.nextLine();

        staffRepo.add(new Intern(name, gender, staffId, LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE), praise));

        System.out.println("\tIntern successfully created!\n\t" + staffRepo.getStaffById(staffId) +"\n");
    }

    public void removeStaff(Scanner scanner, StaffRepo staffRepo){
        staffRepo.getAll();
        System.out.println("\n\tEnter staff ID to remove staff:");

        String staffId = scanner.nextLine();

    }
    public void showLogo(){
        System.out.println(logo);
    }
}
