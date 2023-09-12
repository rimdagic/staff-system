package org.example;

import java.util.List;

public interface StaffRepo {

    List<Staff> getStaffById(String staffId);
    Staff add(Staff staff);

    List<Staff> getAll();

    void remove(String staffId);

    int size();

    List<Employee> printAllEmployeesByDate();

    int getMedianSalaryByGender(String gender);

    int getMedianSalary();
}
