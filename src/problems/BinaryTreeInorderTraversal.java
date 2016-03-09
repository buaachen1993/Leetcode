package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import uitl.TreeNode;

/***
 * 94. Binary Tree Inorder Traversal
 * @author chandler
 *Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

Solution: 中序遍历 左子树 根节点 右子树 
 迭代实现反而更慢
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> reslist = new LinkedList<Integer>();
    	if(root == null)
    	{
    		return reslist;
    	}
    	reslist.addAll(inorderTraversal(root.left));
    	reslist.add(root.val);
    	reslist.addAll(inorderTraversal(root.right));
    	return reslist; 
    }
    public List<Integer> inorderTraversal2(TreeNode root) {
    	List<Integer> reslist = new LinkedList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();//维护一个堆栈来记录访问过程、关键是判定何时访问
    	while(root!=null || !stack.isEmpty() ){
    		while(root != null)//根节点和左节点入栈
        	{
        		stack.push(root);
        		root = root.left;
        	}
        	//如果左节点全部入栈堆栈不为空，则访问
        	if(!stack.isEmpty())
        	{
        		root = stack.pop();
        		reslist.add(root.val);
        		root = root.right;	//左节点走到头开始访问右节点	
        	}
    	}
    	return reslist; 
    }
}
