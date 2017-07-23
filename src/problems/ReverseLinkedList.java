package problems;

import uitl.ListNode;

/***
 * 206. Reverse Linked List
 * @author chandler
 *Reverse a singly linked list.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Solution:
 * 创建一个新的链表，按顺序读入链表然后反向放入新链表
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null)
        	return null;
        ListNode pre = new ListNode(head.val);//前一个节点
        while(head.next != null)//当前访问节点有子节点
        {
            ListNode last = new ListNode(head.next.val);//当前节点
        	last.next = pre;
        	pre = last;
        	head = head.next;
        }
        return pre;
    }
    public ListNode reverseList2(ListNode head) {//递归方法 有点难理解
        if(head == null)
        	return null;
        if(head.next == null)
        	return head;   
        ListNode p = head.next;  
        ListNode n = reverseList2(p);   
        head.next = null;//将原节点的链接断开
        p.next = head;//加入新节点 head是原来的头，p是原来的尾
        return n;
    }
    public ListNode reverseList3(ListNode head) {//非递归方法 
        if(head == null)
        	return null;
        if(head.next == null)
        	return head;   
        ListNode pre = head; //前一个节点
        ListNode p = head.next;//当前节点  
        pre.next = null;  
        ListNode next; //下一个节点 
        while(p!=null) {  
            next = p.next;  //存储下一个节点
            p.next = pre; //建立反向链接 
            pre = p;  //整体后移
            p = next;  
        }  
        return pre;  
    }
    public static void main(String args[])
 	{
 		ReverseLinkedList test = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head.next = head2;
        head2.next = head3;
 		System.out.println(test.reverseList2(head).val);
 	}
}
