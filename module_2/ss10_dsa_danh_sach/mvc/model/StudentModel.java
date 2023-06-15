package ss10_dsa_danh_sach.mvc.model;

public class StudentModel {
    public int id;
    public String name;
    public String date;
    public String gender;
    public String classStudent;
    public int score;

    public StudentModel() {
    }

    public StudentModel(int id, String name, String date, String gender, String classStudent, int score) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.classStudent = classStudent;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", classStudent='" + classStudent + '\'' +
                ", score=" + score +
                '}';
    }
}
