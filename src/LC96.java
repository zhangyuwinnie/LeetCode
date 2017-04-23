
public class LC96 {
    public int numTrees(int n) {
        int[] results = new int[n+1];
        if (n == 0) return 0;
        results[0] = 1;
        results[1] = 1;
        for (int i = 2; i <= n; i++){
            int[] sub = new int[i+1];
            for (int j = 1; j <= i; j++){
                // sub result for F(j,i)
                sub[j] = results[j-1]*results[i-j];
                results[i] += sub[j];
            }
        }
        return results[n];
    }
}
