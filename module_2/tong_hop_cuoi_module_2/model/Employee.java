package tong_hop_cuoi_module_2.model;

import tong_hop_cuoi_module_2.service.IEmployeeService;

public class Employee extends Person {
    private String level;
    private String position;
    private long wage;

    public Employee(String id, String name, String date, String gender, String numberName, String numberPhone, String email, String level, String position, long wage) {
        super(id, name, date, gender, numberName, numberPhone, email);
        this.level = level;
        this.position = position;
        this.wage = wage;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getWage() {
        return wage;
    }

    public void setWage(long wage) {
        this.wage = wage;
    }


    public String toStringFile() {
        return getId() + "," + getName() + "," + getDate() + "," + getGender() + "," + getNumberName() + "," + getNumberPhone() + "," + getEmail() + "," + getLevel() + "," + getPosition() + "," + getWage();
    }
    public String toString() {
        return "Mã Nhân Viên : " + getId() + "," + "Tên Nhân Viên : " +  getName() + "," +"Ngày Tháng Năm Sinh Nhân Viên : " +  getDate() + "," +"Giới Tính Nhân Viên : " +  getGender() + "," + "CMND : : " + getNumberName() + "," +"Số Điện Thoai: " + getNumberPhone() + "," + "Email :  " +getEmail() + "," +"Trình Độ Học Vấn Nhân Viên : " + getLevel() + "," + "Chức Vụ Nhân Viên : " + getPosition() + "," +"Mức Lương : " + getWage();
    }
}
