package org.example.menu;

import java.util.List;
import java.util.Scanner;
import static org.example.Main.menuSystem;
import static org.example.Main.staffRepo;

public class MedianSalaryMenu extends Menu implements MenuState {
    Scanner scanner = new Scanner(System.in);

    public MedianSalaryMenu() {
        super("Salary statistics");
        System.out.println("\n");
        this.menuOptions = List.of(
                new MenuOption(1, "Median salary", () -> medianSalary()),
                new MenuOption(2, "Median salary among female employees", () -> medianSalaryFemale()),
                new MenuOption(3, "Median salary among male employees", () -> medianSalaryMale())
        );
    }

    public void medianSalary(){
        System.out.println("\nMedian salary: ");
        staffRepo.getMedianSalary();
        menuSystem.setState(new ContinueMenu());
    }

    public void medianSalaryFemale(){
        System.out.println("\nFemale median salary: ");
        staffRepo.getMedianSalaryByGender("f");
        menuSystem.setState(new ContinueMenu());
    }

    public void medianSalaryMale(){
        System.out.println("\nMale median salary: ");
        staffRepo.getMedianSalaryByGender("m");
        menuSystem.setState(new ContinueMenu());
    }
}