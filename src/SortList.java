
public class SortList {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;
        while (left != null && right != null){
            if (left.val > right.val){//1 > -1
                merge.next = right; //0->-1
                right = right.next; //
            } else {
                merge.next = left;
                left = left.next;
            }
            merge = merge.next;
        }
        // !!! 不用忘记将剩下的加上
        if (left != null){
            merge.next = left;
        }
        if (right != null){
            merge.next = right;
        }
        return dummy.next;
    }
}
