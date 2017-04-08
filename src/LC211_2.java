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

// still something wrong, Leetcode accept already, ???
public class LC211_2 {
    /**
     * This solution use structure of tire
     * still something wrong, but Leetcode accept already, ???
     */
    class TireNode{
        TireNode[] children = new TireNode[26];
        String content = "";
    }
    
    private TireNode root = new TireNode();;
 
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TireNode node = root;
        for (char c : word.toLowerCase().toCharArray()) {  //这里要注意转化成小写字母
            if (node.children[c -'a' ] == null) {
                node.children[c -'a'] = new TireNode();
            }
            node = node.children[c -'a'];
        }
        node.content = word;
    }

    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
            return helper(word.toCharArray(), 0, root);
    }
    
    public boolean helper(char[] chars, int index, TireNode root){
            if (root == null) return false;//这个也不能省，否则直接取null的children会出错
            
            if (chars.length <= 0){
            	return false;
            }
            //下面是错误最终判断条件，这里test index== chars.length，而这个，因为当最后一个字符为‘.’时，上面会出错，和.的ASCII码有关
            //if (index>= chars.length-1){
            	//	System.out.println(chars[0]);
            //  return (root.children[chars[index]-'a'] !=null &&root.children[chars[index]-'a'].content!="") ;
            //}
            if (index == chars.length) return !root.content.equals(""); 
            if (chars[index] != '.'){
                TireNode com = root.children[chars[index]-'a'] ;
                return com != null && helper(chars,index+1, com);
            }
            for (int i =0 ; i<26 ; i++){
                if (helper(chars, index+1, root.children[i])){
                    return true;
                }
            }
            return false;
    }
    
    public static void main (String[] args){
            LC211_2 test = new LC211_2();
            String[] add = {"WordDictionary","addWord","addWord","addWord","search","search","search","search"};
            String[] searchs ={"","bad","dad","mad","sear.h","bad",".ad","b.."} ;
            for (int i = 0; i<add.length; i++){
                test.addWord(add[i]);
            }
            for (int i = 0; i<searchs.length; i++){
                System.out.print(test.search(searchs[i])+" ");
            }
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
