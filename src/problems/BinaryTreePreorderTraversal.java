package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import uitl.TreeNode;

/***
 * 144. Binary Tree Preorder Traversal
 * @author chandler
 *	Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
Solution:
根节点是A，左右节点分别是BC 前序遍历为 ABC
1、递归方法
2、迭代方法
 */
public class BinaryTreePreorderTraversal {
	//递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> reslist = new LinkedList<Integer>();
    	if(root == null)
    	{
    		return reslist;
    	}
    	reslist.add(root.val);
    	reslist.addAll(preorderTraversal(root.left));
    	reslist.addAll(preorderTraversal(root.right));
    	return reslist; 
    }
    //迭代实现
    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> reslist = new LinkedList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();//维护一个堆栈来记录访问过程、
    	while(root != null)
    	{
    		reslist.add(root.val);
    		if(root.right != null)//先把右节点入栈
    			stack.push(root.right);
    		if(root.left != null)
    			stack.push(root.left);
    		if(stack.isEmpty())
    			return reslist;
    		else{
    			root = stack.pop();
    		}
    	}
    	return reslist; 


    }

}
