package problems;
/***
 * 136. Single Number 
 * @author chandler
 *Given an array of integers, every element appears twice except for one. Find that single one.
 *Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *Solution:
 *线性时间复杂度，不开额外空间
 *1、最暴力方法就是从第一个数开始搜索
 *2、额外开一个数组，标记次数，最后对额外数组扫一遍(哈希表)
 *3、异或运算 a ^ b = b ^ a   0 ^ a = a  a ^ a = 0
 *A XOR B = (A+B)%进制。
 */
public class Single_Number {
	public int singleNumber(int[] nums) {
		int singlenumber = 0;
		for (int i =0;i<nums.length;i++)
		{
			singlenumber = singlenumber ^ nums[i];
		}
			return singlenumber;
	}
	
	public static void main(String args[])
	{
		 Single_Number sm = new Single_Number();
		 int nums[] = {1,2,1,2,5,3,3};
		 System.out.println(sm.singleNumber(nums));
		
	}

}
