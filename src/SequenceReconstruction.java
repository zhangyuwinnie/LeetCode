import java.util.*;
public class SequenceReconstruction {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        // special case
        if (org.length == 0 && (seqs.length == 0 || seqs[0].length == 0)){
            return true;
        }
        
        // get degree and edges
        // initialize
        int[] degree = new int[org.length + 1];
        HashMap<Integer, HashSet<Integer>> hash = new HashMap<>();
        for (int i= 1; i <= org.length; i++){
            hash.put(i, new HashSet<Integer>());
        }
        
        int count = 0;
        for (int i = 0; i < seqs.length; i++){
            int len = seqs[i].length;
            count += len;//!!!for special case
            if (seqs[i].length > 0 && (seqs[i][0] < 0 || seqs[i][0] > org.length)){//!!! seq[0] 检测不到
                return false;
            }
            for (int a = 1; a < len; a++){//!!!是相邻两个数直接有edge
                    int start = seqs[i][a - 1];
                    if (start < 0 || start > org.length){
                        return false;
                    }
                    int end = seqs[i][a];
                    if (end < 0 || end > org.length){
                        return false;
                    }
                    if (!hash.get(start).contains(end)){//!!!
                        degree[end]++;
                        hash.get(start).add(end);
                    }
                
            }
            
        }
        
        // get indegree=0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= org.length; i++){
            if (degree[i] == 0){
                q.offer(i);
            }
        }
        int[] construct = new int[org.length];
        int index = 0;
        
        // special case
        if (count < org.length){//!!! 不然会time out
            return false;
        }
        if (q.size() > 1){//!!!
            return false;
        }
        
        // bfs
        while (! q.isEmpty()){
            if (q.size() > 1){
                return false;
            }
            int curt = q.poll();
            construct[index++] = curt;
            for (int edge : hash.get(curt)){
                degree[edge]--;
                if (degree[edge] == 0){
                    q.offer(edge);
                }
            }
        }
        for (int i = 0; i < org.length; i++){
            if (org[i] != construct[i]){
                return false;
            }
        }
        return true;
    }
}

//Note:
//这题是topological sorting，但有很多小细节