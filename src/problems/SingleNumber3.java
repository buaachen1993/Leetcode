package problems;
/***
 * 260. Single Number III
 * @author chandler
 *Given an array of numbers nums, in which exactly two elements appear only once and 
 *all the other elements appear exactly twice. Find the two elements that appear only once.
 *For example:
 *Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *Note:
 *The order of the result is not important. So in the above example, [5, 3] is also correct.
 *Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 
 *首先计算nums数组中所有数字的异或，记为xor
 *令lowbit = xor & -xor，lowbit的含义为xor从低位向高位，第一个非0位所对应的数字
 *例如假设xor = 6（二进制：0110），则-xor为（二进制：1010，-6的补码，two's complement）
 *则lowbit = 2（二进制：0010）
 *根据异或运算的性质，“同0异1”
 *记只出现一次的两个数字分别为a与b
 *可知a & lowbit与b & lowbit的结果一定不同
 *通过这种方式，即可将a与b拆分开来
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
    	int[] result = new int[2] ;//结果只有两位
    	int xor = nums[0];
    	for(int i = 1; i < nums.length;i++)//求全部元素的异或
    	{
    		xor = xor^nums[i];
    	}
    	result[0] = 0;
    	result[1] = 0;
    	int lowbit = xor & (-xor);//关键是找到一位1，因为两个数必定在这一位不相同
    	for(int i = 0;i < nums.length; i++){  
             if((lowbit & nums[i])!=0){  
                 result[0] = result[0] ^ nums[i];//相同的数会被异或消掉
             }else {  
                 result[1] = result[1] ^ nums[i];  
             }  
         }  
    	return result;     
    }
    public static void main(String args[])
    {
    	SingleNumber3 sn = new SingleNumber3();
    	int[] test = {1,1,2,3};
    	System.out.println(6^0);
    }
}
