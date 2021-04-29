import java.util.ArrayList;
import java.util.List;

public class Question216 {
    List<List<Integer>> re=new ArrayList<>();
    List<Integer> cur=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k,n,0);
        return re;
    }
    private void helper(int k, int n,int pre){
        if(n<=pre) return;
        if(k==1&&n<=9){
            cur.add(n);
            re.add(new ArrayList<>(cur));
            cur.remove((Integer) n);
            return;
        }
        for(int i=pre+1;i<(n<=9?n:9);i++){
            cur.add(i);
            helper(k-1,n-i,i);
            cur.remove((Integer)i);
        }
    }
}
