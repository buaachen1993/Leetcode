package problems;

import uitl.ListNode;

/***
 * 21. Merge Two Sorted Lists
 * @author chandler
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Solutions:
 * 
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode head = new ListNode(0);//可以返回head.next
    	ListNode temp = head;
        while(l1 != null || l2 != null)
        {
        	ListNode cur = null;
        	if(l1 == null){
        		cur = l2;
        		l2 = l2.next;
        	}
        	else if(l2 == null){
        		cur = l1;
        		l1 = l1.next;
        	}else{
        		if(l1.val > l2.val)
        		{
        			cur = l2;
        			l2 = l2.next;
        		}
        		else{
        			cur = l1;
        			l1 = l1.next;
        		}
        	}
        	temp.next = cur;
        	temp = temp.next;
        	
        }
        return head.next;
    }
}
