package offer;

public class LongestMountain2 {
    public static void main(String[] args) {
        int[]  A = new int[]{2,1,4,7,3,2,1};
//        int[]  A = new int[]{1,2,1};
//        int[]  A = new int[]{1,2,2};
//        int[]  A = new int[]{2,3,3,2,0,2};
//        int[]  A = new int[]{0,0,1,0,0,1,1,1,1,1};
        System.out.println((new LongestMountain2()).longestMountain(A));
    }

    public int longestMountain(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }
        int end = 0;
        int ans = 0;
        while (end < len - 1) {
            if (A[end] >= A[end + 1]) {
                end++;
                continue;
            }
            int start = end;
            while (end < len - 1 && A[end] < A[end + 1]) {
                end++;
            }

            while (end < len - 1 && A[end] > A[end + 1]) {
                end++;
                ans = Math.max(ans, end -start + 1);
            }
        }
        return ans;
    }
}
