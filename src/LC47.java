import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class LC47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null){
            return result;
        }
        Arrays.sort(nums); //!!!
        dfs(result, new ArrayList<Integer>(), nums, new int[nums.length]);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, ArrayList<Integer> curr, int[] nums, int[] visited){
        if (curr.size() == nums.length){
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i] == 1 ||  
               (i != 0 && visited[i-1] == 0 && nums[i-1] == nums[i])){
                continue;       
            }
            /*
            visited[i] == 1 为了判断元素是否已经在curr中
            后一个判断是为了去除重复元素影响
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
            所以 nums[i-1] == nums[i]当出现重复元素时，如果前一个元素没有被访问的话，就无效
            */
            visited[i] = 1;
            curr.add(nums[i]);
            dfs(result, curr, nums, visited);
            curr.remove(curr.size()-1);
            visited[i] = 0;
        }
    }    

}
