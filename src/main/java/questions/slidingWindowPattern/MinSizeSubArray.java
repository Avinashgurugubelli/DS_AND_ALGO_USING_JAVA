package questions.slidingWindowPattern;

/*
Problem Statement #
Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
Example 3:

Input: [3, 4, 1, 1, 6], S=8
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
 */
public class MinSizeSubArray {

	private static int findMinSubArray(int s, int[] input) {
			int minLength = 0;
			int start = 0;
			int sum = 0;
			for (int i=0; i<input.length; i++) {
				sum += input[i];

				while (sum >= s) {
					minLength = Math.min(minLength, i-start+1);
					sum-=input[start];
					start++;
				}
			}
			return minLength;
	}
}
