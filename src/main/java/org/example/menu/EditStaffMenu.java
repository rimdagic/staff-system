package org.example.menu;

import org.example.Staff;
import java.util.ArrayList;
import static org.example.Main.staffRepo;

public class EditStaffMenu extends Menu implements MenuState {
    public EditStaffMenu() {
        super("Edit staff\n");
        int counter = 0;
        this.menuOptions = new ArrayList<>();
        for (Staff staff : staffRepo.getAll()) {
            counter++;
            MenuOption menuOption = new MenuOption(counter, staff.getFullName(), () -> staff.editStaffById(staff.getStaffId()));
            this.menuOptions.add(menuOption);
        }
    }
}