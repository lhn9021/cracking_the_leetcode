package leetcode.string;
/*
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class ReverseWordsInAString {
	public class Solution {
		public String reverseWords(String s) {
//	 	    if(s.length()==0) return s;
//	 		StringBuilder sb = new StringBuilder();
//	 		int i = 0,j=s.length()-1;
//	 		boolean oneSpace=true;
//	 		while(j>=0&&s.charAt(j)==' '){
//	 			j--;
//	 		}
//	 		while(i<=j){
//	 			if(s.charAt(i)!=' '){
//	 				oneSpace=false;
//	 				sb.append(s.charAt(i));
//	 			}else if(s.charAt(i)==' '&&!oneSpace){
//	 				oneSpace=true;
//	 				sb.append(" ");
//	 			}
//	 			i++;
//	 		}
			StringBuilder res=new StringBuilder();
//	 		String[] splits=sb.toString().split(" ");
	        String[] splits=s.trim().replaceAll(" +"," ").split(" ");
			int i=0;
			for(;i<splits.length-1;i++){
			    res.insert(0,splits[i]);
			    res.insert(0," ");
			}
			res.insert(0,splits[i]);
			return res.toString();
		}
	}
}
