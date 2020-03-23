package zijie;

public class MinCost {
    public static void main(String[] args) {
        int[][] aa = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        System.out.println((new MinCost()).minCost(aa));
    }
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int currR = 0, currG = 0, currB = 0, preR = costs[0][0], preB = costs[0][1], preG = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            currR = Math.min(preB, preG) + costs[i][0];
            currB = Math.min(preR, preG) + costs[i][1];
            currG = Math.min(preR, preB) + costs[i][2];
            preR = currR;
            preG = currG;
            preB = currB;
        }
        return Math.min(Math.min(preB, preG), preR);
    }
}
