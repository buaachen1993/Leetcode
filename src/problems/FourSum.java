package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 18. 4Sum
 * @author chandler
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note: The solution set must not contain duplicate quadruplets.
For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
Solutions:
采用分治算法，对数组进行预处理，求两两元素之和，然后转化成2sum的问题，一个数如果不在map里面就加入，如果在就寻找是否有target减去，如果有则返回。
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> Solutions = new ArrayList<>();
    	int len = nums.length;
    	if(nums.length < 4)
    		return Solutions;
        HashMap<Integer, List<Integer[]>> cache = new HashMap<Integer, List<Integer[]>>();  
    	Arrays.sort(nums);
    	//先预处理，得到两两数字和的数组 需要考虑如何还原 这里采用hashmap
    	for(int i = 0;i< len -1;i++)
    	{
    		for(int j = i+1;j<len;j++)
    		{
    			int sum = nums[i]+nums[j];
    			//需要记录下每个数的位置和数值 避免样例中 1 0 0 -1 出现两次的情况
                Integer[] tuple = {nums[i], i, nums[j], j};  
                if (!cache.containsKey(sum)) {  
                    cache.put(sum, new ArrayList<Integer[]>());  
                }
                //后面是一个数组的list
                cache.get(sum).add(tuple);  
    		}
    	}
    	//下面执行的本质是一个2sum的问题
        Integer[] keys = cache.keySet().toArray(new Integer[cache.size()]); //先进行排序
        for (int key : keys) {  
            if (cache.containsKey(key)) {  
                if (cache.containsKey(target - key)) {  
                	//找到了两对
                    List<Integer[]> first_pairs = cache.get(key);  
                    List<Integer[]> second_pairs = cache.get(target - key);  
                    //相同和的list
                    for (int i = 0; i < first_pairs.size(); ++i) {  
                        Integer[] first = first_pairs.get(i);  
                        for (int j = 0; j < second_pairs.size(); ++j) {  
                            Integer[] second = second_pairs.get(j);  
                            // 对第一对和第二对进行检查  
                            if (first[1] != second[1] && first[1] != second[3] &&  
                                    first[3] != second[1] && first[3] != second[3]) {  
                                List<Integer> ans = Arrays.asList(first[0], first[2], second[0], second[2]);  
                                Collections.sort(ans);  
                                if (!Solutions.contains(ans)) {  
                                	Solutions.add(ans);  
                                }  
                            }  
                        }  
                    }  
  
                    cache.remove(key);  
                    cache.remove(target - key);  
                }  
            }  
        }          

    	return Solutions;
    	
    }
    public static void main(String args[])
    {
    	FourSum test = new FourSum();
    	int[] array = {1, 0, -1, 0, -2, 2};
    	System.out.println(test.fourSum(array,0));
    }
}
