package tong_hop_cuoi_module_2.model;

public class Customer extends Person {
    private String typeOfGuest;
    private String address;

    public Customer(String id, String name, String date, String gender, String numberName, String numberPhone, String email, String typeOfGuest, String address) {
        super(id, name, date, gender, numberName, numberPhone, email);
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String toStringFile() {
        return getId() + "," + getName() + "," + getDate() + "," + getGender() + "," + getNumberName() + "," + getNumberPhone() + "," + getEmail() + "," + getTypeOfGuest() + "," + getAddress();
    }

    public String toString() {
        return "Mã Khách Hàng : " + getId() + "," + "Tên Khách Hàng : " + getName() + "," + "Ngày Tháng Năm Sinh  : " + getDate() + "," + "Giới Tính : " + getGender() + "," + "CMND : : " + getNumberName() + "," + "Số Điện Thoai: " + getNumberPhone() + "," + "Email :  " + getEmail() + "," + "Hạng Khách Hàng :  " + getTypeOfGuest() + "," + "Địa Chỉ :  " + getAddress();
    }
}
