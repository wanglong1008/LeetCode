import java.util.*;

public class Question113 {
    List<List<Integer>> linkedList = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    public void printRoad(TreeNode node, int count ,int sum){
        if(node == null){
            return;
        }
        if (node.left == null && node.right == null){
            count += node.val;
            if (count == sum){

                LinkedList<Integer> lst = new LinkedList<Integer>(list);
                lst.add(node.val);
                linkedList.add(lst);
            }
        }else {
            count += node.val;
            list.add(node.val);
            printRoad(node.left,count,sum);
            printRoad(node.right,count,sum);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return new LinkedList<>();
        }
        int count = 0;
        printRoad(root,count,sum);
        return linkedList;
    }
}
