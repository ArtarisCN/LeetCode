package question;

/**
 * question
 * LeetCode
 * 2019.05.07.16:27
 * <p>
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 *
 * @author : artairs
 */
class ValidSudoku {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        char c  = '!';
        System.out.println(c);
        System.out.println(Integer.valueOf(c));
        int x = Integer.valueOf(c);
        int mask = (1 << 36);
        System.out.println(Integer.toBinaryString(mask));
        System.out.println(mask);
//        mask = (1 << 1);
//        System.out.println(Integer.toBinaryString(mask));
//        c = '9';
//        mask = (1 << c);
//        System.out.println(Integer.toBinaryString(mask));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) {
                return false;
            }

            if (!checkCol(board, i)) {
                return false;
            }

            if (!checkSquare(board, i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkRow(char[][] board, int row) {
        int[] index = new int[9];
        for (char c : board[row]) {
            if (c != '.') {
                if (index[c - '1'] == 1) {
                    return false;
                } else {
                    index[c - '1'] = 1;
                }
            }
        }
        return true;
    }

    private static boolean checkCol(char[][] board, int col) {
        int[] index = new int[9];
        for (int i = 0; i < 9; i++) {
            char c = board[i][col];
            if (c != '.') {
                if (index[c - '1'] == 1) {
                    return false;
                } else {
                    index[c - '1'] = 1;
                }
            }
        }
        return true;
    }

    private static boolean checkSquare(char[][] board, int num) {
        int col = 0, row = 0;
        switch (num) {
            case 0: col = 0;row = 0;break;
            case 1: col = 3;row = 0;break;
            case 2: col = 6;row = 0;break;
            case 3: col = 0;row = 3;break;
            case 4: col = 3;row = 3;break;
            case 5: col = 6;row = 3;break;
            case 6: col = 0;row = 6;break;
            case 7: col = 3;row = 6;break;
            case 8: col = 6;row = 6;break;
            default: break;
        }
        int[] index = new int[9];
        int colN = col;
        for (int i = 0; i < 9; i++) {
            char c = board[row][colN];
            if (c != '.') {
                if (index[c - '1'] == 1) {
                    return false;
                } else {
                    index[c - '1'] = 1;
                }
            }
            colN++;
            if (colN >= col + 3) {
                colN = col;
                row++;
            }
        }
        return true;
    }
}
