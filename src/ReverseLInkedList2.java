//￼￼Reverse a linked list from position m to n.
//Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
//Example
//Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL

public class ReverseLInkedList2 {
	/*
	 * 想法：基于简单情况的reverse list，但要注意首尾的操作，以及m,n的特殊情况
	 * 不同的m，n对应的首位操作不同，基本的是要
	 * prevm->m->...->n->postn->...   ---->  prevm->n->...->m->postn->...
	 * 所以要记录以上4个点
	 * 但如下几个m，n情况要单独考虑
	 * 1.m>=n,原list保持不变
	 * 2.m=1,prevm 就为null，这里要注意实际操作中我们会在head之前加一个dummy node，
	 * 所以其实prevm是存在的，就是dummy node，所以要加一个dummy.next = n,不然返回
	 * dummy.next 的时候就不对了
	 * 3.n为末尾，那么postn 就是null，这个问题不大，因为本来如果postn后面没有node的
	 * 话最后m.next = null,现在就是m.next = postn(null)
	 * 4.还有要注意循环的次数
	 * ---第一次在找出prevm,m,n,postn这些点时，可以直接遍历一下，
	 *    用一个index记录到第几个，或者可以稍微判断一下，index <= n+1
	 * ---第二次在reverse的时候，要注意reverse的次数，因为我们是从null和head开始的，
	 *    所以应该是reverse n-m+1次
	 * 
	 */
    public ListNode reverseBetween(ListNode head, int m, int n) {//3,5
    // write your code here
    if (head == null || m>=n){ //!!!
        return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    
    ListNode prevm = null;
    ListNode nodem = null;
    ListNode noden = null;
    ListNode postn = null;
    int i = 1;
    while (head != null){
        if (i == m-1){
            prevm = head;
        } else if(i == m){
            nodem = head;//3
        } else if (i == n){
            noden = head;//5
        } else if (i == n+1){
            postn = head;
        }
        head = head.next;
        i++;//!!!
    }
    ListNode prev = null;
    ListNode curt = nodem;//3
    for (int a = 0; a <= n-m; a++){//!!! <=
        ListNode temp = curt.next;//5
        curt.next = prev;
        prev = curt;//3
        curt = temp;//5
    }
    if (prevm != null){ //!!!
        prevm.next = noden;
    } else {
        dummy.next = noden;//!!!
    }
    nodem.next = postn;
    return dummy.next;
    
}
}