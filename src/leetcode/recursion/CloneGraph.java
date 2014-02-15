package leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Clone Graph 
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * http://oj.leetcode.com/problems/clone-graph/
 * 
 * Hint: Recursive copy graph node.
 * 
 */
public class CloneGraph {
	class UndirectedGraphNode {
		      int label;
		      ArrayList<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  }
	public class Solution {
	    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        map.clear();
	        return cloneNode(node);
	    }
	    private UndirectedGraphNode cloneNode(UndirectedGraphNode node){
	        if (node == null) return null;
	        if (map.containsKey(node)) return map.get(node);
	        else{
	            UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
	            map.put(node, copy);
	            for (UndirectedGraphNode n : node.neighbors){
	                copy.neighbors.add(cloneNode(n));
	            }
	            return copy;
	        }
	    }
	}
}
