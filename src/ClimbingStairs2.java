
public class ClimbingStairs2 {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        // Write your code here
        int[] A = new int[n+1];
        if (n == 0){
            return 1;
        }
        A[0] = 1;
        if (n == 1){
            return 1;
        }
        A[1] = 1;
        if (n == 2){
            return 2;
        }
        A[2] = 2;
        if (n == 3){
            return 4;
        }
        A[3] = 4;
        for (int i = 4; i <= n; i++){//4
            A[i] = A[i-1] + A[i-2] + A[i - 3];
        }
        return A[n];
    }
}