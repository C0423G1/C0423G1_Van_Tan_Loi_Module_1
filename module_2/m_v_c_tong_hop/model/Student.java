package m_v_c_tong_hop.model;

public class Student extends Humana {
    private String classStudent;
    private int core;

    public Student() {
    }

    public Student(String classStudent, int core) {
        this.classStudent = classStudent;
        this.core = core;
    }

    public Student(int id, String name, String date, String gender, String classStudent, int core) {
        super(id, name, date, gender);
        this.classStudent = classStudent;
        this.core = core;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    @Override
    public String toString() {
        return "Student{" +
                "classStudent='" + classStudent + '\'' +
                ", core=" + core +
                "id=" + getId() +
                ", name='" + getName() +
                ", date='" + getDate() + '\'' +
                ", gender='" + getGender() + '\'' +
                '}';
    }
}
