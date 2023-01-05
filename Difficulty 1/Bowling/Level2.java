import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Level2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            run(i);
        }
    }

    private static void run(int level) {
        try {
            String path = "./Level 2/2_" + String.valueOf(level);
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in).useDelimiter(",|:");
            int n = sc.nextInt();
            int[][] bow = new int[n][2];
            int[] sol = new int[n];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                bow[i][0] = x;
                bow[i][1] = y;
                sol[i] = x+y;
            }
            for (int i = 0; i < n; i++) {
                if (i < n) {
                    if (sol[i] == 10) {
                        if (bow[i][0] == 0 || bow[i][1] == 0) {
                            sol[i] += bow[i+1][0] + bow[i+1][1];
                        } else {
                            if (i == n-1) {
                                sol[i] += sc.nextInt();
                            } else {
                                sol[i] += bow[i+1][0];
                            }
                        }
                    }
                }
                if (i > 0) {
                    sol[i] += sol[i-1];
                }
            } 
            sc.close();
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            for (int i = 0; i < n; i++) {
                fw.write(String.valueOf(sol[i]));
                if (i < n-1) fw.write(",");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}