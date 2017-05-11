import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
public class TopologicalSorting {
	 class DirectedGraphNode {
       int label;
       ArrayList<DirectedGraphNode> neighbors;
       DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
	 };
	/**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        // get nodes' indegree
        for (DirectedGraphNode node : graph){
            for (DirectedGraphNode neighbor : node.neighbors){
                if (map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        
        // put nodes wiht 0 indegree into queue as start
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph){
            if (!map.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }
        
        // bfs 不断移除indegree为0的点
        while (!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors){
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0){
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }
        return result;
    }
}
