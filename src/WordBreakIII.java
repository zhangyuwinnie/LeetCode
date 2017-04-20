/*
 * 基于LC139，LC140， 要求改为：当字符串可分解时，返回任意一种分解结果
 * 该解法是基于LC139基础上，从DP构建返回结果，故复杂度为O(n^2)
 * 还有单纯recursive的方法，但复杂度为O(2^n)
 */
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
public class WordBreakIII {
	//solution1:不太简洁
	private String result = "";
    public String wordBreak(String s, List<String> wordDict) {  
    		int len = s.length();
    		String result = "";
    		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    		String s1 = s;
    		if (helper(s,wordDict,map)){
    			int i = len;
    			while (i>0){
    				int a = map.get(i);
    				result = s1.substring(a)+" "+result;
    				i = a;
    				s1 = s1.substring(0, a);
    				
    			}
    			
    		}
    		
    		return result;   
    }
    public boolean helper(String s, List<String>wordDict, HashMap<Integer,Integer> map ){
        boolean[] bool = new boolean[s.length()+1];
        bool[0] = true;
        if (s.length() == 0) return false;
        for (int i = 0; i<s.length(); i++){
            for (String str : wordDict){
                if (str.length() <= i+1){
                    if (str.equals(s.substring(i-str.length()+1,i+1)) && bool[i-str.length()+1]){
                    		map.put(i+1, i-str.length()+1);
                    		bool[i+1] = true;
                    		break;
                    }
                }
            }
        }
        return bool[s.length()];
    }
    
    
    public static void main ( String[] args){
    		String s = "cattanddog";
		String[] arr = {"cat", "cats", "and", "sand", "dog"};
		String s1 = "leetcode";
		String[] arr1 = {"leet","code"};
    		List<String> dic = Arrays.asList(arr);
    		List<String> dic1 = Arrays.asList(arr1);
    		WordBreakIII test = new WordBreakIII();
    		
    		System.out.println(test.wordBreak(s, dic));
    		System.out.println(test.wordBreak(s1, dic1));
    }
}
