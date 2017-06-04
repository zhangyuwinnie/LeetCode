import java.util.List;
import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;
public class MergeKSortedLists{
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
	// solution 1 : divide and conquer
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists.size() == 0){
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    public ListNode mergeHelper(List<ListNode> lists, int start, int end){//0,1
        if (start < end){
            int mid = (start + end)/2;//0
            ListNode left = mergeHelper(lists, start, mid);//(0,0)
            ListNode right = mergeHelper(lists, mid + 1, end);//(1,1)
            return merge2lists(left, right);
        } else {
            return lists.get(start);
        }
    }
    public ListNode merge2lists(ListNode left, ListNode right){
        ListNode dummy = new ListNode(1);
        ListNode result = dummy;
        while (left != null && right != null){
            if (left.val <= right.val){
                result.next = new ListNode(left.val);
                left = left.next;
            } else {
                result.next = new ListNode(right.val);
                right = right.next;
            }
            result = result.next;
        }
        if (left != null){
            result.next = left;
        }
        if (right != null){
            result.next = right;
        }
        
        return dummy.next;
    }
    
    // solution 2: with heap
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private Comparator<ListNode> comp = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right){
            return left.val - right.val;
        }
    };
    
    
    
    public ListNode mergeKLists2(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0){
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comp);
        for (int i = 0; i < lists.size(); i++){
            if (lists.get(i) != null){
                heap.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()){
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null){//!!!
                heap.add(head.next);
            }
        }
        return dummy.next;
        
    }
}
