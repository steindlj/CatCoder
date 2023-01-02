import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Level2 {
    public static void main(String[] args) {
        String path = "./Level 2/2_4";
        File file = new File(path + ".in");
        try {
            Scanner sc = new Scanner(file).useDelimiter(",");
            int maxBid = sc.nextInt();
            int price = maxBid;
            String maxBidder = null;
            while (sc.hasNext()) {
                String currBidder = sc.next();
                int currBid = sc.nextInt();
                if (currBid > maxBid) {
                    if (maxBidder != null && !currBidder.equals(maxBidder)) {
                        price = maxBid + 1; 
                    } 
                    maxBid = currBid;
                    maxBidder = currBidder;
                } else if (currBid < maxBid) {
                    price = currBid + 1;
                } else {
                    if (maxBidder != null && !maxBidder.equals(currBidder)) {
                        price = currBid;
                    } else {
                        maxBidder = currBidder;
                    }
                }
            }
            sc.close();
            File out = new File(path + ".out");
            FileWriter writer = new FileWriter(out);
            writer.write(maxBidder + "," + String.valueOf(price));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}