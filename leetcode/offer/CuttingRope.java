package offer;

/**
 * 4- I. 剪绳子
 * 3是最优解
 */
public class CuttingRope {

    public static void main(String[] args) {
        System.out.println((new CuttingRope()).maximum69Number(996));

    }

    public int cuttingRope(int n) {
        if (n <= 3) {
            return  n -1;
        }
        int a = n % 3;
        int b = n / 3;
        int sum = 1;
        for (int i = 0; i < b-1; i++) {
            sum = sum + 3 % 1000000007;
        }
        if ( a == 0) {
            return sum + 3 % 1000000007;
        }

        if (a == 1) {
            return sum + 4 % 1000000007;
        }
        return sum + 3 * 2 % 1000000007;
    }

    public int cuttingRope2(int n) {
        if (n <= 3) {
            return  n -1;
        }
        int a = n % 3;
        int b = n / 3;
        if ( a == 0) {
            return (int)Math.pow(3, b);
        }

        if (a == 1) {
            return (int)Math.pow(3, b - 1) * 4;
        }
        return (int)Math.pow(3, b ) * 2;
    }
    public int maximum69Number (int num) {
        StringBuilder str = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '6') {
                str.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(str.toString());
    }

    /**
     *
     请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

     [["a","b","c","e"],
     ["s","f","c","s"],
     ["a","d","e","e"]]

     但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。



     示例 1：

     输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     输出：true
     示例 2：

     输入：board = [["a","b"],["c","d"]], word = "abcd"
     输出：false
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        return  false;
    }
}
