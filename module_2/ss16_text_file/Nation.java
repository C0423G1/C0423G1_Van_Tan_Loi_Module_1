package ss16_text_file;

import java.util.List;

public class Nation {
    private int id;
    private String shortName;
    private String name;

    public Nation(int id, String shortName, String name) {
        this.id = id;
        this.shortName = shortName;
        this.name = name;
    }

    public Nation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "," + shortName + "," + name;
    }


}
