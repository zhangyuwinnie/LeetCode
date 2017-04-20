import java.util.List;
import java.util.Arrays;
public class LC139 {
	//solution1:不太简洁
    public boolean wordBreak(String s, List<String> wordDict) {  
        boolean[] bool = new boolean[s.length()+1];
        bool[0] = true;
        if (s.length() == 0) return false;
        for (int i = 0; i<s.length(); i++){
            for (String str : wordDict){
                if (str.length() <= i+1){
                    if (str.equals(s.substring(i-str.length()+1,i+1)) && bool[i-str.length()+1]){                   
                    		bool[i+1] = true;
                    		break;
                    }
                }
                /*
                else if(str.length() == i+1){ //可以和上面合并
                    if (str.equals(s.substring(0,i+1))){
                        	bool[i+1] = true;
                    		break;
                    }
                }
                */
            }
        }
        return bool[s.length()];
    }
    
    
    public static void main ( String[] args){
    		String s = "leetcode";
    		String[] arr = {"leet","code"};
    		List<String> dic = Arrays.asList(arr);
    		LC139 test = new LC139();
    		System.out.println(test.wordBreak(s, dic));
    }
}
