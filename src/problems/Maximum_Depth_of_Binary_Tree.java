package problems;

import uitl.TreeNode;

/***
 * 104. Maximum Depth of Binary Tree 
 * * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 *     }
 * @author chandler
 *Given a binary tree, find its maximum depth.
 *The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *Solution:
 *深度搜索,递归实现
 */
public class Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
    	if(root == null)
    	{
    		return 0;
    	}
    	int leftDepth = maxDepth(root.left);
    	int rightDepth = maxDepth(root.right);
    	if(leftDepth > rightDepth)
    		return leftDepth+1;
    	else 
    		return rightDepth+1;        
    }

}
