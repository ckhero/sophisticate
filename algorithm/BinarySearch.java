/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2019/12/6
 * Time: 5:34 PM
 */
public class BinarySearch {
    public static void main(String[] args) throws Exception {
        try {
            int[] arr = {1,2,3,5};
            int key = 5;
            System.out.println("res = " + unRecursion(arr, key));
            System.out.println("res = " + recursion(arr, key, 0, arr.length - 1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 非递归
     * @param arr
     * @param key
     * @return
     * @throws Exception
     */
    private static int unRecursion(int[] arr, int key) throws Exception {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key) {
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        throw new Exception("don't match anykey");
    }

    /**
     * 递归
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     * @throws Exception
     */
    private static int recursion(int[] arr, int key, int low, int high) throws Exception {
        if (low > high) {
            throw new Exception("don't match anykey");
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[mid] > key) {
            return recursion(arr, key, low, mid - 1);
        } else {
            return recursion(arr, key, mid + 1, high);
        }
    }
}
