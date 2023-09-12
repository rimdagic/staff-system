package org.example;

import org.example.menu.ContinueMenu;
import java.util.Scanner;
import static org.example.Main.menuSystem;
import static org.example.Main.staffRepo;

public class Staff {
    Scanner scanner = new Scanner(System.in);
    private String fullName;
    private String gender;
    private String staffId;

    public Staff(String fullName, String gender, String staffId) {
        this.fullName = fullName;
        this.gender = gender;
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getStaffId() {
        return staffId;
    }

    public String setStaffId(Staff staff) {
        String input;
        boolean isTaken;
        do {
           // isTaken = false;
            System.out.print("Enter new staff ID: ");
            input = scanner.nextLine();

            if(staff.staffId.equals(input)){
                staff.staffId = input;
                return input;
            }
            isTaken = idIsTaken(input);

        } while (isTaken == true);
        this.staffId = input;
        return input;
    }

    public static boolean idIsTaken(String staffId){
        boolean isTaken = false;
        for (Staff staff : staffRepo.getAll()) {
            if (staff.staffId.equals(staffId)) {
                isTaken = true;
                System.out.println("Staff ID is already taken");
            }
        }
            return isTaken;
    };

    public void editStaffById(String staffId) {

        String input = "";
        System.out.println("Edit staff");
        for(Staff staff : staffRepo.getAll()){
            if (staff.staffId == staffId){

                    System.out.print("Current name: " + staff.getFullName() + "\nEnter new name: ");
                    this.fullName = scanner.nextLine();

                    System.out.print("Current gender: " + staff.getGender() + "\nEnter new gender (m / f): ");
                    this.gender = scanner.nextLine();

                    System.out.print("Current staff ID: " + staff.getStaffId() + "\n");
                    setStaffId(staff);

                if(staff instanceof Employee){
                    System.out.print("Current salary: " + ((Employee) staff).getSalary() + "\nEnter new salary: ");
                     input = scanner.nextLine();
                     int newSalary = Integer.valueOf(input);
                    ((Employee) staff).setSalary(newSalary);

                } else if (staff instanceof Intern){
                    System.out.print("Appreciative words: " + ((Intern) staff).getPraise() + "\nEnter new appreciative words: ");
                    input = scanner.nextLine();
                    ((Intern) staff).setPraise(input);
                }

                System.out.println("\nSuccessfully edited " + staff);
            }
        }

        menuSystem.setState(new ContinueMenu());
    }
}
