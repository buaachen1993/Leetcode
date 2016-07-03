package problems;
/***
 * 14. Longest Common Prefix 
 * @author chandler
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Solitions:
 * 判断相邻两个字符串的前缀，然后作为新的字符串和后面进行比较
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String pre = "";
        int length = strs.length;
        //先处理极端情况
        if(length == 0)
        	return pre;
        if(length == 1)
        	return strs[0];
        pre = preString(strs[0],strs[1]);
        if(length == 2)
        	return pre;
        //判断相邻两个字符串的前缀，然后作为新的字符串和后面进行比较
        for(int i = 2;i < length;i++)
        {
        	pre = preString(pre,strs[i]);
        }
        return pre;
    }
    public static String preString(String str1,String str2)
    {
    	int minLen = 0;
    	String pre = "";
    	int len = 0;
    	if(str1.length() > str2.length())
    		minLen = str2.length();
    	else
    		minLen = str1.length();
    	while(len < minLen)
    	{
    		if(str1.charAt(len) == str2.charAt(len))
    		{
    			pre += str1.charAt(len);
    			len ++;
    		}
    		else
    			break;
    	}
    	return pre;
    }
    public static void main(String args[])
    {
    	LongestCommonPrefix test = new LongestCommonPrefix();
    	System.out.println(test.preString("abc", ""));
    }
}
