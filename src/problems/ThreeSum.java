package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/***
 * 15. 3Sum
 * @author chandler
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
* Solution: 温兆伦题目哈哈。
* 1、三重循环肯定可以解
* 2、先进行排序 然后定位一个数转化为2-sum的问题 只需要考虑i后面的数
 */
public class ThreeSum {
    List<List<Integer>> solutions = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) 
        	return solutions;  
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len-2; i++) {  
            if (i > 0 && nums[i] == nums[i-1]) //如果相同则不需要重复寻找
            	continue;  
            find(nums, i+1, len-1, nums[i]); //寻找两个数与num[i]的和为0  
        }  
        return solutions;
    }
    public void find(int[] num, int begin, int end, int target) {//只需要考虑i后面的数,因为前面的组合肯定已经全部遍历过了
        int l = begin, r = end;  
        while (l < r) {  
            if (num[l] + num[r] + target == 0) {  
                List<Integer> ans = new ArrayList<Integer>();  
                ans.add(target);  
                ans.add(num[l]);  
                ans.add(num[r]);
                if(!solutions.contains(ans))
                	solutions.add(ans); //放入结果集中  
                while (l < r && num[l] == num[l+1]) l++;//考虑各种情况
                while (l < r && num[r] == num[r-1]) r--;
                l++;  
                r--;  
            } else if (num[l] + num[r] + target < 0) {  
                l++;  
            } else {  
                r--;  
            }  
        }  
    } 
    public static void main(String args[])
    {
    	ThreeSum test = new ThreeSum();
    	int[] array = {-1, 0, 1, 2, -1, -4};
    	System.out.println(test.threeSum(array));
    }
}
