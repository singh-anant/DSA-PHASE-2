import java.util.Arrays;

class Majority {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }
}