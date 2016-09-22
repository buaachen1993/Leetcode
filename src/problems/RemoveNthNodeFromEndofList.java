package problems;

import uitl.ListNode;

/***
 * 19. Remove Nth Node From End of List  QuestionEditorial Solution
 * @author chandler
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
Note:
Given n will always be valid.
Try to do this in one pass.

Solutions:
定义两个指针，中间相差n个位置，当后面的指针到了队尾的时候，前面一个指针指向的是我们需要的位置
给定的n一定是合理的，所以分为两个过程，先是back走n步，然后两个一起走。
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode back = new ListNode(0);
        ListNode front = new ListNode(0);
        ListNode temp = head;
        for(int i = 0;i < n;i++)
        {
        	temp = temp.next;
        }
        back = temp;
        front = head;
        if(back == null ){  //证明需要删除head,只需要后移一位head就可以
        	head = head.next;
        	return head;
        }
        if(back.next == null){
            head.next = head.next.next;
//            System.out.println("aaa");
            return head;
        }
        //需要定位到front的前面一个位置
        
        back = back.next;

        while(back != null)
        {
        	back = back.next;
        	front = front.next;
        }
        //此时的front就是我们需要删除的节点的前一个节点
        front.next = front.next.next;
        return head;
    }
    public static void main(String args[])
    {
    	RemoveNthNodeFromEndofList test = new RemoveNthNodeFromEndofList();
    	ListNode head1 = new ListNode(1);
//    	ListNode head2 = new ListNode(2);
//    	ListNode head3 = new ListNode(3);
//    	head1.next = head2;
//    	head2.next = head3;
//    	head3.next = null;
    	head1.next = null;
    	System.out.println(test.removeNthFromEnd(head1, 1).val);
    }
}
