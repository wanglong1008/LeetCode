public class Question106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return tree(postorder,inorder,0,inorder.length-1,postorder.length-1);
    }
    public TreeNode tree(int[] postorder, int[] inorder,int left,int right,int head){
        if(left>right||head<0){
            return null;
        }
        TreeNode root=new TreeNode(postorder[head]);
        int i=0;
        for(;i<right-left;i++){
            if(inorder[right-i]==postorder[head]) break;
        }
        root.right=tree(postorder,inorder,right-i+1,right,head-1);
        root.left=tree(postorder,inorder,left,right-i-1,head-i-1);
        return root;
    }
}
