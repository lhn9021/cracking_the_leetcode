package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
 * Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * http://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Hint: use priority queue. Becareful pq cannot have null listnode.
 */
public class MergeKSortedLists {
	public class Solution {
	    public ListNode mergeKLists(ArrayList<ListNode> lists) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(lists.size()==0) return null;
	        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
	            public int compare(ListNode l1,ListNode l2){
	                if(l1.val<l2.val) return -1;
	                else if(l1.val>l2.val) return 1;
	                else return 0;}});
	        for(ListNode node: lists){
	            if(node!=null)
	                pq.offer(node);
	        }
	        ListNode begin=new ListNode(-1);
	        ListNode head=begin;
	        while(!pq.isEmpty()){
	            ListNode n=pq.poll();
	            head.next=n;
	            head=head.next;
	            if(n.next!=null) pq.offer(n.next);
	        }
	        return begin.next;
	    }
	}
}
