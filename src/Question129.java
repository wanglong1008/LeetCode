public class Question129 {
    class Solution {
        int value=0;
        public int sumNumbers(TreeNode root) {
            helper(root,0);
            return value;
        }
        public void helper(TreeNode root,int val){
            if(root==null){
                return;
            }
            val=val*10+root.val;
            if(root.left==null&root.right==null){
                value+=val;
                return;
            }
            helper(root.left,val);
            helper(root.right,val);
        }
    }
}
