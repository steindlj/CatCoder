import java.io.File;
import java.io.FileWriter;
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
            int n = sc.nextInt();
            sc.close();
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            fw.write(String.valueOf(fib(n)));
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int fib(int n) {
        if (n < 2) return n;
        return fib(n-1) + fib(n-2);
    }
}