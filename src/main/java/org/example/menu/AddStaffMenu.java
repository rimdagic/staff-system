package org.example.menu;

import org.example.Employee;
import org.example.Intern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import static org.example.Main.menuSystem;
import static org.example.Main.staffRepo;
import static org.example.Staff.idIsTaken;

public class AddStaffMenu extends Menu implements MenuState{

    Scanner scanner = new Scanner(System.in);

    public AddStaffMenu() {
        super("Add new staff\n");
        this.menuOptions = List.of(
                new MenuOption(1, "Add new employee", () -> addEmployee()),
                new MenuOption(2, "Add new intern", () -> addIntern())
                //new MenuOption(7, "Quit", () -> System.exit(0))
        );
    }

    public void addEmployee() {
        System.out.println("Employee full name:");
        String name = scanner.nextLine();

        System.out.println("Gender: (m / f)");
        String gender = scanner.nextLine();

        String staffId;
        do {
            System.out.println("Unique staff ID:");
            staffId = scanner.nextLine();
        } while (idIsTaken(staffId));

        System.out.println("Salary:");
        int salary = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Start date: (yyyy-mm-dd)");
        String startDate = scanner.nextLine();

        staffRepo.add(new Employee(name, gender, staffId, salary, LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE)));
        System.out.println("Employee successfully created!\n" + staffRepo.getStaffById(staffId) + "\n");
        menuSystem.setState(new ContinueMenu());
    }

    public void addIntern(){
        System.out.println("Intern full name:");
        String name = scanner.nextLine();

        System.out.println("Gender: (m / f)");
        String gender = scanner.nextLine();

        String staffId;
        do {
            System.out.println("Unique staff ID:");
            staffId = scanner.nextLine();
        } while (idIsTaken(staffId));

        System.out.println("Appreciative words:");
        String praise = scanner.nextLine();

        System.out.println("End date: (yyyy-mm-dd)");
        String endDate = scanner.nextLine();

        staffRepo.add(new Intern(name, gender, staffId, LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE), praise));
        System.out.println("Intern successfully created!\n" + staffRepo.getStaffById(staffId) +"\n");
        menuSystem.setState(new ContinueMenu());
    }
}