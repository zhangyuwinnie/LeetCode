
public class LC109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = toBST(head,null);
        return root;    
    }
    public TreeNode toBST(ListNode head, ListNode tail){      
        if (head == tail) return null;  //!!!注意终点，l16 slow已经形成node了，head==slow的话，直接返回null就好
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast= fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }
}
