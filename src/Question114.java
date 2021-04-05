public class Question114 {
    TreeNode parent=new TreeNode(0);
    public void flatten(TreeNode root) {
        if(root==null) return ;
        help(root);
    }
    public void help(TreeNode a){
        TreeNode left=a.left;
        TreeNode right=a.right;
        parent.right=a;
        a.left=null;
        parent.left=null;
        parent=a;
        if(left!=null) {
            help(left);
        }
        if(right!=null) help(right);

    }
}
