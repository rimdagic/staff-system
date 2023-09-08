package org.example.menu;

import java.util.List;
import java.util.Scanner;
import static org.example.Main.*;

public class MainMenu extends Menu implements MenuState{

    public MainMenu() {
        super("Main Menu\n");
        this.menuOptions = List.of(
                new MenuOption(1, "Add staff", () -> menuSystem.setState(new AddStaffMenu())),
                new MenuOption(2, "Remove staff", () -> removeStaff()),
                new MenuOption(3, "Edit staff", () -> menuSystem.setState(new EditStaffMenu())),
                new MenuOption(4, "Total number of staff", () -> totalNumberOfStaff()),
                new MenuOption(5, "Median salary", () -> menuSystem.setState(new MedianSalaryMenu())),
                new MenuOption(6, "List of employees by date of employment", () -> listEmployees()),
                new MenuOption(7, "Quit", () -> System.exit(0))
        );
    }

    public void removeStaff(){
            Scanner scanner = new Scanner(System.in);
            staffRepo.getAll();
            System.out.println("\n\tEnter staff ID to remove staff:");
            String staffId = scanner.nextLine();
            staffRepo.remove(staffId);
    }

    public void totalNumberOfStaff(){
        System.out.println("The total number of staff is: " + staffRepo.size());
        menuSystem.setState(new ContinueMenu());
    }

    public void listEmployees(){
        staffRepo.getAllEmployeesByDate();
    }

}