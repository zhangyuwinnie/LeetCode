import java.util.*;
public class CourseSchedule2 {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] result = new int[numCourses];
        if (numCourses == 0){
            return result;
        }
        
        // get indegree
        HashMap<Integer, HashSet<Integer>> edges = new HashMap<>();
        HashMap<Integer, Integer> degree = new HashMap<>();
        
        // initialize
        for (int i = 0; i < numCourses; i++){
            edges.put(i, new HashSet<Integer>());
            degree.put(i, 0);
        }
        
        for (int i = 0; i < prerequisites.length; i++){//
            int start = prerequisites[i][1];//2
            int end = prerequisites[i][0];//0
            if (!edges.get(start).contains(end)){
                edges.get(start).add(end);
                degree.put(end, degree.get(end) + 1);//bug:也要在上面的if条件之下
            }
        }
        
        // System.out.println(edges);
        // System.out.println(degree);
        Queue<Integer> q = new LinkedList<>();
        
        // get indegree = 0
        
        int index = 0;
        for (Integer i : degree.keySet()){
            if (degree.get(i) == 0){
                q.offer(i);
                result[index++] = i;//!!!
            }
        }
        
        // bfs
        int count = 0;
        while (!q.isEmpty()){
            int curt = q.poll();
            count++;
            for (int i : edges.get(curt)){
                degree.put(i, degree.get(i) - 1);
                if (degree.get(i) == 0){
                    q.offer(i);
                    result[index++] = i;//!!!
                }
            }
        }
        // System.out.println(count);
        if (count == numCourses){
            return result;        
        } else {
            return new int[0];
        }
        
        
    }
}