//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//Have you met this question in a real interview? Yes
//Example
//Given 1->4->3->2->5->2->null and x = 3,
//return 1->2->2->4->3->5->null.

public class PartitionList {
    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null){
            return null;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode left = dummy1;
        ListNode dummy2 = new ListNode(1);
        ListNode right = dummy2;
        while (head != null){
            if (head.val < x){
                left.next = head;//1
                left = left.next;//1,2
            } else {
                right.next = head;
                right = right.next;//4,3,5
            }
            head = head.next;
        }
        right.next = null;//不用忘记这个
        left.next = dummy2.next;
        return dummy1.next;
    }
}