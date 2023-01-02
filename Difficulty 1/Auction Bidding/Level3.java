import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Level3 {
    public static void main(String[] args) {
        try {
            String path = "./Level 3/3_";
            File in = new File(path + ".in");
            Scanner sc = new Scanner(in).useDelimiter(",");
            int maxBid = sc.nextInt();
            int price = maxBid;
            String maxBidder = "-";
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            fw.write(maxBidder + "," + String.valueOf(price));
            while (sc.hasNext()) {
                String currBidder = sc.next();
                int currBid = sc.nextInt();
                if (currBid > maxBid) {
                    if (!maxBidder.equals("-") && !currBidder.equals(maxBidder)) {
                        price = maxBid + 1;
                        fw.write("," + currBidder + "," + String.valueOf(price)); 
                    } else if (maxBidder.equals("-")) {
                        fw.write("," + currBidder + "," + String.valueOf(price));
                    }
                    maxBid = currBid;
                    maxBidder = currBidder;
                } else if (currBid < maxBid) {
                    price = currBid + 1;
                    fw.write("," + maxBidder + "," + String.valueOf(price));
                } else {
                    if (!maxBidder.equals("-") && !maxBidder.equals(currBidder)) {
                        price = currBid;
                        fw.write("," + maxBidder + "," + String.valueOf(price));
                    } else if (maxBidder.equals("-")) {
                        maxBidder = currBidder;
                        fw.write("," + currBidder + "," + String.valueOf(price));
                    }
                }
            }
            sc.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
