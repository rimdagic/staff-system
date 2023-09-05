package org.example;

import java.util.List;

public interface StaffRepo {

    List<Staff> getStaffById(String staffId);
    Staff add(Staff staff);

    List<Staff> getAll();
}
