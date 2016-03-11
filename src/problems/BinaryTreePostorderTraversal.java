package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import uitl.TreeNode;

/***
 * 145. Binary Tree Postorder Traversal 
 * @author chandler
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
Solution:
后序遍历，左子树，右子树，根节点。

 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {//递归实现
    	List<Integer> reslist = new LinkedList<Integer>();
    	if(root == null)
    	{
    		return reslist;
    	}
    	reslist.addAll(postorderTraversal(root.left));
    	reslist.addAll(postorderTraversal(root.right));
       	reslist.add(root.val);
    	return reslist; 
    }
    //迭代实现
    public List<Integer> postorderTraversal2(TreeNode root) {
    	List<Integer> reslist = new LinkedList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();//维护一个堆栈来记录访问过程、关键是判定何时访问
    	if(root == null)
    	{
    		return reslist;
    	}
    	TreeNode cur,pre = null;//当前节点和前一个访问过的节点 因为需要记录左右都被访问后才能访问
    	stack.push(root);
    	while(!stack.isEmpty())
    	{
    		cur = stack.peek();//读取栈顶元素
    		if(cur.left == null && cur.right == null || //左右都为空可以直接访问 意味着到达了叶子节点
    				pre!= null&&(pre == cur.left || pre == cur.right) )//子节点已经全部访问过
    		{
    			reslist.add(cur.val);
    			stack.pop();//访问后退栈
    			pre = cur;
    		}
    		else{
    			if(cur.right != null)
    				stack.push(cur.right);
    			if(cur.left != null)
    				stack.push(cur.left);
    		}
    	}
    		
    	return reslist; 
    }
}
