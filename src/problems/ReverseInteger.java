package problems;
/***
 * 7. Reverse Integer
 * @author chandler
 *Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
Solution:
 1、每位相除 判定最大值
 2、翻转字符串需要判定0？？不需要 但是需要考虑Integer.valueof的format问题
 
 */
public class ReverseInteger {
    public int reverse(int x) {
    	int max = Integer.MAX_VALUE;
    	int min = Integer.MIN_VALUE;
    	int temp = 0;
    	long sum = 0;
    	while(x != 0)
    	{
    		temp = x%10;
    		sum = sum*10 + temp;
    		if(sum > max||sum < min)
    			return 0;
    		x = x/10;		
    	}
    	return (int) sum;

        	
    }
    public static void main(String args[]){
    	ReverseInteger test = new ReverseInteger();
    	System.out.println(test.reverse(-123));
    }
}
