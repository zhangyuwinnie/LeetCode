import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
	 };
	 
public class TopologicalSorting {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        
        // get indegree
        Map<DirectedGraphNode, Integer> hash = getIndegree(graph);
        Queue<DirectedGraphNode> q = new LinkedList<>();
        
        // get indegree = 0 node
        for (DirectedGraphNode node : hash.keySet()){
            if(hash.get(node) == 0){
                q.offer(node);
                result.add(node);
            }
        }    
        
        //bfs
        while (!q.isEmpty()){
            DirectedGraphNode curt = q.poll();
            for (DirectedGraphNode neighbor : curt.neighbors){
                hash.put(neighbor, hash.get(neighbor) - 1);
                if (hash.get(neighbor) == 0){
                    q.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }
        return result;
    }
    
    public Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
        Map<DirectedGraphNode, Integer> hash = new HashMap<>();
        // initialize hash
        for (int i = 0; i < graph.size(); i++){
            hash.put(graph.get(i), 0);
        }
        // get indegree
        for (int i = 0; i < graph.size(); i++){
            DirectedGraphNode curt = graph.get(i);
            for (DirectedGraphNode neighbor : curt.neighbors){
                hash.put(neighbor, hash.get(neighbor) + 1);
            }
        }
        return hash;
    }
}
// Note:
// 1.get indegree(loop)
// 2.bfs
//     0 indegree 放入queue
//     0的neighbor的indegree -1 
//     新的indegree为0的放入queue
//     也加入result
//     如此while
// 不用hashset