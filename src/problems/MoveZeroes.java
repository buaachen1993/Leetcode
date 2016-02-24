package problems;
/***
 * 
 * 283. Move Zeroes My Submissions Question
 * @author chandler
 *	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 	Solution:
 	1、每次遇到非零的数就和最前面的一个0交换位置，直到读到队末//如何确定最前面的0 如果每次扫一遍还是很麻烦
 	2、实际上就是将所有的非0数向前尽可能的压缩，最后把没压缩的那部分全置0就行了。比如103040，先压缩成134，剩余的3为全置为0。过程中需要一个指针记录压缩到的位置。
*/
public class MoveZeroes {
	 public void moveZeroes(int[] nums) {
		 int n = nums.length;
		 int i = 0;
		 int zeroposition = 0;//记录最前面的0的位置
		 while(i < n && nums[i] != 0  )
		 {
			 i++;
		 }
		 zeroposition = i;
		 int temp = 0;
		 for( i = 0; i < n ; i++)//顺序读一遍数组
		 {
			 if(nums[i] == 0 && i < zeroposition)
			 {
				 zeroposition = i;
			 }
			 if(nums[i] != 0 && zeroposition < i &&nums[zeroposition] == 0 )
			 {
				 nums[zeroposition] = nums[i];
				 nums[i] = 0;
				 //换位之后重新定位zeroposition
				 temp = i;
				 i = zeroposition;
				 zeroposition = temp;
			 }
		 }
	 }
	 public void moveZeroes1(int[] nums) {
		 int pos = 0;
		 int n = nums.length;
		 for(int i =0; i < n ;i++)
		 {
			 if(nums[i] != 0)
			 {
				 nums[pos] = nums[i]; 
				 pos++;
			 }
		 }
		 for (;pos < n;pos++)
		 {
			 nums[pos] = 0;
		 }
	 }


}
