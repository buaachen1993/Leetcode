package problems;
/*
 * 169. Majority Element 
 * Description：
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
   You may assume that the array is non-empty and the majority element always exist in the array.
 * Solution：
 * 数组非空，多数元素一定存在简化了问题，采用分治算法， 去除两个不同元素之后的数组多数元素依然是多数元素。
 */
public class Majority_Element{
    public int majorityElement(int[] nums) {
    	int majorityelement = candidate(nums,0,nums.length);

    	return majorityelement;
    }
	public int candidate(int[] nums,int j,int n)
    {
    	int candidate_element = 0;
    	int count = 0;
    	candidate_element = nums[j];
    	j++;
    	while(j < n && count >= 0)
    	{
    		if(candidate_element == nums[j])
    		{
    			count ++;
    		}
    		else 
    			count --;
    		j++;
    	}
    	if(j == n)
    		return candidate_element;
    	else  
    		return candidate(nums,j,n);
    }
    public static void main(String args[])
    {
    	int nums[] = {3,2,3,4,3,5,7};
    	Majority_Element me = new Majority_Element();
//    	System.out.println(me.majorityElement(nums));
    }
}
