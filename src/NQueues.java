import java.util.*;

public class NQueues {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (n == 0){
            return result;
        }
        dfs(result, new ArrayList<Integer>(), n);
        return result;
    }
    
    public void dfs(ArrayList<ArrayList<String>> result, ArrayList<Integer> curt, int n){
        if (curt.size() == n){
            ArrayList<String> solution = getString(curt, n);
            result.add(solution);
            return;
        }
        
        for (int i = 0; i < n; i++){
            if (!isValid(curt, i)){
                continue;
            }
            curt.add(i);
            dfs(result, curt, n);
            curt.remove(curt.size() - 1);
        }
        
    }
    
    public ArrayList<String> getString(ArrayList<Integer> curt, int n){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String s = "";
            for (int j = 0; j < n; j++){
                if (j == curt.get(i)){
                    s += "Q";
                } else {
                    s += ".";
                }
            }
            result.add(s);
        }
        return result;
        
    }
    
    public boolean isValid(ArrayList<Integer> curt, int col){
        int rows = curt.size();
        for (int i = 0; i < rows; i++){
            if (curt.get(i) == col){
                return false;
            }
            if (curt.get(i) + i == col + rows){
                return false;
            }
            if (curt.get(i) - i == col - rows){
                return false;
            }
        }
        return true;
    }
};
// Note: 转化为求0，1，2，3，4...n-1的permutation，数字代表列，每个数字表示一行
//然后要注意互吃的情况，要知道queue可以走米字，而且任意步，所以，不能同行，同列，不能在其他queue的对角方向
//对角方向的判断：斜率为1，-1，所以就是y2-y1=x2-x1, y2-y1 = x1-x2

