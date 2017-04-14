
public class LC338 {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        if (num==0)
            return result;
        result[0] = 0;
        for (int i = 1; i<=num; i++){
            result[i] = result[i/2] + i%2;
        }
        return result;
    }
}
