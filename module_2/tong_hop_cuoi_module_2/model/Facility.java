package tong_hop_cuoi_module_2.model;

import tong_hop_cuoi_module_2.service.IFacilityService;

public abstract class Facility {
    private String id;
    private String name;
    private double acreage;
    private double expense;
    private int quantity;
    private String date;

    public Facility(String id, String name, double acreage, double expense, int quantity, String date) {
        this.id = id;
        this.name = name;
        this.acreage = acreage;
        this.expense = expense;
        this.quantity = quantity;
        this.date = date;
    }

    public Facility() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + getAcreage() + "," + getExpense() + "," + getQuantity() + "," + getDate();
    }
}
