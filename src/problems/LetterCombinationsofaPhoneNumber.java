package problems;

import java.util.ArrayList;
import java.util.List;

/***
 * 17. Letter Combinations of a Phone Number
 * @author chandler
 * Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Solutions: 先生成一个字符 然后逐个增加
2、感觉是个迭代的问题
 */
public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		String[] letterMap = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		int length = digits.length();
		List<String> ret = new ArrayList<>();
		if(length == 0)
			return ret;
		ret.add("");//关键在于先给一个值
		for(int i = 0;i< length;i++)
		{
			List<String> tempRes = new ArrayList<>();
			String letter = letterMap[Integer.valueOf(digits.charAt(i)-'0')];
			for(int j = 0;j<letter.length();j++)
			{
				for(String temp:ret){//对于每一个字符串增加一个末位
					temp = temp + letter.charAt(j);
					System.out.println(temp);
					tempRes.add(temp);
				}
			}		
			ret = tempRes;
		}
		return ret;
	}
    private final char[][] lettersMap = new char[][]{{},{},{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g','h','i'}, {'j','k','l'}, {'m', 'n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
    public List<String> letterCombinations2(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        char[] val = digits.toCharArray();
        dfs(val, 0, new StringBuilder(), results);
        return results;
    }
    //使用stringbuilder可以 提高速度
    private void dfs(char[] val, int crt, StringBuilder sb, List<String> results) {
        if (crt >= val.length) {
            results.add(sb.toString());
            return;
        }
        char[] letters = lettersMap[val[crt] - '0'];
        int len = sb.length();
        for (char l : letters) {
            sb.append(l);
            dfs(val, crt + 1, sb, results);
            sb.setLength(len);
        }
    }
    public static void main(String args[])
   	{
      	LetterCombinationsofaPhoneNumber test = new LetterCombinationsofaPhoneNumber();
      	System.out.println(test.letterCombinations2("2323"));
   	}
	
}
