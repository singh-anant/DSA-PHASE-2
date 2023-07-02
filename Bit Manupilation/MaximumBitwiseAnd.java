/* Question: Given an array of integers, find the maximum bitwise AND value of any two integers in the array.
Input: [3, 5, 8, 10, 12]
Output: 8
Explanation: The maximum bitwise AND value of any two integers in the array is 8, which is the result of the bitwise AND operation between 10 (1010 in binary) and 12 (1100 in binary).
 */

public class MaximumBitwiseAnd {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 8, 10, 12 };
        int maxBitWise = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int bitwiseAnd = arr[i] & arr[j];
                maxBitWise = Math.max(maxBitWise, bitwiseAnd);
            }
        }
        System.out.println(maxBitWise);
    }
}
