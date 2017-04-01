// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.

// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

// Complexity : O(n)
import java.util.*;

public class LC350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 
		 for (int i = 0; i< nums1.length; i++){
			 //map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
			 if (map.get(nums1[i]) != null){
				 map.put(nums1[i], map.get(nums1[i])+1);
			 }
			 else{
				 map.put(nums1[i],1);
			 }
		 }
		 
		 List<Integer> result = new ArrayList<Integer>();
		 for (int i = 0; i < nums2.length; i++){
			 if (map.get(nums2[i]) != null && map.get(nums2[i])>0){
					result.add(nums2[i]);
					map.put(nums2[i], map.get(nums2[i])-1);
				 
			 }
		 }
		 
		 int[] rearr = new int[result.size()];
		 int index = 0;
		 for (int i : result){
			 rearr[index++] = i;
		 }
		 return rearr;	        
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3};
		int[] b = {2,3,4};
		LC350 tes = new LC350();
		System.out.println(Arrays.toString(tes.intersect(a, b)));
		
	}
	
	
}
