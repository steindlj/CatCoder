import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Level2 {
    public static void main(String[] args) {
        try {
            String path = "./Level 2/2_4";
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in);
            sc.next();
            String lString = sc.next();
            int l = Integer.valueOf(lString.substring(7, lString.length()));
            String iteration = sc.next();
            int n = Integer.valueOf(iteration.substring(11, iteration.length()));
            sc.close();
            double perimeter = 4 * l * (Math.pow(5,n) / Math.pow(3,n));
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            fw.write(String.valueOf((int) perimeter));
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
