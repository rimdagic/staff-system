package org.example;

import java.time.LocalDate;

public class Employee extends Staff{
    private int salary;
    private LocalDate started;

    public Employee(String fullName, String gender, String staffId, int salary, LocalDate started) {
        super(fullName, gender, staffId);
        this.salary = salary;
        this.started = started;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getStarted() {
        return started;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", staffId=" + this.getStaffId() +
                ", fullName=" + this.getFullName() +
                ", gender=" + this.getGender() +
                ", salary=" + salary +
                ", started=" + started +
                '}';
    }
}
