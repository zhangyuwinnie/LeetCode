import java.util.ArrayList;
import java.util.List;
public class LC46 {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null){
            return result; 
        }
        dfs(result, new ArrayList<Integer>(), nums);
        return result;
    }
        
    public void dfs(List<List<Integer>> result, 
                    ArrayList<Integer> curr, 
                    int[] nums) {
        if (curr.size() == nums.length){
            result.add(new ArrayList<Integer>(curr));
            return; //!!! 对比subset，这里要return，而且有终点判断，即长度判断，还有只需空的return即可，因为void
        }                 
        for (int i = 0;  i < nums.length; i++){
            if (!curr.contains(nums[i])){ //!!!注意以下操作都要包含在该条件成立时
                curr.add(nums[i]);
                dfs(result, curr, nums);
                curr.remove(curr.size()-1);
            }
            
        }
    }
}
