import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
	// solution 1
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
    
    // solution 2
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(candidates, result, new ArrayList<Integer>(), 0, 0, target);
        return result;
    }
    
    public void helper(int[] candidates,
                       List<List<Integer>> result, 
                       List<Integer> curt, 
                       int startIndex, 
                       int sum, 
                       int target){
        if (sum == target){
            result.add(new ArrayList<Integer>(curt));
            return;
        } else if (sum > target){
            return;
        }
        
        for (int i = startIndex; i < candidates.length; i++){
            if (i - 1 >= 0 && candidates[i] == candidates[i-1] && i > startIndex){// 除重
                continue;
            }
            curt.add(candidates[i]);
            helper(candidates, result, curt, i, sum + candidates[i], target);//!!!这里是i，而不是i-1,因为可以重复得选自己，当和超过target自然return，所以不会有overlow的问题
            curt.remove(curt.size() - 1);
        }
        
    }
}
