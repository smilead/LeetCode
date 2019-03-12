package org.smilead.leetcode.algorithms.problem002;


public class Problem002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	boolean flag = false;
    	int first = l1.val + l2.val;
    	ListNode head = null;
    	if(first>9) {
    		flag = true;
    		head = new ListNode(first%10);
    	}else {
    		head = new ListNode(first);
    	}
    	ListNode node = head;
    	l1 = l1.next;
    	l2 = l2.next;
    	while(l1 !=null && l2!=null) {
    		int local = l1.val+l2.val;
    		if(flag) {
    			flag = false;
    			local++;
    		}
    		if(local>9) {
    			node .next = new ListNode(local%10);
    			flag = true;
    		}else {
    			node.next = new ListNode(local);
    		}
    		l1 = l1.next;
    		l2 = l2.next;
    		node = node.next;
    	}
    	while(l1!=null) {
    		int local = l1.val;
    		if(flag) {
    			flag = false;
    			local++;
    		}
    		if(local>9) {
    			node.next = new ListNode(local%10);
    			flag = true;
    		}else {
    			node.next = new ListNode(local);
    		}
    		l1 = l1.next;
    		node = node.next;
    	}
    	while(l2!=null) {
    		int local = l2.val;
    		if(flag) {
    			flag = false;
    			local++;
    		}
    		if(local>9) {
    			node.next = new ListNode(local%10);
    			flag = true;
    		}else {
    			node.next = new ListNode(local);
    		}
    		l2 = l2.next;
    		node = node.next;
    	}
    	if(flag) {
    		node.next = new ListNode(1);
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
