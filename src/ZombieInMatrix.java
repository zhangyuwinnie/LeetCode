import java.util.Queue;
import java.util.LinkedList;

public class ZombieInMatrix {
    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;
    public int[] deltaX = {0, 1, 0, -1};
    public int[] deltaY = {1, 0, -1, 0};
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        
        // special case 
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        // initialize queue and count people
        int people = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    people++;
                } else if (grid[i][j] == ZOMBIE){
                    queue.offer(new Coordinate(i,j));//0,1
                }
            }
        }
        
        // bfs
        int days = 0;
        while (!queue.isEmpty()){
            days++;
            int size = queue.size(); //!!!层级遍历
            for (int i = 0; i < size; i++){
                Coordinate zb = queue.poll(); //0,1
                for (int j = 0; j < 4; j++){
                    Coordinate adj = new Coordinate(
                        zb.x + deltaX[j],//0
                        zb.y + deltaY[j] //2
                    );
                    //System.out.println(adj.x + " " + adj.y);
                    //System.out.println(isPeople(adj, grid));
                    if (isPeople(adj, grid)){
                        people--;
                        grid[adj.x][adj.y] = 1; //!!!要把人变成ZOMBIE
                        queue.offer(new Coordinate(adj.x, adj.y));
                    }
                    //System.out.println("People " + people + "day " + days );
                    if (people == 0){
                        return days;
                    }
                }
            }
        }
        return -1;
    }
    public boolean isPeople(Coordinate pos, int[][] grid){//0,2
        int n = grid.length;//3
        int m = grid[0].length;//5
        if (pos.x < 0 || pos.x >= n){
            return false;
        }
        if (pos.y < 0 || pos.y >= m){
            return false;
        } 
        return grid[pos.x][pos.y] == PEOPLE;
    }
}