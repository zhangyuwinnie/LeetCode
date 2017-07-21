import java.util.*;
public class PalindromePartitioning {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0){
            return result;
        }
        dfs(s, result, new ArrayList<String>(), 0);
        return result;
    }
    public void dfs(String s, //bb
                    List<List<String>> result, //
                    List<String> curt, //
                    int start){//0
        if (start == s.length()){
            result.add(new ArrayList<String>(curt));
        }                   
        
        for (int i = start; i < s.length(); i++){//0
            String part = s.substring(start, i+1);//b
            // System.out.println(start + " "+ i + " " + part);
            if (! isPanlindrome(part)){
                continue;
            }
            curt.add(part);
            dfs(s, result, curt, i + 1); //!!! 不是start+1
            curt.remove(curt.size() - 1);
        }
    }
    public boolean isPanlindrome(String s){//!!!开始有bug
        // if (s == null){
        //     return false;
        // }
        // int index = s.length() - 1;
        // // if (len == 1){
        // //     return true;
        // // }
        // for (int i = 0; i < index/2 + 1; i++){
        //     if (s.charAt(i) != s.charAt(index--)){
        //         return false;
        //     }
        // }
        // return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}   