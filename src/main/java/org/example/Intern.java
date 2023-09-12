package org.example;

import java.time.LocalDate;

public class Intern extends Staff {

    private LocalDate endDate;
    private String praise;

    public Intern(String fullName, String gender, String staffId, LocalDate endDate, String praise) {
        super(fullName, gender, staffId);
        this.endDate = endDate;
        this.praise = praise;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise){
        this.praise = praise;
    }

    @Override
    public String toString() {
        return "Intern: " +
                this.getStaffId() + " - " +
                this.getFullName() +
                ", gender: " + this.getGender() +
                ", last day: " + endDate +
                ", praise: " + praise;
    }
}
