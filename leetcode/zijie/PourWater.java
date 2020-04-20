package zijie;

import java.util.Arrays;

/**
 * 给出一个地形高度图， heights[i] 表示该索引处的高度。每个索引的宽度为 1。在 V 个单位的水落在索引 K 处以后，每个索引位置有多少水？
 *
 * 水最先会在索引 K 处下降并且落在该索引位置的最高地形或水面之上。然后按如下方式流动：
 *
 * 如果液滴最终可以通过向左流动而下降，则向左流动。
 * 否则，如果液滴最终可以通过向右流动而下降，则向右流动。
 * 否则，在当前的位置上升。
 * 这里，“最终下降” 的意思是液滴如果按此方向移动的话，最终可以下降到一个较低的水平。而且，“水平”的意思是当前列的地形的高度加上水的高度。
 *  
 *
 * 我们可以假定在数组两侧的边界外有无限高的地形。而且，不能有部分水在多于 1 个的网格块上均匀分布 - 每个单位的水必须要位于一个块中。
 *
 *  [1,2,3,4,3,2,1,2,3,4,3,2,1]
 * 10
 * 2
 *
 * 示例 1：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pour-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PourWater {
    public static void main(String[] args) {
//        int[] heights = new int[]{2,1,1,2,1,2,2};
        int[] heights = new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1};
//        int[] heights = new int[]{1,2,3,4};
//        int[] heights = new int[]{3,3,1,3,3};
//        System.out.println(Arrays.toString((new PourWater()).pourWater(heights, 4, 3)));
        System.out.println(Arrays.toString((new PourWater()).pourWater(heights, 10, 2)));
//        System.out.println(Arrays.toString((new PourWater()).pourWater(heights, 2, 2)));
//        System.out.println(Arrays.toString((new PourWater()).pourWater(heights, 5, 2)));
    }

    public int[] pourWater(int[] heights, int V, int K) {
        int len = heights.length;
        int  left = K;
        int  right = K;
        int curr = heights[K];
        while (V > 0) {
            while (left - 1 >= 0 && heights[left] >= heights[left - 1]) {
                left--;
            }

        }
        return heights;
    }
}
