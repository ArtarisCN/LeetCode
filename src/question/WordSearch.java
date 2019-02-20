package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2019.02.20.16:45
 * <p>
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 *
 * @author : artairs
 */
class WordSearch {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean exist(char[][] board, String word) {
        boolean result;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i * board[0].length + j);
                    result = hasChar(board, i, j, word, 1, list);
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean hasChar(char[][] board,
                                   int x,
                                   int y,
                                   String word,
                                   int index,
                                   List<Integer> list) {
        if (index == word.length()) {
            return true;
        }
        boolean result;

        if (valid(x - 1, y, board[0].length, board.length)
                && board[x - 1][y] == word.charAt(index)
                && !list.contains((x - 1) * board[0].length + y)) {
            list.add((x - 1) * board[0].length + y);
            result = hasChar(board, x - 1, y, word, index + 1, list);
            if (result) {
                return true;
            } else {
                list.remove(list.indexOf((x - 1) * board[0].length + y));
            }
        }

        if (valid(x + 1, y, board[0].length, board.length)
                && board[x + 1][y] == word.charAt(index)
                && !list.contains((x + 1) * board[0].length + y)) {
            list.add((x + 1) * board[0].length + y);
            result = hasChar(board, x + 1, y, word, index + 1, list);
            if (result) {
                return true;
            } else {
                list.remove(list.indexOf((x + 1) * board[0].length + y));
            }
        }

        if (valid(x, y - 1, board[0].length, board.length)
                && board[x][y - 1] == word.charAt(index)
                && !list.contains((x) * board[0].length + y - 1)) {
            list.add((x) * board[0].length + y - 1);
            result = hasChar(board, x, y - 1, word, index + 1, list);
            if (result) {
                return true;
            } else {
                list.remove(list.indexOf((x) * board[0].length + y - 1));
            }
        }

        if (valid(x, y + 1, board[0].length, board.length)
                && board[x][y + 1] == word.charAt(index)
                && !list.contains((x) * board[0].length + y + 1)) {
            list.add((x) * board[0].length + y + 1);
            result = hasChar(board, x, y + 1, word, index + 1, list);
            if (result) {
                return true;
            } else {
                list.remove(list.indexOf((x) * board[0].length + y + 1));
            }
        }

        return false;
    }

    private static boolean valid(int x, int y, int m, int n) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

}
