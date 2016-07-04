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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums == null || nums.length < 3) 
        	return solutions;  
        Arrays.sort(nums);
    	int len = nums.length;
    	for(int i = 0;i < len -2;i++){//i是定位元素
            if (i > 0 && nums[i] == nums[i-1]) continue;  
            int l = i+1;
            int r = len -1;
            while(l < r)
            {
            	int sum = nums[i] + nums[l] + nums[r];
            	if(sum == 0){
                    List<Integer> ans = new ArrayList<Integer>();  
                    ans.add(nums[i]);  
                    ans.add(nums[l]);  
                    ans.add(nums[r]);
                    if(!solutions.contains(ans))
                    	solutions.add(ans); //放入结果集中  
                    while (l < r && nums[l] == nums[l+1]) l++;//考虑各种情况
                    while (l < r && nums[r] == nums[r-1]) r--;
                    //找到一组解之后同时往里移动一下
                    l++;  
                    r--;  
            	}else if (sum < 0) {  
            		l++;  
            	} else {  
            		r--;  
            	}  
            }
    	}
        return solutions;
    }

    public static void main(String args[])
    {
    	ThreeSum test = new ThreeSum();
    	int[] array = {-1, 0, 1, 2, -1, -4};
    	System.out.println(test.threeSum(array));
    }
}
