
public class UniquePaths2 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] state = new int[row+1][col+1];
        for (int i = 1; i <= row; i++){
            if (obstacleGrid[i-1][0] == 1){
                for (int a = i; a <= row; a++){
                    state[a][1] = 0;
                }
                break;
            }
            state[i][1] = 1;
        }
        for (int i = 1; i <= col; i++){
            if (obstacleGrid[0][i-1] == 1){
                for (int a = i; a <= col; a++){
                    state[1][a] = 0;
                }
                break;
            }
            state[1][i] = 1;
        }
        for (int i = 2; i <= row; i++){
            for (int j = 2; j <= col; j++){
                if(obstacleGrid[i-1][j-1] == 1){
                    state[i][j] = 0;
                } else {
                state[i][j] = state[i-1][j] + state[i][j-1];
                }
            }
        }
        return state[row][col];
    }
}