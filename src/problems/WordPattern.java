package problems;

import java.util.HashMap;

/***
 * 290. Word Pattern 
 * @author chandler
 *Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a
 letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 solution:如果pattern相同 则string相同 循环判定 出错return
 用一个map来存放char和string的对应关系更加符合数据结构的理解
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
    	String[] string = str.split(" ");
    	char[] patternChar = pattern.toCharArray();
    	if(string.length != pattern.length())
    		return false;
    	for(int i = 0;i < pattern.length();i++)
    	{
    		for(int j = 0;j < i;j++)//当前位置为i 需要和前面所有的j比较
    		{
    			if(patternChar[i] == patternChar[j])//pattern相同，则string必须相同
    			{
    				if(!string[i].equals(string[j]))
    					return false;
    			}
    			else//pattern不同
    			{
    				if(string[i].equals(string[j]))
    					return false;
    			}				
    		}
    	}
        return true;
    }
    public boolean wordPattern2(String pattern, String str) {//采用map存储pattern和string 效率提高
    	String[] string = str.split(" ");
    	if(pattern.length() != string.length)
    		return false;
    	HashMap<Character, String> refer = new HashMap<>();
    	for(int i = 0;i < pattern.length();i++)
    	{
    		if(refer.containsKey(pattern.charAt(i)))//是现有模式
    		{
    			if(!refer.get(pattern.charAt(i)).equals(string[i]))//判定是否相等
    				return false;
    		}
    		else{//不是现有模式
    			if(refer.containsValue(string[i]))//如果包含现有字符串
    				return false;
    			refer.put(pattern.charAt(i), string[i]);
    		}
    	}
    	return true;

    	
    }
    public static void main(String args[])
  	{
    	WordPattern test = new WordPattern();
    	System.out.println(test.wordPattern2("abba", "dog dog dog dog"));
  	}
}
