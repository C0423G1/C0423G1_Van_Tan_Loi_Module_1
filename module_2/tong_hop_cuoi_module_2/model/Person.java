package tong_hop_cuoi_module_2.model;

public abstract class Person {
    private String id;
    private String name;
    private String date;
    private String gender;
    private String numberName;
    private String numberPhone;
    private String email;

    public Person(String id, String name, String date, String gender, String numberName, String numberPhone, String email) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.numberName = numberName;
        this.numberPhone = numberPhone;
        this.email = email;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumberName() {
        return numberName;
    }

    public void setNumberName(String numberName) {
        this.numberName = numberName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String toStringFile() {
        return getId() + "," + getName() + "," + getDate() + "," + getGender() + "," + getNumberName() + "," + getNumberPhone() + "," + getEmail();
    }
}
