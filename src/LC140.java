import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.StringBuffer;

public class LC140 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<String>();
        if (wordDict == null || s.length() == 0|| s==null){
        		return result;
        }
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        result = dfs(s, wordDict, map);
        return result;
    }
	
	public List<String> dfs(String s, List<String> wordDict, HashMap<String,List<String>> map){
		int len = s.length();
		if (map.containsKey(s)){
			return map.get(s);
		}
		List<String> result = new ArrayList<String>();
		if (len == 0){ // base case 很重要，不用忘记
			result.add("");
			map.put(s,result);
			return result;
		}
		for (String str : wordDict){
			int i = str.length();
			if (i <= len){
				if (str.equals(s.substring(len-i))){
					List<String> leftlist = dfs(s.substring(0, len-i),wordDict, map);
					for (String left : leftlist){
						StringBuffer add = new StringBuffer();
						add.append(left);
						if (i<len) add.append(" ");
						add.append(str);
						result.add(add.toString());
					}
				}
			}
		}
		map.put(s, result);
		return result;
	}
	public static void main(String[] args){
		String s = "catsanddog";
		String[] arr = {"cat", "cats", "and", "sand", "dog"};
		List<String> dict = Arrays.asList(arr);
		LC140 test = new LC140();
		System.out.println(test.wordBreak(s, dict));
	}
	
}
