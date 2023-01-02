import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Level1 {
    public static void main(String[] args) {
        try {
            String path = "./Level 1/1_4";
            File file = new File(path + ".in");
            Scanner sc = new Scanner(file);
            ArrayList<int[]> sol = new ArrayList<int[]>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            int n = sc.nextInt();
            for (int i = 0; i < n ; i++) {
                list.add(sc.nextInt());
            }
            while (!list.isEmpty()) {
                int plus = 0;
                int minus = 0;
                int x = list.get(0);
                if (x < 0) {
                    plus = Math.abs(x)+1;
                    minus = Math.abs(x)-1;
                } else {
                    plus = (x+1)*-1;
                    minus = (x-1)*-1;
                }
                if (list.contains(plus)) {
                    sol.add(new int[]{x,plus}); 
                }
                if (list.contains(minus) && x != 0 && x != 1) {
                    sol.add(new int[]{x,minus});
                }
                list.remove(0);
            }
            Collections.sort(sol, 
                (a,b) -> a[0] - b[0]
            );
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            fw.write(String.valueOf(sol.size()));
            for (int[] x : sol) {
                fw.write(" " + x[0] + " " + x[1]);
            }
            fw.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}