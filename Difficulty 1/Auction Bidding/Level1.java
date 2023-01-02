import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Level1 {
    public static void main(String[] args) {
        try {
            String path = "./Level 1/1_1";
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in).useDelimiter(",");
            int maxBid = sc.nextInt();
            int price = maxBid;
            String maxBidder = null;
            while (sc.hasNext()) {
                String currBidder = sc.next();
                int currBid = sc.nextInt();
                if (currBid > maxBid) {
                    if (maxBidder != null) {
                        price = maxBid + 1;
                    } 
                    maxBid = currBid;
                    maxBidder = currBidder;
                } else if (currBid < maxBid) {
                    price = currBid + 1;
                } else {
                    if (maxBidder != null) {
                        price = currBid;
                    } else {
                        maxBidder = currBidder;
                    }
                }
            }
            sc.close();
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            fw.write(maxBidder + "," + String.valueOf(price));
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
