package problems;
/***
 * 326. Power of Three  
 * @author chandler 
 * @time 2016年3月19日15:59:35
 *Given an integer, write a function to determine if it is a power of three.
Follow up:
Could you do it without using any loop / recursion?
Solution:
循环相除？考虑能不能用二进制来解决
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {//trick 
    	//3的20次方用int无法表示·······
        return (n>0 && Math.pow(3, 19)%n == 0);
    }
    public boolean isPowerOfThree2(int n) {//递归方法
    	if (n <= 0)
    		return false;
    	if(n == 1 )
    		return true;
    	if(n % 3 == 0)
    		return isPowerOfThree(n/3);
    	return false;
    }
    public static void main(String args[])
  	{
     	PowerofThree test = new PowerofThree();
     	System.out.println(test.isPowerOfThree2(6));
  	}
}
