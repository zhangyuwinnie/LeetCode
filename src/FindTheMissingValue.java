
public class FindTheMissingValue {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int len = nums.length;
        int[] record = new int[len+1];
        for (int i = 0; i < len; i++){
            record[nums[i]] = 1;
        }
        for (int i = 0; i < len + 1; i++){
            if (record[i] == 0){
                return i;
            }
        }
        return 0;
    }
}