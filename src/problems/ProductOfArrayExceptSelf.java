package problems;
/***
 * 238. Product of Array Except Self
 * @author chandler
 *Given an array of n integers where n > 1, nums, 
 *return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *Solve it without division and in O(n).
 *For example, given [1,2,3,4], return [24,12,8,6].
 *Solution:
 *1、全部乘起来，然后除以每一位原来的数,有0存在的时候非常难处理,而且题目要求不能使用除法
 *2、每位上面存储前面所有数的乘积，然后反向执行一遍 时间复杂度O（n）
 *3、
 */
public class ProductOfArrayExceptSelf {//考虑0的处理
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		for(int i = 1; i < nums.length ;i++)
		{
			res[i] = res[i-1] * nums[i-1];
		}
		int right = 1;
		for(int i = nums.length-1; i >= 0; i--)
		{
			res[i] = res[i]*right;
			right = right*nums[i];
		}
		return res;
	        
	}
}
