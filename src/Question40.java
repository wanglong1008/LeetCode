import java.util.*;

public class Question40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        find(result,list,candidates,target,0,-1);
        HashSet<List<Integer>> result1=new HashSet<List<Integer>>(result);
        List<List<Integer>> result2=new ArrayList<List<Integer>>(result1);
        return result2;
    }
    public void find(List<List<Integer>> result,List<Integer> list,int[] candidates, int target,int now,int i){
        if(i==candidates.length) return;
        for(int j=i+1;j<candidates.length;j++){
            if(now+candidates[j]==target){
                list.add(candidates[j]);
                List<Integer> list1=new ArrayList<Integer>(list);
                result.add(list1);
                list.remove((Integer)(candidates[j]));
            }
            else if(now+candidates[j]<target){
                list.add(candidates[j]);
                find(result,list,candidates,target,now+candidates[j],j);
                list.remove((Integer)(candidates[j]));
            }
            else return;
        }
    }
}
