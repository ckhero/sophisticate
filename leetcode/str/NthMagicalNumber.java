package str;

public class NthMagicalNumber {
    public static void main(String[] args) {
        System.out.println((new NthMagicalNumber()).gcd(2,3));
    }
    public int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}
