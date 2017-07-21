import java.util.*;
public class WordLadder {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.size() == 0){
            return 0;
        }
        if (start.equals(end)){ //!!! Bug1
            return 1;
        }
        dict.add(start);
        dict.add(end);

        Set<String> s = new HashSet<>();//!!! Bug2: 不然没有结果时，会陷入死循环
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        s.add(start);
        
        int steps = 1;//!!!Bug3: 第一个也算的
        // bfs
        while (!q.isEmpty()){
            steps++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                String curt = q.poll();
                List<String> neighbors = getNeighbors(curt, dict);
                // System.out.println(curt + " " + neighbors);
                // if (neighbors.contains(end)){//!!!Bug4:如果end在dict里的话，要少加一个
                //     return steps;
                // }
                for (String neighbor : neighbors){
                    if (neighbor.equals(end)){//!!!Bug4:end不在dict里，但差1char
                        return steps;//!!!
                    } else if (! s.contains(neighbor)){
                        q.offer(neighbor);
                        s.add(neighbor);
                        // System.out.println(neighbor);
                    }
                }
            }
        }
        return 0;
    }
    
    private List<String> getNeighbors(String curt, Set<String> dict){
        List<String> result = new ArrayList<>();
        if (curt == null || dict == null){
            return result;
        }
        for (int i = 0; i <  curt.length(); i++){
            for (char c = 'a'; c < 'z'; c++){//!!!
                if (curt.charAt(i) == c){
                    continue;
                }
                String change = replace(curt, i, c);
                if (dict.contains(change)){
                    result.add(change);
                }
                
            }
        }
        return result;
    }
    
    private String replace(String curt, int place, char c){
        StringBuilder change = new StringBuilder();
        for (int i= 0; i < curt.length(); i++){
            change.append(i == place ? c : curt.charAt(i));
        }
        return change.toString();
    }
    
    private String replace2(String curt, int index, char c){
    		char[] chars = curt.toCharArray();
    		chars[index] = c;
    		return new String(chars);
    }
    
    // public boolean getResult(String curt, String end){
    //     int dif = 0;
    //     if (curt.length() != end.length()){
    //         return false;
    //     }
    //     for (int i = 0; i < curt.length(); i++){
    //         if (curt.charAt(i) != end.charAt(i)){
    //             if (++dif > 1){
    //                 return false;
    //             }
    //         }
    //     }
    //     // System.out.println(curt + " " + end + " " + dif);
    //     return true;
        
    // }
}

// 1.用BFS
// 2.怎么找到一个单词变化一个字母得到的结果呢？
// loop每个单词，然后每个单词的char 复杂度较大，n^2*L
// 反过来，看一个单词可以变成什么别的单词，L^2*25(L位置，每个位置改一下后在字典中是否有O(L),可以改25种)
// 3.将start和end加入dict可以简化