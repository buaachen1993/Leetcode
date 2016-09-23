package problems;

import java.util.Stack;

/***
 * 20. Valid Parentheses 
 * @author chandler
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 
 * Solution:构造一个栈，左括号入栈，右括号来的时候和栈顶进行匹配，然后弹出来。
 *
 */
public class Valid_Parentheses {
	public boolean isValid(String s){
		Stack<Character> stack = new Stack();
		char[] string = s.toCharArray();
		for(int i = 0; i < s.length();i++)
		{
			if(string[i] == '{'||string[i]  == '(' || string[i]  == '[')
				stack.push(string[i]);
			else if(string[i] == ')'){
				if(stack.isEmpty() ||stack.pop() != '(')
					return false;
			}
			else if(string[i] == '}'){
				if(stack.isEmpty() ||stack.pop() != '{')
					return false;
			}
			else if(string[i] == ']'){
				if(stack.isEmpty() ||stack.pop() != '[')
					return false;
			}		
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	public static void main(String args[]){
		Valid_Parentheses test = new Valid_Parentheses();
		System.out.println(test.isValid("{{["));
	}
}
