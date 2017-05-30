import java.util.Queue;
import java.util.HashSet;
import java.util.PriorityQueue;
public class UglyNumber2 {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        Queue<Long> q = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<>();
        
       
        Long[] factors = new Long[3];
        factors[0] = Long.valueOf(2);//!!!
        factors[1] = Long.valueOf(3);
        factors[2] = Long.valueOf(5);
        
        for (int i = 0; i < 3; i++){
            q.add(factors[i]);
            set.add(factors[i]);
        }

        
        Long number = Long.valueOf(1);
        
        for (int i = 1; i < n; i++){//i=1
            number = q.poll();//number = 2
            System.out.println(number);
            
            // int next = Math.min(Math.min(multi2, multi3), multi5);
            for (int j = 0; j < 3; j++){
                if (!set.contains(number * factors[j])){
                    q.add(number * factors[j]);
                    set.add(number * factors[j]);
                }
            }
        }
        
        return number.intValue();
        
    }
};