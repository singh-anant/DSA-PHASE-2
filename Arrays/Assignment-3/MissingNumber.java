
// User function Template for Java

class Solution {
    int missingNumber(int array[], int n) {
        // Your Code Here
        int sum = (n * (n + 1)) / 2;
        // System.out.print(sum);
        int asum = 0;
        for (int i : array)
            asum += i;

        return sum - asum;
    }
}