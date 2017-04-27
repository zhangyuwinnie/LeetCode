
public class strStr {
    public int strStrgen(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        // write your code here
        for (int i = 0; i < source.length() - target.length() + 1; i++){ // !!!注意+1
        		int j = 0;//!!! 注意j的处理，先定义，再loop，这样可以在循环外用j判断 line15
            for (j = 0; j < target.length(); j++){ 
                if (source.charAt(i + j) != target.charAt(j)){
                		break;
                }
            }
            if (j == target.length()){
                return i;
            }
        }
        return -1;
    }
}
