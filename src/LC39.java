import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LC39 {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // special case
        if (candidates == null || candidates.length == 0){
            return result;
        }
        // sort and remove duplicates
        int[] nums = removeDuplicates(candidates);
        dfs(nums, target, new ArrayList<Integer>(), result, 0);
        return result;
    }
    
    public void dfs(int[] nums, 
                    int target, 
                    ArrayList<Integer> combination, 
                    List<List<Integer>> result, 
                    int startIndex){
        if (target == 0){
            ArrayList<Integer> copy = new ArrayList<Integer>(combination);
            result.add(copy);
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            if (target < nums[i]){
                break;
            }
            combination.add(nums[i]);
            dfs(nums, target - nums[i], combination, result, i);
            combination.remove(combination.size() - 1);
        }
        return;
    }
    public int[] removeDuplicates (int[] candidates){
        if (candidates == null || candidates.length == 0){
            return candidates;
        }
        Arrays.sort(candidates);
        int index = 0;
        for (int i = 1; i < candidates.length; i++){
            if (candidates[index] != candidates[i]){
                candidates[++index] = candidates[i];
            }
        }
        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++){
            nums[i] = candidates[i];
        }
        return nums;
    }
}