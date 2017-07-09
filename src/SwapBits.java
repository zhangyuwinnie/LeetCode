
public class SwapBits {
    /**
     * @param x an integer
     * @return an integer
     */
    public int swapOddEvenBits(int x) {
        // Write your code here
        // get original bit array
        int result = (x & 0xaaaaaaaa) >>> 1  | (x & 0x55555555) << 1;
        return result;
    }
}
//Note
//和0xaaaaaaaa进行'&'运算，取出偶数位，然后右移一位，这里注意用'>>>'而不是'>>',因为只是为了取位数
//和0x55555555进行'&'运算，取出奇数位，然后左移一位