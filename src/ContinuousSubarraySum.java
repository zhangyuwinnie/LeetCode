import java.util.ArrayList;
public class ContinuousSubarraySum {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
	// 该方法时间复杂度为O(N^2), 太大了，思路-最大连续子序列和只可能从数组0到n-1中某个位置开始，我们可以遍历0到n-1个位置，
    //	计算由这个位置开始的所有连续子序列和中的最大值。最终求出最大值即可。
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0){
            return result;
        }
        int start = 0, end = 0, maxSum = A[0];
        for (int i = 0; i < A.length; i++){
            int sum = 0;
            for ( int j = i; j < A.length; j++){
                sum += A[j]; //!!! 省去一重循环
                if (sum > maxSum){
                    maxSum = sum;
                    start = i;
                    end = j;
                }
            }
        }
        result.add(start);
        result.add(end);
        return result;
    }
    // 	O(n)
    //    思路：因为最大 连续子序列和只可能是以位置0～n-1中某个位置结尾。当遍历到第i个元素时，
    //    判断在它前面的连续子序列和是否大于0，如果大于0，则以位置i结尾的最大连续子序列和为元素
    //    i和前门的连续子序列和相加；否则，则以位置i结尾的最大连续子序列和为元素i。
    public ArrayList<Integer> continuousSubarraySum2(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0){
            return result;
        }
        int start = 0, end = 0, maxSum = A[0];
        int sumCurt = 0; //！！！不能是<0的数，不然一开始会不准
        int change = 0;
        boolean changeHead = false;//！！！每次从头开始时会重新记录起始，并变为TRUE，如果累计超过max，就刷新start，再变回False，如此循环
        for (int i = 0; i < A.length; i++){
            
            if (sumCurt < 0){
                sumCurt = A[i];
                changeHead = true;//!!!
                change = i;//!!!
            } else {
                sumCurt += A[i];
            }
            if (sumCurt > maxSum){
                maxSum = sumCurt;
                end = i;
                if (changeHead){//!!!
                    start = change;
                    changeHead = false;
                }
            }
            // System.out.println("i"+i+"curt"+sumCurt+"start"+start+"max"+maxSum+changeHead);
        }
        result.add(start);
        result.add(end);
        return result;
    }
    public static void main(String[] args){
    		ContinuousSubarraySum test = new ContinuousSubarraySum();
    		int[] A = {1,1,1,1,1,1,1,1,1,-19,1,1,1,1,1,1,1,-2,1,1,1,1,1,1,1,1,-2,1,-15,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    		System.out.println(test.continuousSubarraySum2(A));
    }
    
}