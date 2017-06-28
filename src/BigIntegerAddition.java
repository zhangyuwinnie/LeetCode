
public class BigIntegerAddition {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // Write your code here
        if (num1 == null && num2 == null){
            return null;
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int carry = 0;
        String result = "";
        while (l1 > 0 || l2 > 0){
            if (l1 > 0){
                carry += num1.charAt(l1-1) - '0';
                l1--;
            }
            if (l2 > 0){
                carry += num2.charAt(l2-1) - '0';
                l2--;
            }
            result = carry % 10 + result;
            carry /= 10;
        }
        if (carry > 0){
            result = carry + result;
        }
        return result;
    }
}

//Input
//"9999999999981", "19"
//Output
//"0000000000000"
//Expected
//"10000000000000"