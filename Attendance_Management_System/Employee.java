package Attendance_Management_System;
	
class Employee {
    private String name; // Private field to store employee name
    private String ID; // Private field to store employee ID
    private String department; // Private field to store employee department
    private String checkInTime; // Private field to store employee check-in time
    private String checkOutTime; // Private field to store employee check-out time
    private String totalHours; // Private field to store employee total hours	

    public Employee(String name, String ID) {
        this.name = name; // Initialize employee name
        this.ID = ID; // Initialize employee ID
    }

    public String getName() {
        return name; // Return employee name
    }

    public String getID() {
        return ID; // Return employee ID
    }

    public String getDepartment() {
        return department; // Return employee department
    }

    public void setDepartment(String department) {
        this.department = department; // Set employee department
    }

    public String getCheckInTime() {
        return checkInTime; // Return employee check-in time
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime; // Set employee check-in time
    }

    public String getCheckOutTime() {
        return checkOutTime; // Return employee check-out time
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime; // Set employee check-out time
    }

    public String getTotalHours() {
        return totalHours; // Return employee total hours
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours; // Set employee total hours
    }
}
