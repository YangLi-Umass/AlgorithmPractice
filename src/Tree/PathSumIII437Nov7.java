package Tree;

/**
 * Created by li on 11/7/2016.
 */
public class PathSumIII437Nov7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {
        int[] count = {0,sum};
        helper(root, sum, count);
        return count[0];
    }

    public void helper(TreeNode node, int sum, int[] count) {
        if(node == null) return;
        if(sum == node.val) {
            count[0]++;

            System.out.println(node.val);
        }
        helper(node.left, sum-node.val, count);
        helper(node.right, sum-node.val, count);
        helper(node.left, count[1], count);
        helper(node.right, count[1], count);
    }
}
