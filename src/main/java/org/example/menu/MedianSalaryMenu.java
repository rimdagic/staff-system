package org.example.menu;


import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import static org.example.Main.menuSystem;
import static org.example.Main.staffRepo;

public class MedianSalaryMenu extends Menu implements MenuState {

    Scanner scanner = new Scanner(System.in);

    public MedianSalaryMenu() {
        super("Salary statistics\n");
        this.menuOptions = List.of(
                new MenuOption(1, "Median salary", () -> medianSalary()),
                new MenuOption(2, "Median salary among female employees", () -> medianSalaryFemale()),
                new MenuOption(3, "Median salary among male employees", () -> medianSalaryMale()),
                new MenuOption(7, "Quit", () -> System.exit(0))
        );
    }

    public void medianSalary(){
        staffRepo.getMedianSalary();
        menuSystem.setState(new ContinueMenu());
    }

    public void medianSalaryFemale(){
        System.out.println("\nFemale median salary: ");
        staffRepo.getMedianSalaryFemale();
        System.out.println("\n");
        menuSystem.setState(new ContinueMenu());
    }

    public void medianSalaryMale(){
        staffRepo.getMedianSalaryMale();
        menuSystem.setState(new ContinueMenu());
    }



}
