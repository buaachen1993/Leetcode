package problems;
/***
 * 41. First Missing Positive 
 * @author chandler
 *Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.


Solutions:
1、排序然后扫一遍，因为题目中给的元素有重复，所以不能用missingnumber的方法。
2、a[i]上面的数应该是i+1 扫描一遍把所有的正数归位，再扫面一遍确定出问题的位置
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
        	while(nums[i]!=i+1){
        		if(nums[i]<=0 || nums[i] >= nums.length ||nums[i]==nums[nums[i]-1]) break;//第二个判定条件是为了防止缺少1的情况
        		//swap
        		int temp = nums[i];
        		nums[i] = nums[nums[i]-1];
        		nums[temp-1] = temp;
        	}
        	
        }

        for(int i=0;i<nums.length;i++){
  
        	if(nums[i]!=i+1)
        		return i+1;
        }
        return nums.length+1;
    }
    public static void main(String args[]){
    	FirstMissingPositive test = new  FirstMissingPositive();
    	int[] nums = {2,3,4};
    	System.out.println(test.firstMissingPositive(nums));
    }
}
