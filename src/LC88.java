import java.util.Arrays;

// Easy

// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

// Note:
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.


public class LC88 {
	// not working, wondering why
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
        int len = m + n;
        int[] result = new int[len];
        // System.out.println(Arrays.toString(result));
        int a = 0;
        int b = 0;
        int i = 0;
        while(a<m && b <n){
	        if (nums1[a] <= nums2[b]){
	        		result[i] = nums1[a];
	        		a++;
	        		i++;
	        }
	       	else{
	       		result[i] = nums2[b];
	       		b++;
	       		i++;
	       	}
    	} 
        while (a <m){
        	result[i] = nums1[a];
        	a++;
        	i++;
        }
        while (b < n){
        	result[i] = nums2[b];
        	b++;
        	i++;
        }
        
        nums1 = result;
        //System.out.println(Arrays.toString(nums1));
        return;
    }
	
	// solution 2: insert from the right, (largest one) to left
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int len = m+n-1, a = m-1, b = n-1;
		// more concise
		while (a>=0 && b >= 0){
			nums1[len--] = (nums1[a]>nums2[b]) ? nums1[a--]:nums2[b--];
		}
		// not neccessary
		// while (a>= 0){
		//	nums1[len--] = nums1[a--];
		// }
		while (b>=0){
			nums1[len--] = nums2[b--];
		}		
    }
	
	public static void main(String[] args){
		// test for solution 1
		int[] a = new int[6];
		a[0]=0;
		a[1]=5;
		int[] b = {2,3,4};
		LC88 test1 = new LC88();
		test1.merge(a,2,b,3);
		System.out.println(Arrays.toString(a));
		// test for solution 2
		int[] c = new int[6];
		c[0]=0;
		c[1]=5;
		int[] d = {2,3,4};
		LC88 test2 = new LC88();
		test2.merge2(c,2,d,3);
		System.out.println(Arrays.toString(c));
	}
}
