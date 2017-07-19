import java.util.*;
public class KnightShortestPath {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        Queue<Point> q = new LinkedList<>();
        q.offer(source);
        
        int steps = 0;
        int[] xchange = {1,1,-1,-1,2,2,-2,-2};
        int[] ychange = {2,-2,2,-2,1,-1,1,-1};
        
        // bfs
        while (!q.isEmpty()){
            // System.out.println(steps);
            steps++;
            int size = q.size();
            for (int a = 0; a < size; a++){//!!! Bug1：最短路径，要注意加一个level size
                Point curt = q.poll();

                for (int i = 0; i < 8; i++){
                    int x = curt.x + xchange[i];
                    int y = curt.y + ychange[i];
                    Point next = new Point(x, y);
                    if (withIn(grid, x, y) && grid[x][y] != true){
                        if (isEqual(next, destination)){
                            return steps;
                        } else {
                            q.offer(next);
                            grid[x][y] = true; //!!! Bug2 ：将走过的地方标记为障碍，防止重复走过
                            // System.out.println(next.x + " " + next.y);
                        }
                    }
                }
            }
            
        }
        return -1;
    }
    
    public boolean isEqual(Point a, Point b){
        return (a.x == b.x && a.y == b.y);
    }
    
    public boolean withIn(boolean[][] grid, int x, int y){
        int row = grid.length;
        int col = grid[0].length;
        
        if ( x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1){
            return true;
        } else {
            return false;
        }
        
    }
}
//Note：2个bug