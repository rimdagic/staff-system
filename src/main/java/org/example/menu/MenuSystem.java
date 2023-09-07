package org.example.menu;

public class MenuSystem implements MenuState{

    private MenuState activeMenu;
    private final static MenuSystem menuSystem = new MenuSystem(new MainMenu());
    public MenuSystem(MainMenu mainMenu){
        this.activeMenu = new MainMenu();
    }

    public static MenuSystem getInstance(){
        return menuSystem;
    }

    public void setState(MenuState selectedMenu){
        activeMenu = selectedMenu;
    }

    @Override
    public void execute() {
        activeMenu.execute();
    }
}
