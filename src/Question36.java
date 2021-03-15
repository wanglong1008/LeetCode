public class Question36 {
    public boolean isValidSudoku(char[][] board) {
        char[][]a=new char[9][9];
        boolean flag=false;
        int[][]tmp2=new int[9][9];
        for(int i=0;i<9;i++){
            int []tmp=new int[9];
            for(int j=0;j<9;j++){
                int index=i/3*3+j/3;
                char k=board[i][j];
                if(k!='.'){
                    if(a[index][k-'1']==1||tmp[k-'1']==1||tmp2[j][k-'1']==1)
                        return false;
                    else {
                        tmp[k-'1']=1;
                        a[index][k - '1'] = 1;
                        tmp2[j][k-'1']=1;
                    }

                }
            }
        }
        return true;
    }
}
