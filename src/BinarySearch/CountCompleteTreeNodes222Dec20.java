package BinarySearch;

/**
 * Created by li on 12/20/2016.
 */
public class CountCompleteTreeNodes222Dec20 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int nodeNum = 0;
        int hLeft, hRight;
        while(root.left != null || root.right != null) {
            hLeft = findHeight(root.left);
            hRight = findHeight(root.right);
            if(hLeft > hRight) {
                nodeNum += 1 <<(hRight+1);
                root = root.left;
            } else {
                nodeNum += 1 <<(hLeft+1);
                root = root.right;
            }
        }
        return nodeNum+1;
    }

    public int findHeight(TreeNode root) {
        if(root == null) return -1;
        int height = 0;
        while(root.left != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}
