package array;

import java.util.HashMap;

public class IsValidSuduku {
    public static void main(String[] args) {
        String[][] board = new String[][] {
            {"5","3",".",".","7",".",".",".","."},
            {"6",".",".","1","9","5",".",".","."},
            {".","9","8",".",".",".",".","6","."},
            {"8",".",".",".","6",".",".",".","3"},
            {"4",".",".","8",".","3",".",".","1"},
            {"7",".",".",".","2",".",".",".","6"},
            {".","6",".",".",".",".","2","8","."},
            {".",".",".","4","1","9",".",".","5"},
            {".",".",".",".","8",".",".","7","9"}
        };
    }

    private static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] clolums = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            clolums[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int currNum = (int) num;
                    int boxIndex = i / 3 * 3 + j / 3;
                    rows[i].put(currNum, rows[i].getOrDefault(currNum, 0) + 1);
                    clolums[j].put(currNum, clolums[j].getOrDefault(currNum, 0) + 1);
                    boxes[boxIndex].put(currNum, boxes[boxIndex].getOrDefault(currNum, 0) + 1);

                    if (rows[i].get(currNum) > 1 || clolums[j].get(currNum) > 1 || boxes[boxIndex].get(currNum) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
