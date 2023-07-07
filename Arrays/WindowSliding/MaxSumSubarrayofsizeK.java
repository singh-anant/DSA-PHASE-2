import java.util.ArrayList;

public class MaxSumSubarrayofsizeK {
    static long maximumSumSubarray(int K, ArrayList<Integer> arr, int N) {
        // code here
        int sum = 0;
        long maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        while (end < N) {
            sum += arr.get(end);
            if ((end - start + 1) < K)
                end++;
            else if ((end - start + 1) == K) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr.get(start);
                end++;
                start++;
            }

        }
        return maxSum;
    }
}
