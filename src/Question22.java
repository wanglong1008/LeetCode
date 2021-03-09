import java.util.*;

public class Question22 {
    public List<String> generateParenthesis(int n) {
        if(n==0) return null;
        List<String> result=new ArrayList<String>();
        generate(result,n,n,"");
        return result;
    }
    public void generate(List<String> result,int left,int right,String now){
        if(left==0&&right==0){
            result.add(now);
            return;
        }
        if(left==0)generate(result,left,right-1,now+")");
        else if(left<right){
            generate(result,left-1,right,now+"(");
            generate(result,left,right-1,now+")");
        }
        else generate(result,left-1,right,now+"(");
    }

}
