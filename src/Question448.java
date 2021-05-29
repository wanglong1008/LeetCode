import java.util.ArrayList;
import java.util.List;

public class Question448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        //将所有正数作为数组下标，置对应数组下标元素的值为负值。
        //最后仍为正数的位置即为（未出现过）消失的数字。
        for(int i = 0; i < nums.length; i++){
            //由于有的数字是重复的，所以当该数字已经被置为负数时不再处理
            if (nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        //将仍为正数的索引+1记录下来
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) list.add(i+1);
        }
        return list;
    }
}
