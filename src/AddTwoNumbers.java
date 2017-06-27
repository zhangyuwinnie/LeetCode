
public class AddTwoNumbers {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        // get l1
        if (l1 == null && l2 == null){
            return new ListNode(0);
        }
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        int carry = 0;
        while (l1 != null && l2 != null){
            int curt = l1.val + l2.val + carry;
            point.next = new ListNode(curt % 10);
            carry = curt / 10;
            point = point.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int curt = carry + l1.val;
            point.next = new ListNode(curt % 10);
            carry = curt /10;
            point = point.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int curt = carry + l2.val;
            point.next = new ListNode(curt % 10);
            carry = curt /10;
            point = point.next;
            l2 = l2.next;
        }
        if (carry != 0){
            point.next = new ListNode(carry);
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