
public class ReverseNodesinkgroups {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (k < 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null){
            prev = reverseKNodes(prev, k);
        }
        return dummy.next;
    }
    // prev-n1-..nk-nk+1
    // prev-nk-..n1-nk+1
    public ListNode reverseKNodes(ListNode prev, int k){
        ListNode n1 = prev.next;//n1-1
        ListNode nk = prev;//nk-0
        for (int i = 0; i < k; i++){
            nk = nk.next;
            if (nk == null){
                return null;
            }
        }
        ListNode nkplus = nk.next;
        // reverse
        ListNode preCurt = prev;
        ListNode curt = prev.next;
        for (int i = 0; i < k; i++){
            ListNode temp = curt.next;
            curt.next = preCurt;
            preCurt = curt;
            curt = temp;
        }
        //重新连接
        n1.next = nkplus; //!!!
        prev.next = preCurt; //!!!
        // ListNode traverse = prev;
        // while (traverse != null) {
        //     System.out.println(traverse.val);
        //     traverse = traverse.next;
            
        // }
        return n1;
    }
}