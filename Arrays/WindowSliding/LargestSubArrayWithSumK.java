
public class LargestSubArrayWithSumK {
    public static int largestSubArray(int arr[], int K) {
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (end < arr.length) {
            sum = sum + arr[end];
            if (sum == K)
                max = Math.max(max, end - start + 1);
            else if (sum > K) {
                while (sum > K) {
                    sum = sum - arr[start];
                    start++;
                }
            }
            end++;

        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 1, 1, 2, 3, 5 };
        System.out.println(largestSubArray(arr, 5));
    }
}
