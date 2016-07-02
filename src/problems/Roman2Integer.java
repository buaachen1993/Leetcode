package problems;
/***
 * 13. Roman to Integer 
 * @author chandler
 *Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Subscribe to see which companies asked this question
solution:
首先需要明确罗马数字的规则
https://www.douban.com/note/335254352/
从头到尾遍历，如果后一个数小于等于前一个数，则直接相加，如果后一个数大于前一个数，则相加后减去前者的两倍
先把字符数组转化为数字，然后用一个数组来记录每个数字分别表示多大的数
 */
public class Roman2Integer {
    public int romanToInt(String s) {
        int res = 0;
        char[] romanNum = s.toCharArray();
        int[] roman2int = {0,1,5,10,50,100,500,1000};//用数组位置标定的字符表示大小 
        for(int i = 0;i< romanNum.length;i++)//将字符数组转化为数字
        {
        	switch(romanNum[i])
        	{
        	case'I':
        		romanNum[i] = 1;break;
        	case'V':
        		romanNum[i] = 2;break;
        	case'X':
        		romanNum[i] = 3;break;
        	case'L':
        		romanNum[i] = 4;break;
        	case'C':
        		romanNum[i] = 5;break;
        	case'D':
        		romanNum[i] = 6;break;
        	case'M':
        		romanNum[i] = 7;break;
        	}
        }
        res = roman2int[romanNum[0]];
        for(int i =0;i < romanNum.length-1;i++)
        {
        	if(romanNum[i+1] <= romanNum[i] )//后数小于等于前数 直接相加
        		res += roman2int[romanNum[i+1]];
        	else
        		res = res + roman2int[romanNum[i+1]] - 2*roman2int[romanNum[i]];//后数大于前数，相加后减去前数二倍
        }
        return res;
    }
    public static void main(String args[])
	{
		Roman2Integer test = new Roman2Integer();
		String s = "XXIII";
		System.out.println(test.romanToInt(s));
	}
}
