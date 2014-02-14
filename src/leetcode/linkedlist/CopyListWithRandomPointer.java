package leetcode.linkedlist;
/*
 * Copy List with Random Pointer 
 * 
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * http://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Hint: First duplicate each node and attach to original list.
 * Then copy random pointer to duplicate nodes.
 * Finally detach duplicates
 * Remember to attach null to original list.
 */
public class CopyListWithRandomPointer {
	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		  }
	public class Solution {
	    public RandomListNode copyRandomList(RandomListNode head) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(head==null) return null;
	        RandomListNode begin=head;
	        while(begin!=null){
	            RandomListNode n=new RandomListNode(begin.label);
	            n.next=begin.next;
	            begin.next=n;
	            begin=begin.next.next;
	        }
	        begin=head;
	        while(begin!=null){
	            if(begin.random!=null)
	                begin.next.random=begin.random.next;
	            else
	                begin.next.random=null;
	            begin=begin.next.next;
	        }
	        begin=head;
	        RandomListNode newList=head.next;
	        RandomListNode res=head.next;
	        while(begin.next.next!=null){
	            begin.next=begin.next.next;
	            newList.next=newList.next.next;
	            begin=begin.next;
	            newList=newList.next;
	        }
	        begin.next=null;
	        return res;
	    }
	}
}
