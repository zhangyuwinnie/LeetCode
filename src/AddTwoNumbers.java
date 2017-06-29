
public class AddTwoNumbers {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        // get l1
    		ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
            if (l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            result.next = new ListNode(carry % 10);
            carry = carry / 10;
            result = result.next;
        }
        if (carry > 0){
            result.next = new ListNode(carry);
        }
        return dummy.next;    
    }
}
// Compile:
///code/Solution.java:22: error: incompatible types: int cannot be converted to ListNode
//return 0;

// test
//1->1->1->1->1->null
//9->8->8->8->8->null
//Output
//0->0->0->0->0->null
//Expected
//0->0->0->0->0->1->null