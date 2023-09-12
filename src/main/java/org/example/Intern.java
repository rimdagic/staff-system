package org.example;

import java.time.LocalDate;

public class Intern extends Staff {

    private LocalDate ending;
    private String praise;

    public Intern(String fullName, String gender, String staffId, LocalDate ending, String praise) {
        super(fullName, gender, staffId);
        this.ending = ending;
        this.praise = praise;
    }

    public LocalDate getEnding() {
        return ending;
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
                ", last day: " + ending +
                ", praise: " + praise;
    }






}
