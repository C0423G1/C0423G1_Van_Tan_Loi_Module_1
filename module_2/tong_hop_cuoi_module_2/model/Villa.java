package tong_hop_cuoi_module_2.model;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floors;

    public Villa(String id, String name, double acreage, double expense, int quantity, String date, String roomStandard, double poolArea, int floors) {
        super(id, name, acreage, expense, quantity, date);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }


    public String toString() {
        return "VILLA : " + " Mã dịch vụ " +getId() + "   |   " +" Tên dịch vụ " + getName() + "   |   " +"Diện tích sử dụng " + getAcreage() + "   |   " + "Chi phí thuê : " + getExpense() + "   |   " + "Số Lượng người : " +  getQuantity() + "   |   " +"Kiểu Thuê " +  getDate() + "   |   " +"Tiêu Chuẩn phòng " +  getRoomStandard() + "   |   " + "Diện tích hồ bơi" +  getPoolArea() + "   |   " +  "Số tầng " + getFloors();
    }
    public String toStringFile() {
        return  getId() + "," + getName() + ","  + getAcreage() + "," + getExpense() + "," +  getQuantity() + "," + getDate() + "," + getRoomStandard() + "," +  getPoolArea() + "," +  getFloors();
    }
}
