package problems;
/***
 * 319. Bulb Switcher 
 * @author chandler
 *There are n bulbs that are initially off. You first turn on all the bulbs. 
 *Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). 
 *For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. 
 *Find how many bulbs are on after n rounds.
Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.

 Solution:
 1、根据题意理解直接做就可以了,每轮switch的是i的倍数
 2、可以看出，非平方数的因数总是成对出现的，只有平方数的因数才是奇数，因为平方数除平方根外，其他的因数都是成对出现的！
           对于当前的开关灯泡问题，可知到最后处在平方数位置的灯泡一定是开启的，其他位置的灯泡一定是关闭的。
           而要计算一个数之下有多少小于或等于它的平方数，使用一个开平方用的函数就可以了 
 */
public class BulbSwitcher {
	   public int bulbSwitch(int n) {
		   if(n == 0)
			   return 0;
		   return (int) Math.sqrt(n);
	   }
}
