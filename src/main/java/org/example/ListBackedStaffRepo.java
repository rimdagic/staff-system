package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListBackedStaffRepo implements StaffRepo{


    public static final List<Staff> staffs = new ArrayList<>();

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
}
