package problems;

import java.util.Arrays;
import java.util.HashSet;

/***
 * 217. Contains Duplicate 
 * @author chandler
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * 1、对数组进行排序 然后每一位比较
 * 2、建立一个哈希表，存入的时候进行判定
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
    	Arrays.sort(nums);
    	for(int i =1;i < nums.length ; i++)
    	{
    		if(nums[i] == nums[i-1])
    			return true;
    	}	
        return false;
    }
    public boolean containsDuplicate2(int[] nums) {
    	HashSet<Integer> array = new HashSet<Integer>();
    	for(int i =0;i<nums.length;i++)
    	{
    		if(array.contains(nums[i]))
    			return true;
    		array.add(nums[i]);
    	}
    	return false;
    }
}
