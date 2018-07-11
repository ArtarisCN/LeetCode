package question;

/**
 * question
 * LeetCode
 * 2018.07.10.下午5:31
 * <p>
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * @author : rick
 */
class SurroundedRegions {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


//        char[][] island = {{'O', 'O', 'O', 'O'},
//                {'O', 'O', 'O', 'O'},
//                {'O', 'O', 'O', 'O'},
//                {'O', 'O', 'O', 'O'}};

//        char[][] island = {{'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}};

//        char[][] island = {{'X', 'O', 'X'},
//                {'O', 'X', 'O'},
//                {'X', 'O', 'X'}};

        char[][] island = {{'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}};

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                System.out.print(island[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("");

        solve(island);

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                System.out.print(island[i][j] + " ");
            }
            System.out.println("");
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return ;
        }

        char[][] newBoard = new char[board.length][board[0].length];
        reset(board,newBoard);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O'){
                    if(dfs(newBoard,i,j)){
                        remake(board,i,j);
                    }
                    reset(board,newBoard);
                }
            }
        }
    }

    private static void reset(char[][] board,char[][] newBoard){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
    }


    private static boolean dfs(char[][] board, int i, int j) {

        if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O'){
            return false;
        }

        if (board[i][j] == 'O') {
            board[i][j] = 'X';

            return dfs(board, i - 1, j) &&
                    dfs(board, i + 1, j) &&
                    dfs(board, i, j - 1) &&
                    dfs(board, i, j + 1);
        } else if(board[i][j] == 'X' ){
            return true;
        }
        return false;
    }


    private static void remake(char[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if(board[i][j] == 'O'){
            board[i][j] = 'X';

            remake(board,i - 1,j);
            remake(board,i + 1,j);
            remake(board,i ,j - 1);
            remake(board, i, j + 1);
        }
    }
}
