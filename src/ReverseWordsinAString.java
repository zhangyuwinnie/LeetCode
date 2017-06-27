
public class ReverseWordsinAString {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if (s == null){
            return null;
        }
        String[] words = s.split(" ");
        
        StringBuilder reverse = new StringBuilder();
        if (words.length == 0){
            return " ";
        }
        for (int i = words.length -1; i >= 0; i--){
            reverse.append(words[i]);
            reverse.append(" ");
        }
        String result = reverse.toString();
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
