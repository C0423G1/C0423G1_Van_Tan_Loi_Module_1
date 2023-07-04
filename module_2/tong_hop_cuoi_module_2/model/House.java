package tong_hop_cuoi_module_2.model;

public class House extends Facility {

    private String roomStandard;
    private int floors;

    public House(String id, String name, double acreage, double expense, int quantity, String date, String roomStandard, int floors) {
        super(id, name, acreage, expense, quantity, date);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return  "HOUSE : "+ "Mã dịch vụ " +getId() + "," +" Tên dịch vụ " + getName() + "," +"Diện tích sử dụng " + getAcreage() + "," + "Chi phí thuế : " + getExpense() + "," + "Số Lượng người : " +  getQuantity() + "," +"Kiểu Thuê " +  getDate() + "," +"Tiêu Chuẩn phòng " +  getRoomStandard() +  "," +  "Số tầng " + getFloors();
    }
}
