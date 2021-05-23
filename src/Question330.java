public class Question330 {
    public int minPatches(int[] nums, int n) {
        int count = 0, i = 0;
        long cur = 0;
        while (cur < n) {
            if (i == nums.length || cur + 1 < nums[i]) {
                cur += cur + 1;
                count += 1;
            } else {
                cur += nums[i];
                i++;
            }
        }
        return count;
    }
}
