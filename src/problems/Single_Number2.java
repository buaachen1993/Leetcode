package problems;

import java.util.Enumeration;
import java.util.Hashtable;

/***
 * 137. Single Number II 
 * @author chandler
 *Given an array of integers, every element appears three times except for one. Find that single one.
 *Solution:
 *1、暴力方法 开一个哈希表用来check数组，对出现次数进行标记  6.19%
 *2、int 数据共有32位，可以用32变量存储 这 N 个元素中各个二进制位上  1  出现的次数，最后 在进行 模三 操作，如果为1，那说明这一位是要找元素二进制表示中为 1 的那一位。
 *3、比较难理解 利用三个变量分别保存各个二进制位上 1 出现一次、两次、三次的分布情况，最后只需返回变量一就行了

 */
public class Single_Number2 {
    public int singleNumber(int[] nums) {
    	int singlenumber = 0;
    	Hashtable<Integer,Integer > checkarray = new Hashtable<Integer,Integer>();
    	for(int i=0;i<nums.length;i++)
    	{
    		if(checkarray.containsKey(nums[i])){
    			checkarray.put(nums[i], checkarray.get(nums[i])+1);
    		}
    		else
    			checkarray.put(nums[i],1);
    	}
    	//遍历哈希表
    	Enumeration<Integer> en1 = checkarray.keys();
          while(en1.hasMoreElements()) {
        	  int num = en1.nextElement();
        	   if(checkarray.get(num)==1)
        		   singlenumber = num;         			   
         }
    	return singlenumber;
        
    }
    public int singleNumber2(int[] nums) {
    	   int[] bitnum=new int[32];  
           int res=0;  
           for(int i=0; i<32; i++){  
               for(int j=0; j<nums.length; j++){ 
            	   //向右移位 求与
                   bitnum[i]+=(nums[j]>>i)&1;  
               }  
               //按位求或
               res|=(bitnum[i]%3)<<i;  
           }  
           return res;  
    }
    public int singleNumber3(int[] nums) {
    	  int one=0, two=0, three=0;  
    	  int n=nums.length;
          for(int i=0; i<n; i++){  
              two |= one&nums[i];  
              one^=nums[i];  
              //cout<<one<<endl;  
              three=one&two;  
              one&= ~three;  
              two&= ~three;  
          }  
          return one;  
    }

    
    public static void main(String args[]){
    	Single_Number2 sm = new Single_Number2();
    	int[] nums = {-2,-2,1,1,-3,1,-3,-3,-60,-2};
//    	int[] nums = {1,1,1,1334};
//    	sm.singleNumber2(nums);
//    	System.out.println(sm.singleNumber2(nums));
    	System.out.println(0|(1<<3));
    }

}
