public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        /*
         * int min=Integer.MAX_VALUE;
         * int currentLength=Integer.MAX_VALUE;
         * 
         * for(int i=0;i<nums.length;i++){
         * int sum=0;
         * for(int j=i;j<nums.length;j++){
         * sum+=nums[j];
         * // if(sumtarget)
         * // break;
         * if(sum>=target){
         * currentLength=j-i+1;
         * // System.out.println(currentLength);
         * break;
         * }
         * 
         * }
         * min=Math.min(currentLength,min);
         * }
         * if(min==Integer.MAX_VALUE)
         * return 0;
         * return min;
         */

        // Better solution
        int start = 0, end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        if (result == Integer.MAX_VALUE)
            return 0;
        else
            return result;
    }
}
