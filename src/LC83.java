// Easy

// Remove Duplicates from Sorted List

// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

public class LC83 {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
	    ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;  // !!!
		ListNode pointer = head;
		while (pointer.next != null){
			ListNode post = pointer.next;
			if (post.val == pointer.val){
				pointer.next = post.next;
			}else{
				pointer = pointer.next; // !!! don't forget this step,for the previous condition dont need it
			}
			//pointer = pointer.next; don't need
		}
		return head;    
    }
	
	public static void main(String[] args){
		LC83 test = new LC83();
		ListNode head = test.new ListNode(1);
		ListNode node1 = test.new ListNode(1);
		ListNode node2 = test.new ListNode(2);
		ListNode node3 = test.new ListNode(2);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		//System.out.println(test.deleteDuplicates(head));
		test.deleteDuplicates(head);
		while (head.next != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println(head.val);
		
		
		
	}

}
