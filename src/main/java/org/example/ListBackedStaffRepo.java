package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListBackedStaffRepo implements StaffRepo{


    public final static List<Staff> staffs = new ArrayList<>();

    @Override
    public List<Staff> getStaffById(String staffId) {
        List<Staff> returnList = new ArrayList<>();
        for(Staff staff : staffs){
            if(staff.getStaffId() == staffId){
                returnList.add(staff);
            }
        }
        return returnList;
    }

    @Override
    public Staff add(Staff staff) {
        staffs.add(staff);
        return staff;
    }

    @Override
    public List<Staff> getAll() {
        List<Staff> returnList = new ArrayList<>();
        for(Staff staff : staffs){
            System.out.println(staff);
            returnList.add(staff);
        }
        return returnList;
    }

    public List<Employee> getAllEmployeesByDate() {

        List<Employee> employeeList = new ArrayList<>();
        for (Staff staff : staffs) {
            if (staff instanceof Employee) {
                employeeList.add((Employee) staff);
            }
        }

        Collections.sort(employeeList, (e1, e2) -> e1.getStartDate().compareTo(e2.getStartDate()));

        for(Employee employee : employeeList){
            System.out.println(employee);
        }

        return employeeList;
    }

    @Override
    public int getMedianSalaryMale() {
        double totalSalary = 0;
        int numberOfMales = 0;
        for( Staff staff : staffs ){
            if (staff instanceof Employee){
                if(staff.getGender().equals("m")){
                    numberOfMales++;
                    Employee employee = (Employee) staff;
                    totalSalary = totalSalary + employee.getSalary();
                }
            }
        }

        int calculatedReturn = (int) Math.round(totalSalary) / numberOfMales;
        System.out.println(calculatedReturn);
        return calculatedReturn;
    }

    @Override
    public int getMedianSalaryFemale() {
        double totalSalary = 0;
        int numberOfFemales = 0;
        for( Staff staff : staffs ){
            if (staff instanceof Employee){
                if(staff.getGender().equals("f")){
                    numberOfFemales++;
                    Employee employee = (Employee) staff;
                    totalSalary = totalSalary + employee.getSalary();
                }
            }
        }

        int calculatedReturn = (int) Math.round(totalSalary) / numberOfFemales;
        System.out.println(calculatedReturn);
        return calculatedReturn;
    }

    @Override
    public int getMedianSalary() {
        double totalSalary = 0;
        int numberOfEmployees = 0;
        for( Staff staff : staffs ){
            if (staff instanceof Employee){
                    numberOfEmployees++;
                    Employee employee = (Employee) staff;
                    totalSalary = totalSalary + employee.getSalary();
            }
        }

        int calculatedReturn = (int) Math.round(totalSalary) / numberOfEmployees;
        System.out.println(calculatedReturn);
        return calculatedReturn;
    }



    public void remove(String staffId){
        for( Staff staff : staffs){
            if (staff.getStaffId().equals(staffId)){
                staffs.remove(staff);
                System.out.println("Successfully removed "+ staff);
                break;
            }
        }
    }

    @Override
    public int size() {
        return staffs.size();
    }
}
