package problems;

import uitl.TreeNode;

/***
 * 100. Same Tree 
 * @author chandler
 *Given two binary trees, write a function to check if they are equal or not.
  Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* resolution:
*  递归实现 先对于空非空等进行判定，然后进行递归  todo 尝试迭代实现
*/
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		else if(p == null || q == null)
			return false;
		if(p.val != q.val)
			return false;
		return (isSameTree(p.left, q.left)&& isSameTree(p.right, q.right));
	
	        
	}
}
