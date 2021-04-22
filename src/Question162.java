public class Question162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid + 1]) {  // 左边高，说明左边有峰值，可能mid就是
                right = mid;             // mid在下一次查找中还要考虑在内
            }else {
                left = mid + 1;   // 右边高，说明在mid右边有峰值，所以mid一定不是
            }                         // mid已经不是了，排除掉
        }
        return left;
    }
}
