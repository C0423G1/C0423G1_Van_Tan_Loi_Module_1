package ss16_text_file;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CopyText {
    public static void main(String[] args) {
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
        try {
            FileWriter fw = new FileWriter("ss16_text_file\\nameOne.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Nation nt : list) {
                bw.write(nt.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
