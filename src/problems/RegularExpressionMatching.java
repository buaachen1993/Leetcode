package problems;
/***
 * 10. Regular Expression Matching
 * @author chandler
 *Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

Solutions : 贪心肯定不行，关键是解决*的问题
如果下一个字符不是* 只需要单独匹配就可以了
如果下一个字符是* 则需要考虑
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	//如果为0
    	if(p.length() == 0)
    		return s.length() == 0;

    	if(p.length() == 1)
    	{
    		if(s.length() != 1)
    			return false;
    		else if(p.charAt(0)!=s.charAt(0)&&p.charAt(0)!='.')
    			return false;
    		return true;

    	}
    	//如果下一个字符不是* 
    	if(p.charAt(1)!='*')
    	{
    		if(s.length() == 0)
    			return false;
    		if(p.charAt(0)!=s.charAt(0)&&p.charAt(0)!='.')
    			return false;
    		else
    			return isMatch(s.substring(1),p.substring(1));
    	}
    	else//下一个字符就是*
    	{
    		//*表示0个元素
    		if(isMatch(s,p.substring(2)))
    			return true;
    		//*表示1或多个元素
    		int i = 0;
    		while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
    			//随时判定*是否终止
    			if (isMatch(s.substring(i + 1), p.substring(2))) {
    				return true;
    			}
    			i++;
    		}
    		return false;
    				
    	}
    }
    public static void main(String args[])
    {
    	RegularExpressionMatching test = new RegularExpressionMatching();
    	String s = "a";
    	String p = ".*..a";
    	System.out.println(test.isMatch(s, p));
    	
//    	System.out.println(p.substring(1));
    }
}
