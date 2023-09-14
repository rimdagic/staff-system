package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListBackedStaffRepo implements StaffRepo{

    private final static List<Staff> staffs = new ArrayList<>();

    @Override
    public List<Staff> getStaffById(String staffId) {
        List<Staff> returnList = new ArrayList<>();
        for(Staff staff : staffs){
            if(Objects.equals(staff.getStaffId(), staffId)){
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
        return new ArrayList<>(staffs);
    }

    @Override
    public List<Employee> printAllEmployeesByDate() {
        List<Employee> employeeList = new ArrayList<>();
        for (Staff staff : staffs) {
            if (staff instanceof Employee) {
                employeeList.add((Employee) staff);
            }
        }

        employeeList.sort((e1, e2) -> e1.getStartDate().compareTo(e2.getStartDate()));
        for(Employee employee : employeeList){
            System.out.println(employee);
        }

        return employeeList;
    }

    @Override
    public int getMedianSalaryByGender(String gender) {
        double totalSalary = 0;
        int individualCount = 0;
        for( Staff staff : staffs ){
            if (staff instanceof Employee){
                if(staff.getGender().equals(gender)){
                    individualCount++;
                    Employee employee = (Employee) staff;
                    totalSalary = totalSalary + employee.getSalary();
                }
            }
        }

        int calculatedReturn = (int) Math.round(totalSalary) / individualCount;
        System.out.println(calculatedReturn);
        return calculatedReturn;
    }

    @Override
    public int getMedianSalary() {
        double totalSalary = 0;
        int numberOfEmployees = 0;
        for( Staff staff : staffs ){
            if (staff instanceof Employee employee){
                    numberOfEmployees++;
                totalSalary = totalSalary + employee.getSalary();
            }
        }

        int calculatedReturn = (int) Math.round(totalSalary) / numberOfEmployees;
        System.out.println(calculatedReturn);
        return calculatedReturn;
    }


    @Override
    public void remove(String staffId){
        for( Staff staff : staffs){
            if (staff.getStaffId().equals(staffId)){
                staffs.remove(staff);
                System.out.println("Successfully removed "+ staff+"\n");
                break;
            }
        }
    }

    @Override
    public int size() {
        return staffs.size();
    }
}