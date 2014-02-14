package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Anagrams 
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * http://oj.leetcode.com/problems/anagrams/
 * 
 * Hint: sort every string and put it in arraylist
 */
public class Anagrams {
	public class Solution {
	    public ArrayList<String> anagrams(String[] strs) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int n=strs.length;
	        ArrayList<String> result=new ArrayList<String>();
	        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
	        for(int i=0;i<strs.length;i++){
	            char[] tmp=strs[i].toCharArray();
	            Arrays.sort(tmp);
	            String s= new String(tmp);
	            if(map.containsKey(s)){
	                map.get(s).add(strs[i]);
	            }else{
	                ArrayList<String> list=new ArrayList<String>();
	                list.add(strs[i]);
	                map.put(s,list);
	            }
	        }
	        for(ArrayList<String> l:map.values()){
	            if(l.size()>1)
	                result.addAll(l);
	        }
	        return result;
	    }
	}
}
