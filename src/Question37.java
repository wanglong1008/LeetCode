public class Question37 {
    public void solveSudoku(char[][] board) {
        int[][] a = new int[9][9];
        int[][] tmp2 = new int[9][9];
        int[][] tmp1 = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int index = i / 3 * 3 + j / 3;
                char kk = board[i][j];
                if (kk!='.') {
                    a[index][kk - '1'] = 1;
                    tmp2[j][kk - '1'] = 1;
                    tmp1[i][kk-'1']=1;
                }
            }
        }
        boolean flaag = hasSolution(board, tmp1,tmp2, a, 0, 0);
        System.out.println(flaag);
        for (char[] c : board) {
            for (char d : c) {
                System.out.println(d);
            }
        }
    }

    boolean hasSolution(char[][] board,  int[][] tmp1,int[][] tmp2, int[][] a, int x, int y) {
        boolean flag = false;
        int index = x / 3 * 3 + y / 3;
        if (x > 8 || y > 8) return true;
        if (board[x][y] != '.') {
            flag = flag || hasSolution(board,tmp1, tmp2, a, y == 8 ? x + 1 : x, y == 8 ? 0 : y + 1);
        }else{
            for (char k = '0'; k < '9'; k++) {
                if (a[index][k - '0'] == 1 || tmp1[x][k - '0'] == 1 || tmp2[y][k - '0'] == 1) {
                    flag = flag || false;
                } else {
                    board[x][y] = (char) (k + 1);
                    a[index][k - '0'] = 1;
                    tmp2[y][k - '0'] = 1;
                    tmp1[x][k-'0']=1;
                    flag = flag || hasSolution(board, tmp1,tmp2, a, y == 8 ? x + 1 : x, y == 8 ? 0 : y + 1);if(flag==false){
                        board[x][y]='.';
                        a[index][k - '0'] = 0;
                        tmp2[y][k - '0'] = 0;
                        tmp1[x][k-'0']=0;
                    }
                }

            }
        }

        return flag;
    }
}
