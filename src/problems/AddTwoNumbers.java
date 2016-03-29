package problems;


import uitl.ListNode;

/***
 * 2. Add Two Numbers 
 * @author chandler
 * @time 2016年3月26日21:53:57
 *You are given two linked lists representing two non-negative numbers. 
 *The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
solution:依次相加 注意有进位，大数相加的原理
注意有可能l1和l2不一样长，先处理两者相同的地方然后在处理不同的高位，这里注意结果的位数。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	ListNode resNode = new ListNode(0);//结果的头结点
    	ListNode pNode = new ListNode(0);//当前节点
    	ListNode pNext = new ListNode(0);//下一个节点
    	int carry = 0;//表示进位
    	boolean isFirst = true;//表示是否是第一个节点
    	while(l1!= null && l2!= null)//共同部分
    	{
    		pNext = new ListNode(l1.val + l2.val + carry);
    		carry = pNext.val/10;
    		pNext.val = pNext.val%10;
    		if(isFirst){//是第一个节点
    			resNode = pNode = pNext;
    			isFirst = false;
    		}
    		else//不是第一个节点
    		{
    			pNode.next = pNext;
    			pNode = pNext;
    		}
    		l1 = l1.next;
    		l2 = l2.next;
    	}        
    	while(l1 != null)//l1不为0和l2不为0只会出现一个
    	{
    		pNext = new ListNode(l1.val + carry);
    		carry = pNext.val/10;
    		pNext.val = pNext.val%10;
			pNode.next = pNext;
			pNode = pNext;
			l1 = l1.next;
    	}
    	while(l2 != null)//l1不为0和l2不为0只会出现一个
    	{
    		pNext = new ListNode(l2.val + carry);
    		carry = pNext.val/10;
    		pNext.val = pNext.val%10;
			pNode.next = pNext;
			pNode = pNext;
			l2 = l2.next;
    	}
    	//处理最后的高位 一定不能忘记
    	if(carry != 0)
    	{
    		pNext = new ListNode(carry);
    		pNode.next = pNext;
    	}
    	return resNode;
    }
    public static void main(String args[])
    {
    	
    }
}
