import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Level3 {
    public static void main(String[] args) {
        String path = "./Level 3/3_";
        File file = new File(path + ".in");
        try {
            Scanner sc = new Scanner(file).useDelimiter(",");
            int maxBid = sc.nextInt();
            int price = maxBid;
            String maxBidder = "-";
            File out = new File(path + ".out");
            FileWriter writer = new FileWriter(out);
            writer.write(maxBidder + "," + String.valueOf(price));
            while (sc.hasNext()) {
                String currBidder = sc.next();
                int currBid = sc.nextInt();
                if (currBid > maxBid) {
                    if (!maxBidder.equals("-") && !currBidder.equals(maxBidder)) {
                        price = maxBid + 1;
                        writer.write("," + currBidder + "," + String.valueOf(price)); 
                    } else if (maxBidder.equals("-")) {
                        writer.write("," + currBidder + "," + String.valueOf(price));
                    }
                    maxBid = currBid;
                    maxBidder = currBidder;
                } else if (currBid < maxBid) {
                    price = currBid + 1;
                    writer.write("," + maxBidder + "," + String.valueOf(price));
                } else {
                    if (!maxBidder.equals("-") && !maxBidder.equals(currBidder)) {
                        price = currBid;
                        writer.write("," + maxBidder + "," + String.valueOf(price));
                    } else if (maxBidder.equals("-")) {
                        maxBidder = currBidder;
                        writer.write("," + currBidder + "," + String.valueOf(price));
                    }
                }
            }
            sc.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
