import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LC90 {
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0) return result;
		Arrays.sort(nums); //去重必须要sort
		dfs(nums,0,new ArrayList<Integer>(),result);
		return result;
	}	
	
	public void dfs(int[] nums, int start, List<Integer> curr, List<List<Integer>> result){
		result.add(new ArrayList<Integer>(curr));//!!!不能直接add(curr)
		for (int i=start; i<nums.length; i++){
			if (i!=0 &&i>start && nums[i] ==nums[i-1]) {// 去重，只取相同数中第一个作为下一个
				continue;	
			}
			curr.add(nums[i]);
			dfs(nums,i+1,curr,result);
			curr.remove(curr.size()-1);		
		}
	}
    public static void main(String[] args){
		int[] arr = {1,2,2,3,3};
		LC90 test = new LC90();
		System.out.println(test.subsetsWithDup(arr));
    }
}
