import java.util.PriorityQueue;
import java.util.Comparator;
class Point {
   int x;
   int y;
   Point() { x = 0; y = 0; }
   Point(int a, int b) { x = a; y = b; }
}

public class KClosestPoints {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    Point global_point = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        global_point = origin;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>(){
            public int compare(Point b, Point a){//!!! Note 1
                int diff = getDis(a, global_point) - getDis(b, global_point);
                if (diff == 0)
                    diff = a.x - b.x;
                if (diff == 0)
                    diff = a.y - b.y;
                return diff;
            }
        });
        
        for (int i = 0; i < points.length; i++){
            pq.offer(points[i]);
            if (pq.size() > k){
                pq.poll();
            }
        }
        int l = pq.size();
        Point[] result = new Point[l];
        for (int i = l - 1; i >= 0 ; i--){
            result[i] = pq.poll();
        }
        return result;            
    }
    
    public int getDis(Point a, Point b){
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }
}
// Note
// 在写comparator时，升序用f(1st arugment) - f(2nd argument), 逆序则相反
// 该题中要距离最近的前几个，则要做成max heap，这样可以满k后，poll出最大的那个