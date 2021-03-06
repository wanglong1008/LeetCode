import java.util.*;
public class Question15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result=new HashSet<List<Integer>>();
        List<Integer> one;
        int i,j,k;
        Arrays.sort(nums);
        for(j=0;j<nums.length;j++) {
            i=0;k=nums.length-1;
            while (i < k) {
                if (i == j) {i++;continue;}
                if(k==j){k--;continue;}
                if (nums[i] + nums[j] + nums[k] == 0) {
                    one = new ArrayList<Integer>();
                    one.add(nums[i]); one.add(nums[j]); one.add(nums[k]);
                    one.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1-o2;
                        }
                    });
                    result.add(one);
                    i++;k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    i++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
            }
        }
        System.out.println(result);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> b=new ArrayList<Integer>();
        Iterator<List<Integer>> iterator = result.iterator();
        while(iterator.hasNext()){
            one=iterator.next();
            res.add(one);
        }//
        return res;
    }
}
