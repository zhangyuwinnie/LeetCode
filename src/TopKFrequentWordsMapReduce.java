import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Definition of OutputCollector:
 */
class OutputCollector<K, V> {
     public void collect(K key, V value){
    	 
     }
         // Adds a key/value pair to the output buffer
}

/*
 * Definition of Document:
 */
class Document {
     public int id;
     public String content;
}

class Pair{
    String key;
    int value;
    Pair(String key, int value){
        this.key = key;
        this.value = value;
    }
}
public class TopKFrequentWordsMapReduce {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            // int id = value.id;
            String[]  words = value.content.split(" ");
            for (String word : words){
                if (word.length() > 0){
                    output.collect(word, 1);
                }
            }
        }
    }

    public static class Reduce {
        private PriorityQueue<Pair> pq = null;
        private int k;

        public void setup(int k) {
            // initialize your data structure here
            // pq = new PriorityQueue<Pair>();
            this.k = k;
            Comparator<Pair> compare = new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    if (a.value != b.value){
                        return a.value - b.value;
                    } else {
                        return b.key.compareTo(a.key);
                    }
                }
            };
            pq = new PriorityQueue<Pair>(k, compare);//?要k吗

        }   

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while (values.hasNext()){
                sum += values.next();
            }
            Pair newpair = new Pair(key, sum);
            pq.offer(newpair);
            if (pq.size() > k){
                pq.poll();
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            ArrayList<Pair> pairs = new ArrayList<Pair>();
            while (!pq.isEmpty()){
                pairs.add(pq.poll());
            }
            int size = pairs.size();
            for (int i = size-1; i >= 0; i--){
                String key = pairs.get(i).key;
                int value = pairs.get(i).value;
                output.collect(key, value);
            }
        }
    }
}