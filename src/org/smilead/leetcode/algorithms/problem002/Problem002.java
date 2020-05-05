package org.smilead.leetcode.algorithms.problem002;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Problem002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int nodeValue =  l1.val + l2.val;
		int temp = 0;
		if(nodeValue > 9){
			nodeValue = nodeValue % 10;
			temp = 1;
		}else {
			temp = 0;
		}
		l1 = l1.next;
		l2 = l2.next;
		ListNode head = new ListNode(nodeValue);
		ListNode tempNode = head;
		while (l1 != null && l2 != null){
			int localValue = l1.val + l2.val + temp;
			if (localValue>9){
				temp = 1;
				localValue = localValue % 10;
			}else {
				temp = 0;
			}
			tempNode.next = new ListNode(localValue);
			tempNode = tempNode.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while ( l1 != null){
			int localValue = l1.val + temp;
			if (localValue>9){
				temp = 1;
				localValue = localValue % 10;
			}else {
				temp = 0;
			}
			tempNode.next = new ListNode(localValue);
			tempNode = tempNode.next;
			l1 = l1.next;
		}
		while ( l2 != null){
			int localValue = l2.val + temp;
			if (localValue>9){
				temp = 1;
				localValue = localValue % 10;
			}else{
				temp = 0;
			}
			tempNode.next = new ListNode(localValue);
			tempNode = tempNode.next;
			l2 = l2.next;
		}
		if(temp == 1){
			tempNode.next  = new ListNode(1);
		}
		return head;

    }
    public static void main(String[] args) {
		System.out.println(Integer.BYTES);
		System.out.println(Long.BYTES);
		System.out.println(Double.BYTES);
		System.out.println(Float.BYTES);
		System.out.println(Character.BYTES);
		System.out.println(Byte.SIZE);
		System.out.println(Boolean.TYPE);
	}
}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) 
     { val = x; 
     }
 }