
public class ReverseNodesinkgroups {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
    	/*
    	 * 想法：分段reverse，写一个专门的function来reverse，每一段reverse都和后面连接好，就不用在外面做连接了，外面只
    	 * 需要监测有没有都reverse好就行了，但为了可以连续的往后reverse，返回值要作为之后reverse的参数，可以选取每段
    	 * reverse之后紧连接着后面没有reverse部分的那个node：
    	 * prev->n1->n2..->nk -> nk+1->...   ------> prev->nk->nk-1...->n2->n1 -> nk+1->...
    	 * function 返回 n1， 参数（n1,k）
    	 */
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev != null){
            prev = reverseKNodes(prev, k);
        }
        return dummy.next;
    }
    
    public ListNode reverseKNodes(ListNode prev, int k){
        // 想法：基础思路是简单的reverse list，但要注意头尾的处理，简单reverse list最后返回reverse后list的头，而这个是要
        //     返回reverse后list的尾，所以要在一开始记录一下这个尾巴，不然随着一对对list往后处理，一开始的头即最后的尾会找
        //     不到，还有一个是第k+1个list，也要记录好，简单reverse list最后是null，但这个问题在reversek个node后，nk的
        //     next不是null，要把这个也记录下来，并作为n1的next, 还有要做一个连接，传进来的prev是上一次reverse的最后一个点，它的next是这组中的nk
        
        ListNode n1 = prev.next;
        if (n1 == null){
            return null;
        }
        ListNode nk = n1;
        for (int i = 0; i < k-1; i++){
            nk = nk.next;
            if (nk == null){
                return null;    
            }
        }
        ListNode nkPlus = nk.next;
        ListNode prevNode = null;
        ListNode currNode = n1;
        
        for (int i = 0; i < k; i++){
            ListNode temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
        }
        n1.next = nkPlus;
        prev.next = nk;
        return n1;
    }    
}