package leetcode.dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Word Ladder
 * 
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * http://oj.leetcode.com/problems/word-ladder/
 * 
 * Hint: bfs. Use hashset to avoid loop
 */
public class WordLadder {
	public class Solution {
	    public int ladderLength(String start, String end, HashSet<String> dict) {
	        Set<String> set=new HashSet<String>();
	        Queue<String> queue=new LinkedList<String>();
	        queue.offer(start);
	        int distance=1;
	        int count=1;
	        set.add(start);
	        
	        while(!queue.isEmpty()){
	        	count=queue.size();
	            while(count>0){
	                char[] curr=queue.poll().toCharArray();
	                for(int i=0; i<curr.length;i++){
	                    char tmp=curr[i];
	                    for(char c='a';c<='z';c++){
	                        if(c==tmp) continue;
	                        curr[i]=c;
	                        String str=new String(curr);
	                        if(str.equals(end)) return distance+1;
	                        if(dict.contains(str) && !set.contains(str)){
	                            queue.offer(str);
	                            set.add(str);
	                        }
	                    }
	                    curr[i]=tmp;
	                }
	                count--;
	            }
	            distance++;   
	        }
	        return 0;
	    }
	}
}
