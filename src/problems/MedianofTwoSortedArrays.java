package problems;

import java.util.Arrays;

/***
 * 4. Median of Two Sorted Arrays 
 * @author chandler
 *There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 *Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
Solution:
	1、用两个指针去在nums1和nums2中后移，寻找第k大的数就可以了，k是两个n的平均值 偶数需要求平均，奇数直接求
	2、首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，
	这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。这两个元素比较共有三种情况：>、<和=。
	如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	int total = len1 + len2;
    	if(total % 2 == 0)//偶数返回中间两个数的平均值
    		return (kthNum2(nums1, nums2, total/2)+kthNum2(nums1, nums2, total/2+1))/2.00 ;//注意除以2.0
    	else//奇数返回中位数
    		return kthNum2(nums1, nums2, total/2+1);
    	
    }
    public int kthNum(int[] nums1, int[] nums2,int k){//寻找两个数组排序后第k大的数
    	int i = 0,j = 0;//i,j分别是nums1和nums2的指针
    	for(int m =0; m < k-1;m++)//读入k-1个从大到小的数
    	{
    		if(i >= nums1.length && j <=nums2.length)//nums1到头 nums2没到头
    			j++;
    		else if(j >=nums2.length && i <= nums1.length)//nums2到头 nums1没到头
    			i++;
    		else if(nums1[i] > nums2[j])
    			j++;
    		else
    			i++;
    	}
    	//各种考虑溢出条件
    	if(i >= nums1.length)
    		return nums2[j];
    	else if(j >= nums2.length)
    		return nums1[i];
    	else
    		return Math.min(nums1[i], nums2[j]);    	
    			
    }
    //另外一种方法 
    
    public int kthNum2(int[] nums1, int[] nums2,int k){//寻找两个数组排序后第k大的数
    	if(nums1.length > nums2.length)
    		return kthNum2(nums2, nums1, k);
    	if(nums1.length == 0)
    		return nums2[k-1];
    	if(k == 1)
    		return Math.min(nums1[0], nums2[0]);
        //divide k into two parts  
        int pa = Math.min(k / 2, nums1.length), pb = k - pa;
        //截取部分数组
        if (nums1[pa - 1] < nums2[pb - 1])  
            return kthNum2( Arrays.copyOfRange(nums1,pa,nums1.length), nums2, k - pa); 
        else if (nums1[pa - 1] > nums2[pb - 1])  
            return kthNum2(nums1, Arrays.copyOfRange(nums2,pb,nums2.length), k - pb); 
        else  
            return nums1[pa - 1];  
    }

    	


    
 
    public static void main(String args[]){
    	int[] nums1 = {1,2,3};
    	int[] nums2 = {5,6,7,8};
    	MedianofTwoSortedArrays test = new MedianofTwoSortedArrays();
    	System.out.println(test.findMedianSortedArrays(nums1, nums2));
//    	int[] arr1 = {10, 20, 30, 40, 50}; 
//    	int[] arr2 = Arrays.copyOfRange(arr1, 2, arr1.length);
//
//    	for(int i = 0; i < arr2.length; i++) 
//    		System.out.print(arr2[i] + " "); 
//    		System.out.println();
    	}
    }

