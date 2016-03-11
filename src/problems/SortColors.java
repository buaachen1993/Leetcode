package problems;
/***
 * 75. Sort Colors 
 * @author chandler
 *Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Subscribe to see which companies asked this question
Solution:
1、统计012的个数然后重写一遍数组
2、扫描一遍，把0放到前面，2放到后面  用一个另外的标志位记位
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int zero = 0,two = 0;//作为0和2的指针 
		int temp = 0;//用于交换
		for(int i = 0;i < nums.length - two ;i++)//特别注意不需要访问已经换到后面去的2
		{
			if(nums[i] == 0)
			{
				temp = nums[i];
				nums[i] = nums[zero];
				nums[zero] = temp;
				zero++;//zero一定是小于等于i的 所以不用判定新元素
			}
			else if(nums[i] == 2)
			{
				temp = nums[i];
				nums[i] = nums[nums.length-1-two];
				nums[nums.length-1-two] = temp;
				two++;
				i--;//特别注意交换后的元素需要判定一次
			}
		}
		
	}
	public static void main(String args[])
	{
		SortColors test = new SortColors();
		int[] nums = {2};
		test.sortColors(nums);
	}
	
}
