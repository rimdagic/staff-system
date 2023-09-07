package org.example.menu;

import org.example.Employee;
import org.example.Intern;
import org.example.Staff;
import org.example.StaffRepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static org.example.Main.menuSystem;
import static org.example.Main.staffRepo;

public class AddStaffMenu extends Menu implements MenuState{

    Scanner scanner = new Scanner(System.in);

    public AddStaffMenu() {
        super("Add new staff\n");
        this.menuOptions = List.of(
                new MenuOption(1, "Add new employee", () -> addEmployee()),
                new MenuOption(2, "Add new intern", () -> addIntern()),
                new MenuOption(7, "Quit", () -> System.exit(0))
        );



    }

    public void addEmployee(){
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

        menuSystem.setState(new MainMenu());
    }

    public void addIntern(){
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

        menuSystem.setState(new MainMenu());
    }


}
