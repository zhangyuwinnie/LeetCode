
public class LC121 {
	// solution1: 跟踪最小值，每次来一个数，比较和最小值之差， 保留大的，最小值更新 
    	public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int min = Integer.MAX_VALUE;
            int val = 0;
            for (int i = 0; i<prices.length; i++){
            	int diff = prices[i] - min;
            	if (diff > val) val = diff;
            	if (prices[i] < min) min = prices[i];
            }
            return val;
    }
    	// solution2 : DP法，累加 p[i]-p[i-1]
    	public int maxProfit2(int[] prices){
    		if (prices.length<2) return 0;
    		int diff = 0;
    		int maxp = 0;
    		for (int i = 1; i< prices.length; i++){
    			diff += prices[i]-prices[i-1];
    			diff = Math.max(0, diff );
    			maxp = Math.max(maxp, diff);
    			
    		}
    		return maxp;
    	}
    	
}
