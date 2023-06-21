package m_v_c_tong_hop.model;

public class Teacher extends Humana {
    private String specialize;

    public Teacher(String specialize) {
        this.specialize = specialize;
    }

    public Teacher(int id, String name, String date, String gender, String specialize) {
        super(id, name, date, gender);
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "specialize='" + specialize + '\'' +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", date='" + getDate() + '\'' +
                ", gender='" + getGender() + '\'' +
                '}';
    }
}
