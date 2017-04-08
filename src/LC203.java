/**
 * Easy - Remove Linked List Elements
 * 
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author zy
 *
 */
public class LC203 {
	/** solution 1:
	 * 用类似于copy一个list的方法，一个一个node检测，符合条件的就append到最终list上
	 * note：
	 * 1.要建一个fakehead(eg.keep),最后返回fakehead.next就可以了，fakehead好处在于可以将head当做普通node来处理，不然这个题一开始要考虑head是否和val相等的问题
	 * 2.总的思路是copy head上符合条件的node到keep上，需要一个指着head一个一个往后扫描（node），还需要一个指针（pointer）指向重建的list（keep），每建一个新node，往后移一个
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
		 if (head == null){
     		return null;
     }
     ListNode keep = new ListNode(-1);
     ListNode pointer = keep;
     ListNode node = head;
     while (node!= null){
     		if (node.val != val){
     			ListNode diff = new ListNode(node.val);
     			pointer.next = diff;
     			pointer = pointer.next;
     		}
     		node = node.next;
     }
     return keep.next;     
    }
	
	/**
	 * solution2: recursive function
	 */
	public ListNode removeElements2(ListNode head, int val) {
		if (head==null){
			return null;
		}
		if (head.val == val){
			return removeElements2(head.next,val);
		}
		else{
			head.next = removeElements2(head.next,val);
		}
		return head;
	}
}
