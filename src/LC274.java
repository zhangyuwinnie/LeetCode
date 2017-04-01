import java.util.*;

public class LC274 {
	// sort based, complexity o(nlogn) 
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        int len = citations.length;
        for (int i = 0; i< len; i++){
        	if (citations[i] >= len-i &&  len-i > max){
        		if (i==0 ){
        			max = len-i;
        		}
        		else if (citations[i-1] <= len-i){
        			max = len-i;
        		}
        		
        	}
        }
        return max;
    }
    
    // sort based, more concise
    public int hIndex2(int[] citations){
    	Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < len; i++){
        	if (len <= citations[i]){
        		return len;
        	}
        	else{
        		len--;
        	}       		
        }
        return 0;
    }
    
    // complexity o(n), not very straightforward
    public int hIndex3(int[] citations){
    	int len = citations.length;
    	int[] array2 = new int[len+1];
    	
    	for (int i = 0; i < len; i++){
    		if(citations[i]>len){
    			array2[len]++;
    		}
    		else{
    			array2[citations[i]]++;
    		}
    	}
    	
    	int t = 0;
    	for (int i = len; i>=0; i--){
    		t = t + array2[i];
    		if (t==i){
    			return i;
    		}
    	}
    	return 0;
    }
    
    public static void main(String[] args){
		int[] a = {1,0,4,6,5};
		// int[] b = {2,3,4};
		LC274 tes = new LC274();
		System.out.println(tes.hIndex(a));
		System.out.println(tes.hIndex2(a));
		System.out.println(tes.hIndex3(a));
		
	}
}
