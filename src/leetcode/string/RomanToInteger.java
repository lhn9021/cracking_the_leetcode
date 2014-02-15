package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Roman to Integer 
 * 
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * http://oj.leetcode.com/problems/roman-to-integer/
 * 
 * Hint: IV mean +5 and -1. If current value is less than next value, we need minus current value
 */
public class RomanToInteger {
	public class Solution {
	    public int romanToInt(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int length=s.length();
	        Map<Character,Integer> map=new HashMap<Character,Integer>();
	        map.put('I',1);
	        map.put('V',5);
	        map.put('X',10);
	        map.put('L',50);
	        map.put('C',100);
	        map.put('D',500);
	        map.put('M',1000);
	        int result=0;
	        for(int i=0;i<length-1;i++){
	            if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
	                result-=map.get(s.charAt(i));
	            }else{
	                result+=map.get(s.charAt(i));
	            }
	        }
	        result+=map.get(s.charAt(length-1));
	        return result;
	    }
	}
}
