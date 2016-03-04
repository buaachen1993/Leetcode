package problems;

import java.util.Arrays;

/***
 * 268. Missing Number
 * @author chandler
 *Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 *find the one that is missing from the array.
 *For example,
 *Given nums = [0, 1, 3] return 2.
 *Note:
 *Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *Solution:
 *1、一共有三种情况，前缺，中缺和后缺,输入是无序的
 *求和，然后用等差数列求和公式作差
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum,sumreal = 0;//sumreal是真实的和
        Arrays.sort(nums);
        if(nums[0] != 0)//前缺0可以这样解决 
        	return 0;
        for(int i = 0;i < nums.length ; i++)
        {
        	sumreal += nums[i];
        }
        sum = (0 + nums[nums.length-1])*(nums[nums.length-1] +1)/2;//等差数列求和公式
        if(sum - sumreal == 0)
        	return nums[nums.length-1]+1;
        else 
        	return sum-sumreal;
    }
    public int missingNumber2(int[] nums) {
    	  int max =0, min= nums[0], sum = 0;
    	    for(int i = 0; i < nums.length; i++){
    	        sum += nums[i];
    	        max = Math.max(max, nums[i]);
    	        min = Math.min(min, nums[i]);
    	    }
    	    int correctSum = (max + 0) * (max - 0 + 1) / 2;
    	    if(correctSum - sum == 0)
    	    {
    	    	if(min!=0)
    	    		return 0;
    	    	else
    	    		return max+1;
    	    }
    	    else 
    	    	return correctSum - sum;
    }
  
}
