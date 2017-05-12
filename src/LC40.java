import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LC40 {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // special case
        if (num == null || num.length == 0){
            return result;
        }
        Arrays.sort(num);//1,1,2,5,6,7,10
        dfs(num, target, new ArrayList<Integer>(), result, 0);
        return result;
    }
    public void dfs(int[] nums, 
                    int target, 
                    ArrayList<Integer> combination, 
                    List<List<Integer>> result, 
                    int startIndex){
        if (target == 0){
            //System.out.println(combination);
            ArrayList<Integer> copy = new ArrayList<Integer>(combination);
            result.add(copy);
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            if (target < nums[i]){
                break;
            }
            if (i>0 && nums[i] == nums[i-1] && i > startIndex){
                continue;
            }
            combination.add(nums[i]);
            dfs(nums, target - nums[i], combination, result, i+1);
            combination.remove(combination.size() - 1);
        }
        return;
    }
    
}   