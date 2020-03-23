package toutiao;

import java.util.HashMap;

public class EarliestAcq {
    public static void main(String[] args) {

    }

    private static int earliestAcq(int[][] logs, int N) {
        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < logs.length; i++) {
            int currTime = logs[i][0];
            String key = logs[i][1] > logs[i][2] ?  String.valueOf(logs[i][2]) + String.valueOf(logs[i][1]) : String.valueOf(logs[i][1]) + String.valueOf(logs[i][2]);
            if (count.containsKey(key)) {
                count.put(key, Math.min(count.get(key), currTime));
            } else {
                count.put(key, currTime);
            }
        }
        int minTime = Integer.MIN_VALUE;
        for (Integer currTime : count.values()) {
            minTime = Math.max(minTime, currTime);
        }
        return minTime;
    }
}
