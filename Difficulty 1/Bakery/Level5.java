import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Level5 {
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

    private static class Salary {
        int day;
        int amount;
        int window;
        int driver;
        Salary(int day, int driver, int window, int amount) {
            this.day = day;
            this.amount = amount;
            this.window = window;
            this.driver = driver;
        }
    }

    private static void run(int level) {
        try {
            String path = "./Level 5/5_" + String.valueOf(level);
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in);
            ArrayList<Salary> fList = new ArrayList<Salary>();
            ArrayList<Payment> bList = new ArrayList<Payment>();
            while (sc.hasNext()) {
                if (sc.next().equals("F")) {
                    fList.add(new Salary(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
                } else {
                    bList.add(new Payment(sc.nextInt(),sc.nextInt()));
                }
            }
            sc.close();
            Collections.sort(fList, (a,b) -> a.day-b.day);
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            for (Salary sal : fList) {
                if (!isDeposited(bList, sal)) {
                    fw.write(String.valueOf(sal.day) + ":" + String.valueOf(sal.driver) + " ");
                }
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isDeposited(ArrayList<Payment> b, Salary sal) {
        int payment = sal.amount;
        int window = sal.window;
        int day = sal.day;
        ArrayList<Level5.Payment> bWindow = (ArrayList<Level5.Payment>) b.stream().filter(p -> p.day >= day && p.day <= day+window && !p.used).collect(Collectors.toList());
        boolean result = false;
        for (int i = 0; i < bWindow.size() && !result; i++) {
            result = sumUp(payment, bWindow, i, 1);
        }
        return result;
    }

    private static boolean sumUp(int payment, ArrayList<Payment> b, int first, int n) {
        if (payment == b.get(first).amount) {
            b.get(first).used = true;
            return true;
        }
        if (n == 4) {
            if (payment != b.get(first).amount) {
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
}

