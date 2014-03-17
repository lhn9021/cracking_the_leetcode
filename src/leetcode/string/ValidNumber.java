package leetcode.string;
/*
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 * 
 * http://oj.leetcode.com/problems/valid-number/
 * 
 * 
 */
public class ValidNumber {
	public class Solution {
	    boolean isNumber(String c) 
		{
			c=c.trim();
			char[]s=c.toCharArray();
			int i=0;
		    boolean num = false;
		    boolean dot = false;   //decimal sign
		    boolean exp = false;   //exponential sign
		    //skip +/- sign
		    if (i<s.length && (s[i] == '+' || s[i] == '-'))++i;
		    while(i<s.length){
		        if(s[i]==' ') return false;
		        else if(s[i]<='9'&&s[i]>='0') num=true;
		        else if(s[i]=='e'){
		            if(exp||!num) return false;
		            num=false;
		            exp=true;
		        }
		        else if(s[i]=='.'){
		            if(dot||exp) return false;
		            dot=true;
		        }
		        else if(s[i]=='+'||s[i]=='-'){
		            if(s[i-1]!='e') return false;
		        }else{
		            return false;
		        }
		        i++;
		    }
		    return num;
	}
	}
}
