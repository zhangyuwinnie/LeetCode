
public class MedianOfTwoSortedArrays {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int k = A.length + B.length;//10
        if (k % 2 == 0){
            // System.out.println(findKth(A, 0, B, 0, k/2));
            // System.out.println(findKth(A, 0, B, 0, k/2+1));
            return (findKth(A, 0, B, 0, k/2) + findKth(A,0,B,0,k/2+1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, k/2 + 1);//!!! Bug2: 用了k/2
        }
    }
    public int findKth(int[] A, int startA, int[] B, int startB, int k){//A,2,B,0,2
        if (startA >= A.length){//0
            return B[startB + k - 1];
        }
        if (startB >= B.length){
            return A[startA + k - 1];
        }
        if (k == 1){
            return Math.min(A[startA], B[startB]);
        }
        int keyA;
        if (startA + k/2 <= A.length){//0+2
            keyA = A[startA + k/2 -1];//A[0+2-1]=2
        } else {
            keyA = Integer.MAX_VALUE;
        }
        int keyB;
        if (startB + k/2 <= B.length){//
            keyB = B[startB + k/2 -1];//3
        } else {
            keyB = Integer.MAX_VALUE;
        }
        if (keyA < keyB){
            return findKth(A, startA + k/2, B, startB, k - k/2);//!!! Bug1: k - k/2 != k/2  
        } else {
            return findKth(A, startA, B, startB + k/2, k - k/2 );
        }
    }
}
//Note:
//思路：用找kth smallest的方法，每次从一个array中丢弃一半
//两个bug注意一下

