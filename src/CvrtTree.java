/**
 * Class for converting int array into a binary tree
 * Usage: CvrtTree test = new CvrtTree();
	      int[] a = {2, 1, 4, -1, -1, 3, 5};
		  TreeNode tree = test.constructTree(a, 1);
 * @author zy
 *
 */

public class CvrtTree {
	public TreeNode array2Tree(int[] array){
		if (array == null){
			return null;
		}
		return constructTree(array, 1);
	}
	
	public TreeNode constructTree(int[] input, int index){
		if (index<=0 || index > input.length){
			return null;
		}
		int value = input[index-1];
		if (value == -1) return null;
		TreeNode root = new TreeNode(value);
		root.left = constructTree(input, index*2);
		root.right = constructTree(input, index*2+1);
		return root;
	}
	
	public void preorder(TreeNode root){
		if (root != null){
			System.out.print(root.val+"\t");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void postorder(TreeNode root){
		if (root == null){
			return;
		}
		postorder(root.left); // don't need to check null		
		postorder(root.right);// don't need to check null
		System.out.print(root.val+"\t");
	}
	
	public void inorder(TreeNode root){
		if (root == null){
			return;
		}
		inorder(root.left); // don't need to check null
		System.out.print(root.val+"\t");
		inorder(root.right);// don't need to check null
		
	}
	public static void main (String[] args){
		CvrtTree test = new CvrtTree();
		int[] a = {2, 1, 4, -1, -1, 3, 5};
		TreeNode tree = test.constructTree(a, 1);
		System.out.println("Inorder traversal of the tree is:");
	    test.inorder(tree);
	    System.out.println("\nPreorder traversal of the tree is:");
	    test.preorder(tree);
	    System.out.println("\nPostorder traversal of the tree is");
        test.postorder(tree);
	}
}
