package zijie;

public class RotatedDigits {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }

    private static int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            String tmp = String.valueOf(i);
            if ((tmp.contains("2") || tmp.contains("5") || tmp.contains("6") || tmp.contains("9")) && !tmp.contains("3")  && !tmp.contains("4") && !tmp.contains("7")){
                count++;
            }
        }
        return count;
    }
}
