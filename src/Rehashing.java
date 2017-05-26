
public class Rehashing {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null){
            return null;
        }
        int newsize = hashTable.length * 2;//10
        ListNode[] result = new ListNode[newsize];
        for (int i = 0; i < hashTable.length; i++){//i=3
            ListNode oldNode = hashTable[i];//oldnode = -7
            while (oldNode != null){ // oldnode = -7
                int element = oldNode.val; // element = -7
//                int newIndex;
//                if (element >= 0){
//                    newIndex = Math.abs(element) % newsize;//newIndex = 7
//                } else {
//                    newIndex = newsize - Math.abs(element) % newsize;//newIndex = 7
//                }
                int newIndex = (element % newsize + newsize) % newsize;
                ListNode newNode = result[newIndex];//newNode = [7]
                if (newNode != null){
                    while (newNode.next != null){
                        newNode = newNode.next;
                    }
                    newNode.next = new ListNode(element);
                } else {
                    result[newIndex] = new ListNode(element);
                }
                oldNode = oldNode.next;
            }
        }
        return result;
    }
}
