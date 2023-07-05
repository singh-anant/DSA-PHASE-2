import java.util.Arrays;

class Majority {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }
    /*
     * int majorityElement(int[] num) {
     * 
     * int majority = num[0], votes = 1;
     * 
     * for (int i = 1; i < num.length; i++) {
     * 
     * if (votes == 0) {
     * votes++;
     * majority = num[i];
     * } else if (majority == num[i]) {
     * votes++;
     * } else
     * votes--;
     * 
     * }
     * return majority;
     * }
     */
}