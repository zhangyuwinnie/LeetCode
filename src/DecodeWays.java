
public class DecodeWays {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[s.length()+1];//int[3]
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1: 0;//1
        for (int i = 2; i <= s.length(); i++){
            if (s.charAt(i-1) != '0'){
                nums[i] += nums[i-1];//1
                // System.out.println("a"+nums[i]+" "+nums[i-1]);
            }
            int twodig = 0;
            twodig = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
            if (twodig >= 10 && twodig <= 26){
                nums[i] += nums[i-2];
                // System.out.println("b"+nums[i]);

            }
        }
        return nums[s.length()];
    }
}