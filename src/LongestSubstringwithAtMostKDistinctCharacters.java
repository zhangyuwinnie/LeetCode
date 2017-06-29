import java.util.Map;
import java.util.HashMap;

public class LongestSubstringwithAtMostKDistinctCharacters {

    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
      int maxLen = 0;

      // Key: letter; value: the number of occurrences.
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      int i, left = 0;
      for (i = 0; i < s.length(); i++) {
        // put s[i] into map
        char c = s.charAt(i);
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
        // if > k , delete from left
        while (map.size() > k){
            char d = s.charAt(left); 
            int count = map.get(d);
            if (count > 1){
                map.put(d, map.get(d) - 1);
            } else {
                map.remove(d);
            }
            left++;
            
        }
        
        maxLen = Math.max(maxLen, i - left +1 );
       
      }
      return maxLen; 

    }
}