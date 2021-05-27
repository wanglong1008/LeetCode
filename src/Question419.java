public class Question419 {
    public int countBattleships(char[][] board) {
        int count=0,i=0,j=0;
        for(i=0;i<board.length;++i)
            for(j=0;j<board[0].length;++j)
                if((board[i][j]=='X')&&(i==0||board[i-1][j]=='.')&&(j==0||board[i][j-1]=='.'))
                    ++count;
        return count;
    }
}
