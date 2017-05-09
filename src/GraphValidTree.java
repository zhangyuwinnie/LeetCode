import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
public class GraphValidTree {
	/**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // special case
        if (n == 0){
            return false;
        }
        // if (edges == null || edges.length == 0){  //!!! case: 1,[] 
        //    return false;
        //}    
        
        // n vertex n-1 edges
        if (edges.length != n-1){
            return false;
        }
        
        // get graph
        Map<Integer, HashSet<Integer>> graph = getGraph(n, edges);
        
        // bfs
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> hash = new HashSet<>();
        queue.offer(0);
        hash.add(0);
        
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (Integer i : graph.get(node)){
                if (!hash.contains(i)){
                    queue.offer(i);
                    hash.add(i);
                }
            }
        }
        return hash.size() == n;
    }
    
    public Map<Integer, HashSet<Integer>> getGraph(int n, int[][] edges){
        Map<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
        // initialize
        for (int i = 0; i < n; i++){
            graph.put(i, new HashSet<Integer>()); //!!!put not add
        }
        
        // build
        for (int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
