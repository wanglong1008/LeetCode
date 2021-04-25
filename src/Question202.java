import java.util.HashSet;

public class Question202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        return helper(n,set);
    }
    private int squareSum(int m){
        int squaresum=0;
        while(m!=0){
            squaresum+=(m%10)*(m%10);
            m/=10;
        }
        return squaresum;
    }
    private boolean helper(int n, HashSet<Integer> set){
        if(squareSum(n)==1){
            return true;
        }
        if(set.contains(n)){
            return false;
        }
        set.add(n);
        return helper(squareSum(n),set);
    }
}
