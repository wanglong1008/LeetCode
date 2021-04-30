import java.util.ArrayList;
import java.util.List;

public class Question229 {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> ret = new ArrayList<>();
        if(nums.length < 1) return ret;
        int count1 = 0, count2 = 0;
        int major1 = nums[0], major2 = nums[0];

        for(int num : nums) {
            if(num == major1)
                count1++;
            else if(num == major2)
                count2++;
            else if(count1 == 0) {
                count1 = 1;
                major1 = num;
            }
            else if(count2 == 0) {
                count2 = 1;
                major2 = num;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(num == major1)
                count1++;
            else if(num == major2)
                count2++;
        }
        if(count1 > nums.length/3)
            ret.add(major1);
        if(major1 != major2 && count2 > nums.length/3)
            ret.add(major2);
        return ret;
    }
}
