package problems;

import java.util.HashMap;
import java.util.Map;

/***
 * 1. Two Sum
 * @author chandler
 * Given an array of integers, return indices of the two numbers such that
 *  they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
The return format had been changed to zero-based indices. Please read the above updated description carefully.

Solution: 暴力方法，两层循环
2、空间换时间 采用hashmap 一个数如果不在map里面就加入，如果在就寻找是否有target减去，如果有则返回。
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for(int i = 0; i < nums.length-1 ;i++)
        {
        	for(int j = i+1 ; j < nums.length ;j++)
        	{
        		if(nums[i] + nums[j] == target)
        		{
        			indices[0] = i;
        			indices[1] = j;
        			return indices;
        		}
        	}
        }
        return indices;
    }
    public int[] twoSum2(int[] nums, int target) {//hashtable key是值 value是数组下标
        int[] indices = new int[2];
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length ;i++)
        {
        	if(numMap.containsKey(target-nums[i]))
            {
            	indices[0] = numMap.get(target-nums[i]);
            	indices[1] = i;
            	return indices;
            }
            numMap.put(nums[i],i );
        }
        return indices;
    }
    public static void main(String args[])
    {
    	int[] nums = {0,4,3,0};
    	int target = 0;
    	TwoSum test = new TwoSum();
    	System.out.println(test.twoSum2(nums,target)[1]);
    }
}
