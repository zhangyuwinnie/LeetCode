import java.util.ArrayList;

/**
 * Definition of ParentTreeNode:
 */
 class ParentTreeNode {
     public ParentTreeNode parent, left, right;
 }

public class LowestCommonAncestor2 {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here 
        if (root == null || root == A || root == B){
            return root;
        }
        ArrayList<ParentTreeNode> parentsA = getParents(root,A);
        ArrayList<ParentTreeNode> parentsB = getParents(root,B);
        
        int indexA = parentsA.size() - 1;
        int indexB = parentsB.size() - 1;
        ParentTreeNode lca = null;
        while (indexA >= 0 && indexB >= 0){
            if (parentsA.get(indexA) != parentsB.get(indexB)){
                break;
            }
            lca = parentsA.get(indexA); //!!! 细节处理，这样更方便，不用在后面判断是否有lca
            indexA--;
            indexB--;
            
        }
        return lca;
    }
    public ArrayList<ParentTreeNode> getParents(ParentTreeNode root, ParentTreeNode A){
        ArrayList<ParentTreeNode> result = new ArrayList<>();
        ParentTreeNode head = A;
        while (head != null){
            result.add(head);
            head = head.parent;
        }
        return result;
    }
}
