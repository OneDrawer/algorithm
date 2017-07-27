package Code;


/**
 * Created by xwz on 4/6/17.
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;
}
class FullBinarySortTree {
    TreeNode root;
    static int value = 1;

    public FullBinarySortTree(TreeNode root) {
        this.root = root;
    }
    public void buildFullBT(int n, TreeNode root) {
        if(n > 0)
            buildFullBT(n-1, root.left);
        root.value = this.value;
        this.value++;
        n++;
        if(n > 0)
            buildFullBT(n-1, root.right);
    }

    public static void main(String[] args) {
        FullBinarySortTree fbst = new FullBinarySortTree(null);
    }
}
