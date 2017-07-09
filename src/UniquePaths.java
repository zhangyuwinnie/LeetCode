
public class UniquePaths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] state = new int[m+1][n+1];
        // state[0][0] = 0;
        for (int i = 1; i <= m; i++){
            state[i][1] = 1;
        }
        for (int i = 1; i <= n; i++){
            state[1][i] = 1;
        }
        for (int i = 2; i <= m; i++){
            for (int j = 2; j <= n; j++){
                state[i][j] = state[i-1][j] + state[i][j-1];
            }
        }
        return state[m][n];
    }   
}