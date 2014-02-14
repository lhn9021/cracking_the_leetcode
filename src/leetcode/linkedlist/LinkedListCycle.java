package leetcode.linkedlist;
/*
 * Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * http://oj.leetcode.com/problems/linked-list-cycle/
 * 
 * Hint: slow move 1 step and fast move 2 steps.
 * If fast==null||fast.next==null no cycle
 * If fast=slow, cycle
 */
public class LinkedListCycle {
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        if(head == null || head.next == null)  
	            return false;  
	        ListNode slow = head, fast = head.next;  
	        while (true) {
	            if (fast == null || fast.next == null) {
	                return false;    
	            }
	            slow = slow.next;
	            fast = fast.next.next;
	            if (fast == slow) {
	                return true;   
	            }
	        }
	    }
	}
}
