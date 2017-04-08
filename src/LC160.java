import java.util.HashMap;;
public class LC160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null){
			return null;
		}
		HashMap<ListNode,Integer> map = new HashMap<ListNode,Integer>();
		ListNode a = headA;
		while (a!= null){
			map.put(a, 1);
			a = a.next;
		}
		ListNode b = headB;
		while ( b!= null){
			if (map.containsKey(b)){
				return b;
			}
			else{
				b=b.next;
			}
		}
		return null;
    }
}
