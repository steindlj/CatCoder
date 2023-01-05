import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Level1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            run(i);
        }
    }

    private static void run(int level) {
        try {
            String path = "./Level 1/1_" + String.valueOf(level);
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in);
            ArrayList<String> primes = new ArrayList<>();
            primes.add(sc.nextLine());
            sc.close();
            while (primes.size() > 0 && primes.get(0).length() > 1) {
                getPrimes(primes);   
            }
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            fw.write(String.valueOf(primes.size()));
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void getPrimes(ArrayList<String> primes) {
        int n = primes.size();
        for (int i = 0; i < n; i++) {
            String prime = primes.get(i);
            for (int j = 0; j < prime.length(); j++) {
                StringBuilder sb = new StringBuilder(prime);
                sb.deleteCharAt(j);
                String s = sb.toString();
                if (isPrime(Long.parseLong(s))) {
                    primes.add(s);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            primes.remove(0);
        }
    }

    private static boolean isPrime(long prime) {
        if (prime == 1) return false;
        for (int i = 2; i <= Math.sqrt(prime); i++) {
            if (prime%i == 0) {
                return false;
            }
        }
        return true;
    }
}