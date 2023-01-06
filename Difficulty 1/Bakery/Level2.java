import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Level2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            run(i);
        }
    }

    private static void run(int level) {
        try {
            String path = "./Level 2/2_" + String.valueOf(level);
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in);
            HashMap<Integer,Integer> fList = new HashMap<>();
            HashMap<Integer,Integer> bList = new HashMap<>();
            while (sc.hasNext()) {
                if (sc.next().equals("F")) {
                    fList.put(sc.nextInt(),sc.nextInt());
                } else {
                    bList.put(sc.nextInt(),sc.nextInt());
                }
            }
            sc.close();
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            for (int day : fList.keySet()) {
                int x = fList.get(day);
                int y = bList.get(day);
                if (x != y) {
                    fw.write(String.valueOf(day) + " ");
                }
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}