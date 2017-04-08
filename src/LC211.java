/**
 * Medium - Add and Search Word - Data structure design
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * @author zy
 */

import java.util.List;
import java.util.ArrayList;

public class LC211 {
	/**
	 * This solution maybe correct, but time complexity is too large
	 * The idea is quite straight forward, iteratively compare word with 
	 * words in dictionary
	 */
	private List<String> dictionary;
    /** Initialize your data structure here. */
    public LC211() {
        dictionary = new ArrayList<String>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        dictionary.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (dictionary == null){
        		return false;
        }
        int length = word.length();
        for (int i = 0; i < dictionary.size(); i++){
        		String compare = dictionary.get(i);
        		if (length == compare.length()){
        			boolean check = true;
        			for (int j = 0 ; j < length; j++){
        				if (word.charAt(j) != compare.charAt(j) && word.charAt(j) != '.'){
        					check = false;
        				}
        			}
        			if (check == true){
        				return true;
        			}
        		}
        }
        return false;
    }
    
    public static void main (String[] args){
    		LC211 test = new LC211();
    		test.addWord("map");
    		test.addWord("bad");
    		test.addWord("dad");
    		test.addWord("mad");
    		System.out.println(test.search("pad"));
    		System.out.println(test.search("bad"));
    		System.out.println(test.search(".ad"));
    		System.out.println(test.search("b.."));

    }
}
