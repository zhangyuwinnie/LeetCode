import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class LC78 {
	// solution 1: recursive法，n个元素的结果为n-1个元素的结果加上((n-1)个元素结果+第n个元素)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new  ArrayList<List<Integer>>();
        if (nums.length == 0) return result;
        if (nums.length == 1){
            result.add(new ArrayList<Integer>());
            List<Integer> single = new ArrayList<Integer>();
            single.add(nums[0]);
            result.add(single);
        }
        else{
        	    // 得到前n-1个元素组成数组的subsets
            List<List<Integer>> previous = subsets(Arrays.copyOf(nums, nums.length-1));
            //  将新元素加入前面结果
            for (List<Integer> list : previous){  
	         	result.add(new ArrayList(list)); ///!!!不能直接add(list),因为后面对list有修改，后面list变了，这里也会变
	            	list.add(nums[nums.length-1]);
	            	result.add(list);           		
            }             
        }
        return result;    
    }
    // solution2: DFS, 思路参看http://www.cnblogs.com/TenosDoIt/p/3451902.html
    public List<List<Integer>> subsets2(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
       
        if(S.length == 0){
            return result;
        }
        
        Arrays.sort(S);
        dfs(S, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(path));
        
        for(int i = index; i < s.length; i++){
            path.add(s[i]);
            dfs(s, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args){
    		int[] arr = {1,2,3};
    		LC78 test = new LC78();
    		System.out.println(test.subsets2(arr));
    }
}
