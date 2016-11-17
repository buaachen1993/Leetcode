package problems;

import java.util.ArrayList;
import java.util.List;

/***
 * 22. Generate Parentheses
 * @author chandler
 * @time 2016年11月17日10:53:26
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
养成测试先行的好习惯
For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * Solutions:1、遍历所有可能性 然后判定是否合法 复杂度太高
 * 2.感觉是个递归？ 在当前局面下，你有若干种选择。那么尝试每一种选择。如果已经发现某种选择肯定不行（因为违反了某些限定条件），就返回；如果某种选择试到最后发现是正确解，就将其加入解集
 * 
所谓Backtracking都是这样的思路：在当前局面下，你有若干种选择。那么尝试每一种选择。如果已经发现某种选择肯定不行（因为违反了某些限定条件），就返回；如果某种选择试到最后发现是正确解，就将其加入解集

所以你思考递归题时，只要明确三点就行：选择 (Options)，限制 (Restraints)，结束条件 (Termination)。即“ORT原则”（这个是我自己编的）

对于这道题，在任何时刻，你都有两种选择：
1. 加左括号。
2. 加右括号。

同时有以下限制：
1. 如果左括号已经用完了，则不能再加左括号了。
2. 如果已经出现的右括号和左括号一样多，则不能再加右括号了。因为那样的话新加入的右括号一定无法匹配。

结束条件是：
左右括号都已经用完。

结束后的正确性：
左右括号用完以后，一定是正确解。因为1. 左右括号一样多，2. 每个右括号都一定有与之配对的左括号。因此一旦结束就可以加入解集（有时也可能出现结束以后不一定是正确解的情况，这时要多一步判断）。

递归函数传入参数：
限制和结束条件中有“用完”和“一样多”字样，因此你需要知道左右括号的数目。
当然你还需要知道当前局面sublist和解集res。
 */
public class GenerateParentheses {
	
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack("",result,n,n);
        return result;      
    }
    /***
     * 递归算法 回溯算法
     * @param sublist 当前解
     * @param result 解集
     * @param left 剩余的左括号的个数
     * @param right 剩余的右括号的个数
     */
    public static void backtrack(String sublist,List<String> result,int left,int right)
    {
    	if(left == 0 && right == 0)//如果左右括号都用完了，说明得到了一个正确解
    	{
    		result.add(sublist);
    		return;
    	}
    	if(left > 0)//如果还有左括号，可以加入
    	{
    		backtrack(sublist + "(" ,result,left -1 ,right);
    	}
    	if(right > left)//right大于left证明还可以增加右括号
    	{
            backtrack(sublist + ")", result, left, right - 1);
    	}
    }
    public static void main(String args[]){
    	GenerateParentheses test = new GenerateParentheses();
    	List<String> result = test.generateParenthesis(3);
    	for(int i = 0;i < result.size();i++)
    	{
    		System.out.println(result.get(i));
    	}
    	
    }
}
