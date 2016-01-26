package problems;

import uitl.ListNode;

/***
 * 237 Delete Node in a Linked List
 * @author chandler
 *Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 *the linked list should become 1 -> 2 -> 4 after calling your function.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *Solution:
 * 给定的是要删除的节点 无法获取前一个节点 用后一个节点覆盖当前
 */
public class Delete_Node_in_a_LinkedList {
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }

}
