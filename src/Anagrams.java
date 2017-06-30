import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
public class Anagrams {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return result;
        }
        
        // put into hash
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++){
            char[] ary = strs[i].toCharArray();
            Arrays.sort(ary);
            String s = String.valueOf(ary);
            if (!map.containsKey(s)){
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(strs[i]);
        }
        
        for (String s : map.keySet()){
            int count = map.get(s).size();
            if (count > 1){
                result.addAll(map.get(s));
            }
        }
        return result;

    }
}