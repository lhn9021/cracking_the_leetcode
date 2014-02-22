package other;
public class TrieTest {
	   public static void main(String[] args) {
	        Trie dict = new Trie();        
	        dict.insert("are");
	        dict.insert("are");
	        dict.insert("area");
	        dict.insert("base");
	        dict.insert("cat");
	        dict.insert("cater");        
	        dict.insert("basement");
	        dict.insert("basement");
	        dict.insert("basement");
	        dict.insert("basement");
	        
	        String input = "caterer";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              

	        input = "basement";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));   
	        System.out.println(dict.getCount("basement"));
	        
	        
	        input = "are";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input)); 
	        System.out.println(dict.getCount("are"));

	        input = "arex";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              

	        input = "basemexz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));                      
	        
	        input = "xyz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));                      
	    }
	}
