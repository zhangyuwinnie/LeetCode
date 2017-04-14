import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
// solution 2: BFS , 增加一个变量指示node所在column，将改变量打包进queue
public class TopView2 {
	public List<Integer> topView(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) return result;
		
		Queue<Queuestack> q = new LinkedList<Queuestack>();
		Queuestack head = new Queuestack(0,root);
		q.add(head);
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (!q.isEmpty()){
			Queuestack curr = q.poll();
			TreeNode t = curr.node;
			int l = curr.level;
			if (map.containsKey(l)){
				if (l<0){
					result.add(0,t.val);
				}
				else{
					result.add(t.val);
				}
				
				map.put(l, t.val );
			}
			if (t.left != null){
				Queuestack k = new Queuestack(l-1, t.left);
				q.offer(k);
			}
			if (t.right != null){
				Queuestack k = new Queuestack(l+1, t.right);
				q.offer(k);
			}
			
			
		}
		return result;
		
	}
	
	// 很重要的一点，想要给TreeNode类增加attribute，但不能该TreeNode类本身时，可以将想要的变量打包进队列中
	class Queuestack{
		int level;
		TreeNode node;
		Queuestack(int x, TreeNode root){
			level = x;
			node = root;
		}
	}
	
	public static void main(String[] args){
		CvrtTree tree = new CvrtTree();
		int[] arr = {5,1,8,2,3,0,10,0,0 ,4};
		TreeNode root = tree.array2Tree(arr);
		TopView2 test = new TopView2();
		System.out.println(test.topView(root));
	}
}
