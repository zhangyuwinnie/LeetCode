import java.util.Queue;
import java.util.LinkedList;

class Coordinate{
    int x;
    int y;
    public Coordinate(int x, int y){
    this.x = x;
    this.y = y;
    }
}

public class LC200 {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(char[][] grid) {
        
        // special case
        if (grid == null || grid.length == 0){
            return 0;
        }
        int islands = 0;
        // 遍历所有点
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){ //0,0  0,1
                if (grid[i][j] == '1'){
                    islands++;
                    markByBFS(grid, i, j);
                    
                }
            }
        }
        return islands;
        
    }
    
    public void markByBFS(char[][] grid, int x, int y){//0,0
        grid[x][y] = '0';
        
        Queue<Coordinate> queue = new LinkedList<>();
        
        queue.offer(new Coordinate(x, y));
        
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};
        
        // bfs
        while (!queue.isEmpty()){
            Coordinate pos = queue.poll();
            for (int i = 0; i < 4; i++){
                Coordinate adjacent = new Coordinate(
                    pos.x + directionX[i],//0
                    pos.y + directionY[i]//1
                );
                if (withinBound(adjacent, grid) && grid[adjacent.x][adjacent.y] == '1'){
                    grid[adjacent.x][adjacent.y] = '0';
                    queue.offer(adjacent);
                }
            }
        }
        
    }
    public boolean withinBound(Coordinate position, char[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        return (position.x >=0 && position.x < row && position.y >= 0 
        && position.y < col);
    }
}