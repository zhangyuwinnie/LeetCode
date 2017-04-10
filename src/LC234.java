import java.util.List;
import java.util.ArrayList;

public class LC234 {
	// solution1: 将各node的val提取出来，然后头尾比较 
	public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // extract vals
        List<Integer> values =new  ArrayList<Integer>();
        ListNode list = head;
        while(list != null){
            values.add(list.val);            
            list = list.next;        
        }
        int len = values.size();
        int com = len/2;
        for (int i = 0; i<com; i++){
            if (!values.get(i).equals(values.get(len-1-i))){
                return false;
            }
        }
        return true;        
    }
	// solution2: reverse后半段，然后和head依次比较
	public boolean isPalindrome2 (ListNode head){
		if (head == null){
			return true;
		}
		if (head.next == null){
			return true;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(slow.next!= null && fast.next!= null){
			slow = slow.next;
			fast = fast.next;
			if (fast.next != null){
				fast = fast.next;
			}
			else{
				break;
			}	
		}
		// reverse 后半段
		ListNode pre = null;
		while (slow!= null){
			ListNode cur = new ListNode(slow.val);
			cur.next = pre;
			pre = cur;
			slow = slow.next;
		}
		// 比较reverse和head的上一半
		while ( pre != null){
			if(head.val != pre.val){
				return false;
			}
			head = head.next;
			pre = pre.next;
		}
		return true;
	}
	
	public static void main(String[] args){
		LC234 test = new LC234();
		ListNode li1 = new ListNode(-129);
		ListNode li2 = new ListNode(-129);
		li1.next = li2;
		System.out.println(test.isPalindrome2(li1));
	}
}
