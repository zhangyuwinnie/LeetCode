
public class InsertintoaCyclicSortedList {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // System.out.println(node.val);
        // System.out.println(node.next.val);
        // Write your code here
        ListNode xnode = new ListNode(x);
        
        if (node == null){
            xnode.next = xnode;
            return xnode;
        }
        
        ListNode traverse = node;
        ListNode next = null;
        
        while (traverse.next != node){
            // System.out.println("*");

            next = traverse.next;
            if (valid(traverse.val, next.val, x)){
                break;
            }
            traverse = traverse.next;
        }
        // !!!还有一种情况是while结束，case 2->2->2, 3
        next = traverse.next;
        traverse.next = xnode;
        xnode.next = next;
        return xnode;
    }
    
    public boolean valid(int left, int right, int x){
        if (left <= x && x <= right){
            return true;
        }
        if ((left > right) && (x <right || x > left)){//!!!一个最小一个最大
            return true;
        }
        return false;
    }
}
// Test case
// 2->2->2, 3
// 30->50->2->2->3->5->7->9->11->20, 2