package leetcode.matrix;
/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * http://oj.leetcode.com/problems/zigzag-conversion/
 * 
 * Hint: If the element is in 1st row or last row, there will be no intermediate numbers to add.
 * If not, we also need to add extra element.
 */
public class ZigZagConversion {
	public class Solution {
	    public String convert(String s, int nRows) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(nRows <= 1) return s;  
		    StringBuffer result=new StringBuffer();  
		    if(s.length() ==0) return result.toString();  
		    for(int i=0;i<nRows;i++){
		        for(int j=0,index=i;index<s.length();j++,index=i+2*j*(nRows-1)){
		            result.append(s.charAt(index));
		            if(i==0||i==nRows-1) continue;//skip if it is 1st or last row
		            if(index+2*(nRows-i-1)<s.length())
		                result.append(s.charAt(index+2*(nRows-i-1)));//adding extra element
		        }
		    }
		    return result.toString(); 
	    }
	}
}
