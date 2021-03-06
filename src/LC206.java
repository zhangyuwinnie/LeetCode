/* 
 * Easy - Reverse Linked List
 * Reverse a singly linked list.
 */

public class LC206 {
	class  ListNode{
		int val;
		ListNode next;
		ListNode(int x){	val = x;}
	}
	// 法一
    public ListNode reverseList(ListNode head) {
    		if (head == null) return null;
        ListNode p = head;
        //ListNode result = new ListNode(1);
        ListNode pre = null;
        while (p.next != null){
        		ListNode cur = new ListNode(p.val);
        		cur.next = pre;
        		pre = cur; // main idea
        		p = p.next;
        }
        p.next = pre; // don't forget last element
        return p;        
    }
    // 法二
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null){
            return null;
        }
        // ListNode dummy = new ListNode(0); !!!
        ListNode prev = null;
        ListNode curt = head;
        while (curt != null){
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        return prev; //!!!
    }
    public static void main (String[] args){
    		LC206 test = new LC206();
    		ListNode head = test.new ListNode(1);
    		ListNode h2 = test.new ListNode(2);
    		head.next = h2;
    		ListNode result = test.reverseList(head);
    		while (result.next != null){
    			System.out.println(result.val);
    			result = result.next;
    		}
    		System.out.println(result.val);
    }
    
    
	
	
}
