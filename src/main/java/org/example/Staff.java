package org.example;

public class Staff {
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

}
