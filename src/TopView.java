import java.util.List;
import java.util.ArrayList;
// solution 1:借鉴rightSideView的想法，分别找出leftview,rightview, 为了避免侧面看得到但上面
//看不到,又引入了一个叫column的list，将已有的column记录其中，要是前面出现的该column，就不增加
// 这个方法不是很好，建solution2
public class TopView {
	public List<Integer> topView(TreeNode root){
		List<Integer> result1 = new ArrayList<Integer>();
		List<Integer> column1 = new ArrayList<Integer>();
		if ( root == null) return result1;
		column1.add(0);
		result1.add(root.val);
		helper1(root, result1, column1,0);
		helper2(root, result1, column1,0);
		return result1;
		
	}
	// 得到左半边
	public void helper1(TreeNode root , List<Integer> result, List<Integer> column, int width){
		if (root == null) return;
		if (width < column.get(0)){
			result.add(0,root.val);
			column.add(0, width);
		}
		helper1(root.left, result, column, width-1);
		helper1(root.right, result, column, width+1);
	}
	// 得到右半边
	public void helper2(TreeNode root , List<Integer> result, List<Integer> column, int width){
		if (root == null) return;
		if (width > column.get(column.size()-1)){
			result.add(root.val);
			column.add(width);
		}
		helper2(root.right, result, column, width+1);
		helper2(root.left, result, column, width-1);
		
	}
	
	public static void main(String[] args){
		CvrtTree tree = new CvrtTree();
		int[] arr = {5,1,8,2,3,0,10,0,0 ,4};
		TreeNode root = tree.array2Tree(arr);
		TopView test = new TopView();
		System.out.println(test.topView(root));
}
}
