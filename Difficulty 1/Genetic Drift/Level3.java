import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Level3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            run(i);
        }
    }

    private static void run(int level) {
        try {
            String path = "./Level 3/3_" + String.valueOf(level);
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in);
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<int[]> sol = new ArrayList<int[]>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            int x = sc.nextInt();
            int start = sc.nextInt();
            int y = sc.nextInt();
            int end = sc.nextInt();
            if (x+y == 1) {
                end -= 1;
            } else {
                start += 1;
            }
            reverse(list, start, end);
            while (!list.isEmpty()) {
                int plus = 0;
                int minus = 0;
                int elem = list.get(0);
                if (elem < 0) {
                    plus = Math.abs(elem)+1;
                    minus = Math.abs(elem)-1;
                } else {
                    plus = (elem+1)*-1;
                    minus = (elem-1)*-1;
                }
                if (list.contains(plus)) {
                    sol.add(new int[]{elem,plus}); 
                }
                if (list.contains(minus) && elem != 0 && elem != 1) {
                    sol.add(new int[]{elem,minus});
                }
                list.remove(0);
            }
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            fw.write(String.valueOf(sol.size()));
            fw.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        

    private static void reverse(ArrayList<Integer> list, int start, int end) {
        while (start <= end) {
            int x = list.get(start);
            int y = list.get(end);
            list.set(start++, y*-1);
            list.set(end--, x*-1);
        }
    }
}