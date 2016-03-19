package problems;
/***
 * 231. Power of Two
 * @author chandler
 *Given an integer, write a function to determine if it is a power of two.
 转化为二进制 第一位一定是1 剩余位数一定是0
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
    	if(n < 0)
    		return false;
    	char[] num = Integer.toBinaryString(n).toCharArray();
    	if(num[0] != '1')
    		return false;
    	for(int i = 1;i < num.length ;i++)
    	{
    		if(num[i] == '1')
    			return false;
    	}
        return true;
    }
    public boolean isPowerOfTwo2(int n) {//直接通过移位
    	return (n>0)&&((n&(n-1)) == 0);
    }	
    public static void main(String args[])
 	{
    	PowerofTwo test = new PowerofTwo();
    	System.out.println(test.isPowerOfTwo(-2147483648));
 	}
}
