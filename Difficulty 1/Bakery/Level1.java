import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Level1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            run(i);
        }
    }

    private static void run(int level) {
        try {
            String path = "./Level 1/1_" + String.valueOf(level);
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in);
            ArrayList<Integer> fList = new ArrayList<>();
            ArrayList<Integer> bList = new ArrayList<>();
            while (sc.hasNext()) {
                if (sc.next().equals("F")) {
                    sc.nextInt();
                    fList.add(sc.nextInt());
                } else {
                    sc.nextInt();
                    bList.add(sc.nextInt());
                }
            }
            sc.close();
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            for (int i = 0; i < fList.size(); i++) {
                int x = fList.get(i);
                int y = bList.get(i);
                if (x != y) {
                    fw.write(String.valueOf(i+1) + " ");
                }
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}