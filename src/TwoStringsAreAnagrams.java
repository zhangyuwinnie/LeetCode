
public class TwoStringsAreAnagrams {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()){
            return false;
        }
        int [] array = new int[256];
        for (int i = 0; i < s.length(); i++){
            array[(int) s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++){
            array[(int) t.charAt(i)]--;
            if (array[(int) t.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }
};