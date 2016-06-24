package problems;
/***
 * 9. Palindrome Number
 * @author chandler
 *Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

Subscribe to see which companies asked this question
Solutions:
负数不回文，直接返回。需要知道x的位数和每位的数字然后进行判定
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	if(x < 0)
    		return false;
    	int len = String.valueOf(x).length();//这样算是额外使用空间了吗？
    	int head= 0,tail = 0;//每一次判定的头和尾
    	int base = (int) (Math.pow(10, len-1));
    	while(len > 1)
    	{
    		tail = x%10;
//    		System.out.println("tail:"+tail);
    		head = x/base;
//    		System.out.println("head:"+head);
    		if(head != tail)
    			return false;
    		x = x - head*base;//去除头部
    		x = x/10;//去除尾部
    		base = base/100;
    		len = len -2;
    	}
        return true;
    }
    public static void main(String args[])
    {
    	PalindromeNumber test = new PalindromeNumber();
    	int x = 1234321;
    	System.out.println(test.isPalindrome(x));
    }
}
