package questions.slidingWindowPattern;

import java.util.Arrays;
import java.util.List;

/*
Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
		Example 1:
		Input: [2, 1, 5, 1, 3, 2], k=3
		Output: 9
		Explanation: Subarray with maximum sum is [5, 1, 3].
		Example 2:

		Input: [2, 3, 4, 1, 5], k=2
		Output: 7
		Explanation: Subarray with maximum sum is [3, 4]
*/
public class MaxSumSubArray {

	public static int[] getMaxSumSubArray(int[] input, int k) {
		int[] output = new int[k];
		int start = 0;
		int sum = 0;
		int maxSum = 0;
		for (int i =0; i < input.length; i++) {
			sum+=input[i];
			if(i>=k-1){
				if(start == 0){
					maxSum = sum;
				}
				else {
					if(sum > maxSum) {
						maxSum = sum;
						output = Arrays.copyOfRange(input, start, i+1);
					}
				}
				sum -= input[start];
				start++;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		int[] out1 = getMaxSumSubArray(new int[]{2, 1, 5, 1, 3, 2}, 3);
		System.out.println(Arrays.toString(out1));
		int[] out2 = getMaxSumSubArray(new int[]{2, 3, 4, 1, 5}, 2);
		System.out.println(Arrays.toString(out2));


	}
}


