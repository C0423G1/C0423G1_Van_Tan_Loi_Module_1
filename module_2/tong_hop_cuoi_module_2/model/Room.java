package tong_hop_cuoi_module_2.model;

public class Room extends Facility {
    private String freeService;

    public Room(int id, String name, double acreage, double expense, int quantity, String date, String freeService) {
        super(id, name, acreage, expense, quantity, date);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + getAcreage() + "," + getExpense() + "," + getQuantity() + "," + getDate() + "," + getFreeService();
    }
}
