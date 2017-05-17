import java.util.HashMap;
// Definition for singly-linked list with a random pointer.
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}

public class CopyListwithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
	// solution 1
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null){
            return null;
        }
        // copy nodes
        RandomListNode traverse = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (traverse != null){
            map.put(traverse, new RandomListNode(traverse.label));
            traverse = traverse.next;
        }
        // copy random, next
        for (RandomListNode node : map.keySet()){
            RandomListNode mapnode = map.get(node);
            mapnode.next =  map.get(node.next);
            mapnode.random = map.get(node.random);
        }
        return map.get(head);
    }
}