
public class ReversePairs {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        if (A == null || A.length == 0){
            return 0;
        }
        return mergeSort(A, 0, A.length - 1);
    }
    public int mergeSort(int[] A, int start, int end){//0,4
        if (start >= end){
            return 0;
        }
        int mid = (start + end)/2;//2
        int sum = 0;
        sum += mergeSort(A, start, mid);
        // System.out.println(start + " " + mid + a);
        sum +=  mergeSort(A, mid + 1, end);
        // System.out.println(mid+1 + " " + end + " " + b);
        sum += merge(A, start, mid, end);
        // System.out.println(start + " "+ mid + " " + end + " " + sum);
        return sum;
    }
    public int merge(int[] A, int start, int mid, int end){
        int[] temp = new int[A.length];
        int left = start;
        int right = mid + 1;
        int index = start;
        int sum = 0;
        while (left <= mid && right <= end){
            if (A[left] <= A[right]){
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
                sum += mid - left + 1;
            }
        }
        while (left <= mid){
            temp[index++] = A[left++];
        }
        while (right <= end){
            temp[index++] = A[right++];
        }
        for (int i = start; i <= end; i++){//!!!
            A[i] = temp[i];
        }
        return sum;
    }
}
//Note
//merge最后部分，只是start,end,不是0，A.length