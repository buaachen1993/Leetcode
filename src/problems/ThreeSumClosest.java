package problems;

import java.util.Arrays;

/***
 * 16. 3Sum Closest
 * @author chandler
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *  solution:
 *  其实和3sum求和等于0的问题是相似的，不同的是在这里需要判断是否和target的差小于最小值而已。
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
    	if(nums.length < 3)
    		return 0;
    	Arrays.sort(nums);
    	int ret = 0;
    	int closestDist = Integer.MAX_VALUE;
    	int len = nums.length;
    	for(int i = 0;i < len -2;i++){//i是定位元素
            if (i > 0 && nums[i] == nums[i-1]) continue;  
            int l = i+1;
            int r = len -1;
            while(l < r)
            {
            	int sum = nums[i] + nums[l] + nums[r];

            	if(sum < target)
            	{
            		if(target - sum < closestDist){
            			closestDist = target - sum;
            			ret = sum;
            		}
            		l++;
            	}else if(sum > target)
            	{
            		if(sum - target < closestDist){
            			closestDist = sum - target;
            			ret = sum;
            		}
            		r--;
            	}
            	else//sum = target
            		return sum;
            }
    	}
    	return ret;
    
    }


    public static void main(String args[])
	{
		ThreeSumClosest test = new ThreeSumClosest();
		int[] nums = {0,1,2};
		int target = 0;
		System.out.println(test.threeSumClosest(nums, target));
	}
}
