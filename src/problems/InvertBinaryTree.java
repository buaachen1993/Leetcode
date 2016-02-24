package problems;

import uitl.TreeNode;

/***
 * 226. Invert Binary Tree 
 * @author chandler
 * Invert a binary tree.
 *  * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

 *Solution:递归问题？
 */
public class InvertBinaryTree {
	//递归实现
    public TreeNode invertTree(TreeNode root) {
    	if(root == null)
    	{
    		return root;
    	}
    	TreeNode temp = root.left;
    	root.left =  invertTree(root.right);
    	root.right = invertTree(temp);
    	return root;
    }
    //非递归实现
    
}
