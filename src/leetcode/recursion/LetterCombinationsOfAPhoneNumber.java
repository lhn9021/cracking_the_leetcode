package leetcode.recursion;

import java.util.ArrayList;

/*
 * Letter Combinations of a Phone Number
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {
	public class Solution {
	    public ArrayList<String> letterCombinations(String digits) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<String> result = new ArrayList<String>();
	        char[] str = new char[digits.length()];
	        recur(digits, 0, result, str);
	        return result;
	    }
        public void recur(String digits,int index, ArrayList<String>res,char[]buf){
            if(index==digits.length()){
                res.add(new String(buf));
                return;
            }
            String s=get(digits.charAt(index)-'0');
            for(int i=0;i<s.length();i++){
                buf[index]=s.charAt(i);
                recur(digits,index+1,res,buf);
            }
        }
	    public String get (int i) {
	        String[] arr = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	        return arr[i];
	    }
	}
}
