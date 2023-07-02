/*
 * Question: Given a non-negative integer n, find the number of integers x such
 * that 0 <= x <= n and n & x == x
 * Input: n = 5
 * Output: 4
 * Explanation: The integers x that satisfy the condition are 0, 1, 4, and 5.
 */

class NumberOfIntegers {
    public static void main(String[] args) {
        int n = 5;
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if ((n & i) == i)
                count++;
        }
        System.out.println(count);
    }
}