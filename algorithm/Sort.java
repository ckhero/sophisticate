import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {22,1,5,12,123,2,6};
        int[] quickArr = {22,1,5,12,123,2,6};
        System.out.println("原始数组:" + Arrays.toString(arr));
        System.out.println("冒泡排序：" + Arrays.toString(bubbleSort(arr)));
        System.out.println("选择排序：");
        System.out.println(" --结果 :" + Arrays.toString(selectSort(arr)));
        System.out.println("插入排序：");
        System.out.println(" --结果 :" + Arrays.toString(insertSort(arr)));

        System.out.println("快速排序：");
        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println(" --结果 :" + Arrays.toString(quickArr));
    }
    /**
     * 冒泡排序 O(n2)
     * @param sourceArr
     * @return
     */
    private static int[] bubbleSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
               if ( arr[j] > arr[j + 1]) {
                   int tmp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = tmp;
               }
            }
            System.out.println(" --第" + i + "次 :" + Arrays.toString(arr));

        }
        return arr;
    }

    /**
     * 选择排序
     * @param sourceArr
     * @return
     */
    private static int[] selectSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        for (int i = 0; i < arr.length; i++) {
//            System.out.println(" --第" + i + "次 :" + Arrays.toString(arr));
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * @param sourceArr
     * @return
     */
    private static int[] insertSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        for (int i = 1; i < arr.length; i++) {
            System.out.println(" --第" + i + "次 :" + Arrays.toString(arr));
            int tmp = arr[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (tmp < arr[j]) {
                    arr[j+1] = arr[j];
                    index = j;
                } else {
                    break;
                }
            }
            if (i != index) {
                arr[index] = tmp;
            }
        }
        return arr;
    }

    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort(int[] arr, int low, int high) {
//        System.out.println(" --第n次 :" + Arrays.toString(arr));
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int tmp = arr[low];
        while (i < j) {
            while (tmp <= arr[j] && i < j) {
                j--;
            }

            while (tmp >= arr[i] && i < j) {
                i++;
            }

            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = tmp;
        quickSort(arr, j + 1, high);
        quickSort(arr, low, j - 1);
    }

    public int majorityElement(int[] nums) {
         int count = 0;
         Integer ans = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
            }
            count += (ans == nums[i]) ? 1 : -1;

        }
        return ans;

    }




}
