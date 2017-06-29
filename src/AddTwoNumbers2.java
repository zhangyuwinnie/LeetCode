
public class AddTwoNumbers2 {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);
        return reverseList(addLists(r1,r2));
    }  
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while (head != null){
             ListNode temp = head.next;
             head.next = prev;
             prev = head;
             head = temp;
        }
        return prev;
    }
    public ListNode addLists(ListNode l1, ListNode l2){
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

//Note
//在Add two numbers 1的基础上加个reverse list