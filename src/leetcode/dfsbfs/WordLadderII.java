package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Word Ladder II 
 * 
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * http://oj.leetcode.com/problems/word-ladder-ii/
 * 
 * Hint: create data structure node to store the prev node.
 */
public class WordLadderII {
	class Node {
	    int no;
	    String val;
	    LinkedList<Node> prev;    
	    
	    Node(int no, String v) {
	        this.no = no;
	        this.val = v;
	    }
	    
	    void addPrev(Node pNode) {
	        if (prev == null) {
	            prev = new LinkedList<Node>();
	        }
	        prev.add(pNode);
	    }
	}

	public class Solution {    
	    ArrayList<ArrayList<String>> res;
	    public void findPath(Node node, ArrayList<String> cur, String start) {
	        if (node.val.equals(start)) {
	            res.add(cur);
	            return;
	        }
	        ArrayList<String> temp;
	        for (Node n : node.prev) {
	            temp = new ArrayList<String>(cur);
	            temp.add(0, n.val);
	            findPath(n, temp, start);
	        }
	    }
	    
	    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
	        HashMap<String, Node> map = new HashMap<String, Node>();
	        Queue<Node> queue = new LinkedList<Node>();
	        Node node = new Node(0, start);
	        Node endNode = null;
	        map.put(start, node);
	        queue.add(node);
	        boolean stop = false;
	        while (!queue.isEmpty() && !stop) {
	            int count = queue.size();
	            for (int i = 0; i < count; i++) {
	                node = queue.poll();
	                for (int j = 0; j < node.val.length(); j++) {
	                    StringBuilder t = new StringBuilder(node.val);
	                    for (char k = 'a'; k <= 'z'; k++) {
	                        if(node.val.charAt(j)==k) continue;
	                        t.setCharAt(j, k);
	                        if (dict.contains(t.toString())) {
	                            Node v = map.get(t.toString());
	                            if (v == null) {
	                                Node temp = new Node(node.no + 1, t.toString());
	                                temp.addPrev(node);
	                                queue.add(temp);
	                                map.put(t.toString(), temp);
	                                if (t.toString().equals(end)) {
	                                    endNode = temp;
	                                    stop = true;
	                                }
	                            }
	                            else {
	                                if (v.no == node.no + 1) {
	                                    v.addPrev(node);
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        res = new ArrayList<ArrayList<String>>();
	        if (endNode != null) {
	            findPath(endNode, new ArrayList<String>(Arrays.asList(end)), start);
	        }
	        return res;
	    }
	}
}
