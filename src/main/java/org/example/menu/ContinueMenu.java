package org.example.menu;

import java.util.List;
import static org.example.Main.menuSystem;

public class ContinueMenu extends Menu implements MenuState{

    public ContinueMenu() {
        super(" ");
        this.menuOptions = List.of(
                new MenuOption(1, "Main menu", () -> menuSystem = new MenuSystem(new MainMenu())),
                new MenuOption(2, "Exit", () -> System.exit(0)));

    }
}
