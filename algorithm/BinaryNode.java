package algorithm;

/**
 * Created by xwz on 3/6/17.
 * 二叉搜索
 */
public class BinaryNode {
    private int value;
    private BinaryNode lChild;
    private BinaryNode rChild;

    public BinaryNode(BinaryNode l, BinaryNode r, int v) {
        lChild = l;
        rChild = r;
        value = v;

    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setlChild(BinaryNode lChild) {
        this.lChild = lChild;
    }

    public void setrChild(BinaryNode rChild) {
        this.rChild = rChild;
    }

    public int getValue() {
        return value;
    }

    public BinaryNode getlChild() {
        return lChild;
    }

    public BinaryNode getrChild() {
        return rChild;
    }

    public static void itertor(BinaryNode root) {
        if (root.lChild != null) {
            itertor(root.getlChild());
        }
        System.out.print(root.getValue() + " ");
        if(root.rChild != null) {
            itertor(root.getrChild());
        }
    }

    public void addChild(int n) {
        //左子树上添加
        if(n < value) {
            if(lChild != null) {
                lChild.addChild(n);
            }
            else {
                lChild = new BinaryNode(null,null, n);
            }
        }
        else {
            if(rChild != null) {
                rChild.addChild(n);
            }
            else {
                rChild = new BinaryNode(null, null, n);
            }
        }
    }

    public static void main(String[] arg) {
        int[] arr = new int[] {100,23,45,33,78,5,44,34};
        BinaryNode root = new BinaryNode(null, null, arr[0]);
        //添加
        for(int i = 1; i < arr.length; i++) {
            root.addChild(arr[i]);
        }
        itertor(root);
    }
}
