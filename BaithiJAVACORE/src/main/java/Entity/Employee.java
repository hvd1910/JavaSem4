package Entity;


import java.util.Date;

public class Employee {

    private int id;
    private String CMND;
    private String Full_Name;

    private String Birthday;

    private String Address;

    private String Position;

    private String Department;

    public Employee() {
    }

    public Employee(int id, String CMND, String full_Name, String birthday, String address, String position, String department) {
        this.id = id;
        this.CMND = CMND;
        Full_Name = full_Name;
        Birthday = birthday;
        Address = address;
        Position = position;
        Department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String full_Name) {
        Full_Name = full_Name;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
