package ss16_text_file;

import ss4_class_object.bai_tap.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadText {
    private List<Nation> list() {
        List<Nation> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("ss16_text_file\\name.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String test[] = line.split(",");
                int id = Integer.parseInt(test[0]);
                String shortName = test[1];
                String Name = test[2];
                list.add(new Nation(id, shortName, Name));
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        ReadText n = new ReadText();
        List<Nation> list = n.list();
        for (Nation m : list) {
            System.out.println(m);
        }
    }

}
