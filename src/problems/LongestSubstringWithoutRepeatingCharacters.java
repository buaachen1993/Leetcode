package problems;

import java.util.HashSet;

/***
 * 3. Longest Substring Without Repeating Characters 
 * @author chandler
 *Given a string, find the length of the longest substring without 
 *repeating characters. For example, the longest substring without 
 *repeating letters for "abcabcbb" is "abc", which the length is 3.
For "bbbbb" the longest substring is "b", with the length of 1.
Solution:1、最暴力的方法，两层循环
2、用一个数组记录每一个字母出现的最后一次的位置，然后更新相应的子串头和子串长度，
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0;//left定义了子串的开头  
        int  last[] = new int[128];  
        for (int i = 0; i < 128; ++i)//初始化last数组  
            last[i] = -1;  
        for (int i = 0; i < s.length(); i++) 
        {  
            if (last[s.charAt(i)] >= left)//当前字符的上次出现位置在子串开头之后，则缩短子串  
                left = last[s.charAt(i)] + 1;  
            last[s.charAt(i)] = i; //更新位置
            if (maxLen < i - left + 1) // 如果最长子串小于当前子串长度
                maxLen = i - left + 1;  
        }  
        return maxLen;  
    }
}
