package zijie;

import java.util.*;

/**
 * 1057. 校园自行车分配
 * 在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。
 *
 * 我们需要为每位工人分配一辆自行车。在所有可用的自行车和工人中，我们选取彼此之间曼哈顿距离最短的工人自行车对  (worker, bike) ，并将其中的自行车分配給工人。如果有多个 (worker, bike) 对之间的曼哈顿距离相同，那么我们选择工人索引最小的那对。类似地，如果有多种不同的分配方法，则选择自行车索引最小的一对。不断重复这一过程，直到所有工人都分配到自行车为止。
 *
 * 给定两点 p1 和 p2 之间的曼哈顿距离为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。
 *
 * 返回长度为 n 的向量 ans，其中 a[i] 是第 i 位工人分配到的自行车的索引（从 0 开始）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * 输出：[1,0]
 * 解释：
 * 工人 1 分配到自行车 0，因为他们最接近且不存在冲突，工人 0 分配到自行车 1 。所以输出是 [1,0]。
 * 示例 2：
 *
 *
 *
 * 输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * 输出：[0,2,1]
 * 解释：
 * 工人 0 首先分配到自行车 0 。工人 1 和工人 2 与自行车 2 距离相同，因此工人 1 分配到自行车 2，工人 2 将分配到自行车 1 。因此输出为 [0,2,1]。
 */
public class AssignBikes {
    public static void main(String[] args) {
//        System.out.println((new AssignBikes()).assignBikes(new int[][]{{0,0},{2,1}}, new int[][]{{1,2},{3,3}}));
        System.out.println((new AssignBikes()).assignBikes(new int[][]{{0,0},{1,1},{2,0}}, new int[][]{{1,0},{2,2},{2,1}}));
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int workerLen = workers.length;
        int bikeLen = bikes.length;
        //以自行车为主体。找到每量自行车与每个人之前的距离
        HashMap<Integer, HashMap<Integer, Integer>> distanceMap = new HashMap<>();

        for (int i = 0; i < bikeLen; i++) {
            for (int j = 0; j < workerLen; j++) {
                int distance = calcDistance(workers[j], bikes[i]);
                HashMap<Integer, Integer> map = distanceMap.getOrDefault(distance, new HashMap<>());
                map.put(j, i);
                distanceMap.put(distance, map);
            }
        }
        boolean[] bikeUsed = new boolean[bikeLen];
        boolean[] workerUsed = new boolean[workerLen];
        int[] ans = new int[workerLen];
        List<Integer> list = new ArrayList<Integer>(distanceMap.keySet());
        Collections.sort(list);
        for (Integer distance : list) {
            HashMap<Integer, Integer> map = distanceMap.get(distance);
            List<Integer> workersMap = new ArrayList<Integer>(map.keySet());
            for (Integer wokerIdx : workersMap) {
                int bikeIdx =map.get(wokerIdx);
                if (!workerUsed[wokerIdx] && !bikeUsed[bikeIdx]) {
                    ans[wokerIdx] = bikeIdx;
                    workerUsed[wokerIdx] = true;
                    bikeUsed[bikeIdx] = true;
                }
            }

        }
        return ans;
    }

    public int calcDistance(int[] work, int[] bike) {
        return Math.abs(work[0] - bike[0]) + Math.abs(work[1] - bike[1]);
    }
}
