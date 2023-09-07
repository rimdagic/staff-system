package org.example.menu;

import java.util.List;

import static org.example.Main.menuSystem;

public class MainMenu extends Menu implements MenuState{

    public MainMenu() {
        super("Main Menu\n");
        this.menuOptions = List.of(
                new MenuOption(1, "Add staff", () -> menuSystem.setState(new AddStaffMenu())),
                new MenuOption(2, "Remove staff", () -> System.out.println("Remove")),
                new MenuOption(3, "Edit staff", () -> System.out.println("Edit")),

                new MenuOption(4, "Total number of staff", () -> System.out.println("Test 2")),
                new MenuOption(5, "Median salary", () -> System.out.println("Test 2")),
                new MenuOption(6, "List of staff", () -> System.out.println("Test 2")),

                new MenuOption(7, "Quit", () -> System.exit(0))
        );
    }
}