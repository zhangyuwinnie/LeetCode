import java.util.*;

class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // special case
        if (node == null){
            return null;
        }
        // bfs get nodes
        HashSet<UndirectedGraphNode> nodes = getNodes(node);
        // copy nodes and put into hashmap
        Map<UndirectedGraphNode,UndirectedGraphNode> nodepair = new HashMap<>();
        for (UndirectedGraphNode singleNode : nodes){
            nodepair.put(singleNode, new UndirectedGraphNode(singleNode.label));
        }//!!!
        // copy edges
        for (UndirectedGraphNode prev : nodes){
            UndirectedGraphNode curt = nodepair.get(prev);
            for (UndirectedGraphNode neighbor : prev.neighbors){
                curt.neighbors.add(nodepair.get(neighbor));
            }
        }
        return nodepair.get(node);

    }
    public HashSet<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        HashSet<UndirectedGraphNode> hash = new HashSet<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        hash.add(node);//!!!Bug，注意这个
        
        while (!q.isEmpty()){
            UndirectedGraphNode curt = q.poll();
            for (UndirectedGraphNode neighbor : curt.neighbors){
                if (!hash.contains(neighbor)){
                    hash.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        return hash;
    }
}