package problems;
/***
 * 258. Add Digits My Submissions Question
 * @author chandler
 *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *For example:
 *Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *Solution:
 *https://en.wikipedia.org/wiki/Digital_root 258和292都是通过数学分析得到的结果。
 */
public class Add_Digits {
	//数学方法
    public int addDigits(int num) {
    	
        return 1+((num-1)%9);
    }
    //给出另外一种暴力的思路
    public int addDigits2(int num){
    	num = digitadd(num);
    	while(num > 9)
    	{
    		num = digitadd(num);
    	}
    	return num;
    }
    public int digitadd(int num){
    	String s = String.valueOf(num);
    	int sum = 0;
    	//学习这种for循环的方法
    	for(char ch:s.toCharArray())
    	{
    		sum += (ch - '0');
    	}
    	return sum;
    }
    

}
