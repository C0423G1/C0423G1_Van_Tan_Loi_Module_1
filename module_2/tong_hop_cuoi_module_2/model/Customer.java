//package tong_hop_cuoi_module_2.model;
//
//import tong_hop_cuoi_module_2.service.ICustomerService;
//
//public class Customer extends Person {
//    private String typeOfGuest;
//    private String Address;
//
//    public Customer(String id, String name, String date, String gender, long numberName, long numberPhone, String email, String typeOfGuest, String address) {
//        super(id, name, date, gender, numberName, numberPhone, email);
//        this.typeOfGuest = typeOfGuest;
//        Address = address;
//    }
//
//    public String getTypeOfGuest() {
//        return typeOfGuest;
//    }
//
//    public void setTypeOfGuest(String typeOfGuest) {
//        this.typeOfGuest = typeOfGuest;
//    }
//
//    public String getAddress() {
//        return Address;
//    }
//
//    public void setAddress(String address) {
//        Address = address;
//    }
//
//    @Override
//    public String toString() {
//        return getId() + "," + getName() + "," + getDate() + "," + getGender() + "," + getNumberName() + "," + getNumberPhone() + "," + getEmail() + "," + getTypeOfGuest() + "," + getAddress();
//    }
//}
