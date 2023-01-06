import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Level3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            run(i);
        }
    }
    
    private static class Payment {
        int day;
        int amount;
        boolean used = false;
        Payment(int day, int amount) {
            this.day = day;
            this.amount = amount;
        }
    }

    private static void run(int level) {
        try {
            String path = "./Level 3/3_" + String.valueOf(level);
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in);
            HashMap<Integer,Integer> fList = new HashMap<>();
            ArrayList<Payment> bList = new ArrayList<Payment>();
            while (sc.hasNext()) {
                if (sc.next().equals("F")) {
                    fList.put(sc.nextInt(),sc.nextInt());
                } else {
                    bList.add(new Payment(sc.nextInt(),sc.nextInt()));
                }
            }
            sc.close();
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            for (int day : fList.keySet()) {
                if (!isDeposited(fList, bList, day)) {
                    fw.write(String.valueOf(day) + " ");
                }
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isDeposited(HashMap<Integer,Integer> f, ArrayList<Payment> b, int day) {
        int payment = f.get(day);
        boolean result = false;
        for (int i =  firstIdxAtDay(b, day); i < b.size() && !result; i++) {
            result = sumUp(payment, b, i, 1);
        }
        return result;
    }

    private static boolean sumUp(int payment, ArrayList<Payment> b, int first, int n) {
        if (payment == b.get(first).amount && !b.get(first).used) {
            b.get(first).used = true;
            return true;
        }
        if (n == 4) {
            if (payment != b.get(first).amount || b.get(first).used) {
                return false;
            }
        }
        if (payment > b.get(first).amount) {
            boolean result = false;
            for (int i = first+1; i < b.size() && !result; i++) {
                result = sumUp(payment-b.get(first).amount, b, i, n+1);
                b.get(first).used = result;
            }
            return result;
        }

        if (payment == 0) {
            return true;
        }

        return false;
    }

    private static int firstIdxAtDay(ArrayList<Payment> b, int day) {
        for (int i = 0; i < b.size(); i++) {
            if (b.get(i).day >= day) {
                return i;
            }
        }
        return 0;
    }
}

