import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Level4 {
    public static void main(String[] args) {
        try {
            String path = "./Level 4/4_1";
            File file = new File(path + ".in");
            Scanner sc = new Scanner(file);
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<int[], int[]> pairs = new HashMap<>();
            int sol = 0;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            while (!isSorted(list)) {
                pairs = new HashMap<>();
                getPairs(pairs, list);
                int maxScore = Integer.MIN_VALUE;
                int[] bestPair = new int[2];
                for (int[] pair : pairs.keySet()) {
                    int score = calcScore(list, pairs, pair);
                    if (score >= maxScore) {
                        bestPair = pair;
                        maxScore = score;
                    }
                }
                reverse(list, pairs, bestPair);
                sol++;
            }
            File out = new File(path + ".out");
            FileWriter fw = new FileWriter(out);
            fw.write(String.valueOf(sol));
            fw.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void reverse(ArrayList<Integer> list, HashMap<int[],int[]> pairs, int[] pair) {
        int start = pairs.get(pair)[0];
        int end = pairs.get(pair)[1];
        if (pair[0]+pair[1] == 1) {
            end -= 1;
        } else {
            start += 1;
        }
        while (start <= end) {
            int x = list.get(start);
            int y = list.get(end);
            list.set(start++, y*-1);
            list.set(end--, x*-1);
        }
    }

    private static void getPairs(HashMap<int[],int[]> pairs, ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>(list);
        int index = 0;
        while (!newList.isEmpty()) {
            int plus = 0;
            int minus = 0;
            int elem = newList.get(0);
            if (elem < 0) {
                plus = Math.abs(elem)+1;
                minus = Math.abs(elem)-1;
            } else {
                plus = (elem+1)*-1;
                minus = (elem-1)*-1;
            }
            if (newList.contains(plus)) {
                int[] pair = new int[]{elem, plus};
                int[] idx = new int[]{newList.indexOf(elem)+index, newList.indexOf(plus)+index};
                pairs.put(pair, idx);
            }
            if (newList.contains(minus) && elem != 0 && elem != 1) {
                int[] pair = new int[]{elem, minus};
                int[] idx = new int[]{newList.indexOf(elem)+index, newList.indexOf(minus)+index};
                pairs.put(pair, idx);
            }
            index++;
            newList.remove(0);
        }
    }

    private static int calcScore(ArrayList<Integer> list, HashMap<int[],int[]> pairs, int[] pair) {
        int score = 0;
        ArrayList<Integer> newList = new ArrayList<>(list);
        reverse(newList,pairs,pair);
        while (!newList.isEmpty()) {
            int plus = 0;
            int minus = 0;
            int elem = newList.get(0);
            if (elem < 0) {
                plus = Math.abs(elem)+1;
                minus = Math.abs(elem)-1;
            } else {
                plus = (elem+1)*-1;
                minus = (elem-1)*-1;
            }
            if (newList.contains(plus)) {
                score++;
            }
            if (newList.contains(minus) && elem != 0 && elem != 1) {
                score++;
            }
            newList.remove(0);
        }
        return score;
    }

    private static boolean isSorted(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>(list);
        Collections.sort(newList);
        return newList.equals(list);
    }
}