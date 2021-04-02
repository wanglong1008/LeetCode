public class Question105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return tree(preorder,inorder,0,inorder.length,0);
    }
    public TreeNode tree(int[] preorder, int[] inorder,int left,int right,int head){
        if(left>=right||head>=preorder.length){
            return null;
        }
        TreeNode root=new TreeNode(preorder[head]);
        int i=0;
        for(;i<right-left;i++){
            if(inorder[i+left]==preorder[head]) break;
        }
        root.left=tree(preorder,inorder,left,left+i,head+1);
        root.right=tree(preorder,inorder,left+i+1,right,head+i+1);
        return root;
    }
}
