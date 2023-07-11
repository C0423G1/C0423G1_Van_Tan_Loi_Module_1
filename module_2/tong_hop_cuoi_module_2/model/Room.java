package tong_hop_cuoi_module_2.model;

public class Room extends Facility {
    private String freeService;

    public Room(String id, String name, double acreage, double expense, int quantity, String date, String freeService) {
        super(id, name, acreage, expense, quantity, date);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }


    public String toString() {
        return  "ROOM : "+" Mã dịch vụ " +getId() + "   |   " +" Tên dịch vụ " + getName() + "   |   " +"Diện tích sử dụng " + getAcreage() + "   |   " + "Chi phí thuê : " + getExpense() + "   |   " + "Số Lượng người : " +  getQuantity() + "   |   " +"Kiểu Thuê " +  getDate() + "   |   " +"Dịch Vụ Miễn Phí " + getFreeService();
    }
    public String toStringFile() {
        return  getId() + "," + getName() + ","  + getAcreage() + "," + getExpense() + "," +  getQuantity() + "," + getDate() + "," + getFreeService();
    }
}
