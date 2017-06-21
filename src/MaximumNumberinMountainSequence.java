public class MaximumNumberinMountainSequence {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int start = 0, end = nums.length - 1;//3
        while (start + 1 < end){ //1 1
            int mid = start + (end - start)/2;//1
            if (nums[mid] < nums[mid+1]){//9 8
                start = mid;
            } else {
                end = mid;//1
            }
        }
        
        return Math.max(nums[start], nums[end]);
    }
}
