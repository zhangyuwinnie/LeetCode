/**
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * @author zy
 *
 */

public class LC141 {

	public boolean hasCycle(ListNode head) {
        if (head == null){
       	 	return false;
        }
        while (head.next != null && head.next != head){
       	 	ListNode nextNode = head.next;
       	 	head.next = nextNode.next;
       	 	head = nextNode;
       	 	
        }
        return head.next != null;
    }
	
	public static void main (String[] args){
		
	}
}
