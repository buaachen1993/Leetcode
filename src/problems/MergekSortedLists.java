package problems;

import uitl.ListNode;

/***
 * 23. Merge k Sorted Lists
 * @author chandler
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
   Solutions:需要参考一下合并两个sortedlist  的题目
   
  
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }
    public static void main(String args[])
    {
    	ListNode a1 = new ListNode(0);
    	ListNode a2 = new ListNode(1);
    	ListNode a3 = new ListNode(4);
    	a1.next = a2;
    	a2.next = a3;
    	ListNode b1 = new ListNode(3);
    	ListNode b2 = new ListNode(5);
    	ListNode b3 = new ListNode(7);
    	b1.next = b2;
    	b2.next = b3;
    	ListNode c1 = new ListNode(3);
    	ListNode[] nodelist = {a1,b1,c1};
    	MergekSortedLists test = new MergekSortedLists();
    	ListNode head = test.mergeKLists(nodelist);
    	while(head != null)
    	{
    		System.out.println(head.val);
    		head = head.next;
    	}

    }
}
