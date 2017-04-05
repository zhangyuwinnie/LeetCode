/**
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * @author zy
 *
 */

public class LC141 {
	//solution1
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
	// solution2
	public boolean hasCycle2(ListNode head){
		if (head == null){
			return false;
		}
		ListNode slow = head;
		ListNode quick = head;
		while(slow.next!=null && quick.next!=null&&quick.next.next!=null){
			slow = slow.next;
			quick = quick.next.next;
			if (slow == quick){
				return true;
			}
		}
		return false;
	}
	
	public static void main (String[] args){
		ListNode head = new ListNode(0);
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head1;
		
		LC141 test = new LC141();
		System.out.println(test.hasCycle2(head));
		
		
	}
}
