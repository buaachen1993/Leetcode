package problems;
/***
 * 338. Counting Bits 
 * @author chandler
 *Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
Show Hint 

Solution:
分析规律，所有的奇数位都比偶数位大1，只需要研究偶数位的规律即可。
针对一个偶数 当他翻倍的时候，相当于增加了一个0，但是1的个数并没有发生变化
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        bits[0] = 0;
        for(int i = 1;i <= num;i++)
        {
        	if(i%2 == 0)
        		bits[i] = bits[i/2];//和前一位偶数的1个数相同
        	else
        		bits[i] = bits[i-1] + 1;//前一位偶数加一
        }
        return bits;
    }
}
