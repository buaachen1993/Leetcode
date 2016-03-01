package problems;

import java.util.Arrays;

/***
 * 242. Valid Anagram 
 * @author chandler
 *Given two strings s and t, write a function to determine if t is an anagram of s.
 *For example,
 *s = "anagram", t = "nagaram", return true.
 *s = "rat", t = "car", return false.
 *Note:
 *You may assume the string contains only lowercase alphabets.
 *Follow up:
 *What if the inputs contain unicode characters? How would you adapt your solution to such case?
	Solution:
 1、string.toarray 对比每一位字符
 2、排序后判断是否相等

 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
		int j = 0;
		if(s.length() != t.length())
			return false;
		for(int i = 0;i<s.length();i++)
		{
			for(j =0;j < t.length();j++)
			{
				if(chars[i] == chart[j])
				{
					chart[j] = ' ';
					break;
				}
			}
			if( j == t.length())
				return false;
		}
		return true;
	}
	public boolean isAnagram2(String s, String t) {
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
		Arrays.sort(chars);
		Arrays.sort(chart);
		//return (chars == chart);//不能直接比较字符数组
		return String.valueOf(chars).equals(String.valueOf(chart));
	}

}
