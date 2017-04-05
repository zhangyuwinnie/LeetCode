/**
 * Easy - Linked List Cycle II 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * Follow up:
 * Can you solve it without using extra space?
 * @author zy
 *
 */

import java.util.Set;
import java.util.HashSet;
public class LC142 {
	//solution1
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> s = new HashSet<ListNode>();
		if (head ==null) return null;
		ListNode it = head;
		while ( it.next != null){
			if (s.contains(it)){
				return it;
			}
			else{
				s.add(it);
			}
			it = it.next;
		}       
        return null;
    }
	// solution2
	public ListNode detectCycle2(ListNode head){
		if (head == null){
			return null;
		}
		ListNode slow = head;
		ListNode quick = head;
		Boolean cycle= false;
		while(slow.next!=null && quick.next!=null&&quick.next.next!=null){
			slow = slow.next;
			quick = quick.next.next;
			if (slow == quick){
				cycle = true;
				break;
			}
		}
		if (cycle == false) return null;
		slow = head;
		while (slow != quick){
			slow = slow.next;
			quick = quick.next;
		}
		
		
		return slow;
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
		
		LC142 test = new LC142();
		System.out.println(test.detectCycle2(head).val);
		
		
	}
}
