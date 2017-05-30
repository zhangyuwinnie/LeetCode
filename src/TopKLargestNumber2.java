import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
public class TopKLargestNumber2 {
    private Queue<Integer> q;
    private int size;

    public TopKLargestNumber2(int k) {
        // initialize your data structure here.
        this.size = k;
        q = new PriorityQueue<>();
    }

    public void add(int num) {
        // Write your code here
        if (q.size() < size){
            q.add(num);
            return;
        }
        
        int minheap = q.poll();
        q.add(Math.max(minheap, num));
    }

    public List<Integer> topk() {
        // Write your code here
        Iterator<Integer> it = q.iterator();
        List<Integer> result = new ArrayList<>();
        while (it.hasNext()){
            result.add((Integer) it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
};