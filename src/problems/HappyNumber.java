package problems;
/***
 * 202. Happy Number 
 * @author chandler
 *Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer,
 replace the number by the sum of the squares of its digits, 
 and repeat the process until the number equals 1 (where it will stay), 
 or it loops endlessly in a cycle which does not include 1. 
 Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
solution:
不是happy number的时候是一个死循环，需要考虑什么时候才能放回false
从百度百科得知：所有不快乐数的数位平方和计算，最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
 */
public class HappyNumber {
    public boolean isHappy(int n) {
    	if(n <= 0)
    		return false;
    	char[] num = String.valueOf(n).toCharArray();
    	int sum = 0,i = 0;
    	while(true)
    	{
    		for(i = 0;i < num.length ;i++)
    		{
    			String temp = ""+ num[i];
    			sum += Integer.parseInt(temp)*Integer.parseInt(temp);
    		}
    		if(sum == 1)
    			return true;
    		if(sum == 4)
    			return false;
    		num = String.valueOf(sum).toCharArray();
    		sum = 0;
    	}
    	
    }
    public static void main(String args[])
   	{
      	HappyNumber test = new HappyNumber();
      	System.out.println(test.isHappy(37));
   	}
}
