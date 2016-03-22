package problems;
/***
 * 70. Climbing Stairs
 * @author chandler
 *You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Solution:
	数学问题，暴力基本不可解。每次都看成 一个n-1和n-2的问题。
	f(n) = f(n-1) + f(n-2) 斐波那契数列
 */
public class ClimbingStairs {
    public int climbStairs(int n) {//递归方法
    	if(n < 0)
    		return 0;
        if(n <= 1)
        	return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }
    public int climbStairs2(int n) {//非递归方法
    	if(n == 0 || n == 1)
    		return 1;
    	if(n == 2)
    		return 2;
    	int cur = 2,pre = 1;//当前数和前一个数
    	int ways = 0;
    	for(int i = 3; i <= n ; i++)
    	{	
    		ways = cur + pre;
    		pre = cur;
    		cur = ways;
    	}
    	return ways;    		
    }
    public static void main(String args[])
    {
    	ClimbingStairs test = new ClimbingStairs();
    	System.out.println(test.climbStairs2(5));
    }
}
