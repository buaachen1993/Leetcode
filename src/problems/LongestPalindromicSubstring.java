package problems;
/***
 * 5. Longest Palindromic Substring 
 * @author chandler
 *Given a string S, find the longest palindromic substring in S. 
 *You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *Subscribe to see which companies asked this question
 * Solution:
 1、暴力方法 对所有子串进行判定 substring O(n^3)
 2、动态规划   需要考虑回文中心是一个还是两个的问题
          定义二维数组P[i,j]用以表示Si…Sj是回文（true）或不是回文（false） 那么可知P[i,j] = (P[i + 1, j - 1] && Si ==Sj) 初始条件是：P[i, i]=true，P[i, i + 1] = (Si == Si+1)
          应该按照字符的长度逐步生成。
 3、对每一个回文中心进行检测 判断长度 一共有2N-1个中心 每个中心的检测需要O（N）时间
 3、Manacher算法 http://www.cnblogs.com/bitzhuwei/p/Longest-Palindromic-Substring-Par-I.html#_label1
*/

public class LongestPalindromicSubstring {
	//动态规划方法 先生成所有的P 然后从里面找出最长的来
    public String longestPalindrome(String s) {
        char[] testStr = s.toCharArray();
        int length = s.length();
        boolean[][] P = new boolean[length][length];//P[i,j]用以表示....000000000000.0Si…Sj是回文（true）或不是回文
        int i = 0,j = 0;//计数器
        int start = 0,end =0,maxLength = 0;//子串的起止位置和最长长度
        //先生成所有的初始条件
        for(i = 0; i < length ;i++) 
        {
        	P[i][i] = true;
//    		System.out.println(i+","+i+":"+P[i][i]);
        }
        for(i = 0; i < length-1 ;i++)
        {
        	P[i][i+1] = (testStr[i]==testStr[i+1]);
//    		System.out.println(i+","+(i+1)+":"+P[i][i+1]);

        }
        //生成P 按照字符长度生成    len表示子串长度
        for(int len = 3;len <= length;len ++)//前面生成了1和2长度的字符 从3开始生成
        {
        	for(i = 0;i< length - len +1;i++)
        	{
        		j = i+len-1;
        		P[i][j] = (P[i+1][j-1] && testStr[i]==testStr[j]);
//        		System.out.println(i+","+j+":"+P[i][j]);
        	}
        }

        //遍历寻找最长子串
        for(i= 0;i< length;i++)
        {        		
        	for(j = i; j < length;j++)
        	{
        		if(P[i][j] == true && (j-i)> maxLength)
        		{
        			start = i;
        			end = j;
        			maxLength = j-i;
        		}
        	}
        }
        return s.substring(start, end+1);
    }
    //对字符串生成#间隔
    public String preProcess(String s) {
            int n = s.length();
            if (n == 0) return "^$";

            String ret = "^";
            for (int i = 0; i < n; i++)
            {
                ret += "#" + s.substring(i, i + 1);
            }
            
            ret += "#$";
            return ret;
      }
      public String longestPalindrome2(String s) {
            String T = preProcess(s);
            int length = T.length();
            int[] p = new int[length];//P表示当前i位置的回文长度
            int C = 0, R = 0;
            
            for (int i = 1; i < length - 1; i++)
            {
                int i_mirror = C - (i - C);
                int diff = R - i;
                if (diff >= 0)//当前i在C和R之间，可以利用回文的对称属性
                {
                    if (p[i_mirror] < diff)//i的对称点的回文长度在C的大回文范围内部
                    { p[i] = p[i_mirror]; }
                    else
                    {
                        p[i] = diff;
                        //i处的回文可能超出C的大回文范围了
                        while (T.charAt(i + p[i] + 1) == T.charAt(i - p[i] - 1))
                        { p[i]++; }
                        C = i;
                        R = i + p[i];
                    }
                }
                else
                {
                    p[i] = 0;
                    while (T.charAt(i + p[i] + 1) == T.charAt(i - p[i] - 1))
                    { p[i]++; }
                    C = i;
                    R = i + p[i];
                }
            }

            int maxLen = 0;
            int centerIndex = 0;
            //循环寻找最大的长度和中心 
            for (int i = 1; i < length - 1; i++) {
                if (p[i] > maxLen) {
                  maxLen = p[i];
                  centerIndex = i;
                }
            }
            return s.substring((centerIndex - 1 - maxLen) / 2, (centerIndex - 1 - maxLen) / 2 + maxLen);        
        }
    

    public static void main(String args[])
    {
    	LongestPalindromicSubstring test = new LongestPalindromicSubstring();
    	System.out.println(test.longestPalindrome2("abcddcbaaaa"));
    }
}  
