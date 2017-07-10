class ResultType3{
    boolean valid;
    int max;
    int min;
    ResultType3(boolean valid, int max, int min){
        this.valid = valid;
        this.max = max;
        this.min = min;
    }
}
public class ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root).valid;
    }
    public ResultType3 helper(TreeNode root){
        if (root == null){
            return new ResultType3(true,Integer.MIN_VALUE, Integer.MAX_VALUE);//!!!bug1:不能赋值为0，存在负数的情况
        }
        // if (root.left == null && root.right == null){
        //     return new ResultType(true, root.val, root.val);
        // }
        ResultType3 left = helper(root.left);//1,6,6
        ResultType3 right = helper(root.right);//1,-.+
        System.out.println(right.min);
        
        int max = Math.max(Math.max(left.max, right.max), root.val);//root7
        int min = Math.min(Math.min(left.min, right.min), root.val);//root6
        boolean valid = true;
        
        // System.out.println(root.val+" "+left.max+" "+ right.min + " "+left.valid+" "+right.valid);
        // if (root.val > left.max && root.val < right.min && left.valid & right.valid){
        //     valid = true;
        // } else {
        //     valid = false;
        // }
        if (root.left != null && left.max >= root.val){//bug2: 如果是null的话，因为Integer.MIN_VALUE, Integer.MAX_VALUE的缘故，比较不好处理
                                                       // 直接判断一下是否为null，False的情况只出现在非null的情况下
            valid = false;
        } 
        if (root.right != null && right.min <= root.val)
        if (!left.valid || !right.valid){
            valid = false;
        }
        System.out.println("max"+max+"min"+min+"valid"+valid);
        return new ResultType3(valid, max, min);
    }
}
//Note：用分治法，注意两个bug