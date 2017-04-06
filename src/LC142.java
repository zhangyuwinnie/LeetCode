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
	/**
	 * solution1：hash table
	 * 将node地址存入hash table，然后查重
	 * @param head
	 * @return
	 */
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
	/**
	 * solution2: 快慢指针
	 * 用快慢指针判断是否有cycle，如有一个指针在始端，一个在meet处，每次各走一步，相遇处为cycle起点
	 * note: 起点到cycle起点距离s，cycle周长r， 第一次walk，速度差为1，设经过k步 2k-k = r，所以k=r，如果一个
	 * 在起点，一个在首次相遇处，两点相差距离k（因为经过了k步），之后都以1的速度向前，在k处的点有k-s的长度是在圈上
	 * 的，所以距离圈的起点为r-（k-s），因为r=k，所以距离就是s，所以起点的点走过s正好与出发自k处的点，在圈的起始
	 * 位置相遇
	 * @param head
	 * @return
	 */
	// solution2: 用快慢指针判断是否有cycle，如有一个指针在始端，一个在meet处，每次各走一步，相遇处为cycle起点
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
