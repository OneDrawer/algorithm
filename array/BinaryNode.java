/*排序二叉树的描述也是一个递归的描述， 所以排序二叉树的构造自然也用递归的：
排序二叉树的3个特征：
1：当前node的所有左孩子的值都小于当前node的值；
2：当前node的所有右孩子的值都大于当前node的值；
3：孩子节点也满足以上两点
*/

public class BinaryNode {
/**
* author: sunxing007,
* 转载请注明来自http://blog.csdn<a href="http://lib.csdn.net/base/dotnet" class='replace_word' title=".NET知识库" target='_blank' style='color:#df3434; font-weight:bold;'>.NET</a>/sunxing007
**/
	private int value;//current value
	private BinaryNode lChild;//left child
	private BinaryNode rChild;//right child
	
	public BinaryNode(int value, BinaryNode l, BinaryNode r){
		this.value = value;
		this.lChild = l;
		this.rChild = r;
	}
	
	public BinaryNode getLChild() {
		return lChild;
	}
	public void setLChild(BinaryNode child) {
		lChild = child;
	}
	public BinaryNode getRChild() {
		return rChild;
	}
	public void setRChild(BinaryNode child) {
		rChild = child;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	//iterate all node.
	public static void iterate(BinaryNode root){
		if(root.lChild!=null){
			iterate(root.getLChild());
		}
		System.out.print(root.getValue() + " ");
		if(root.rChild!=null){
			iterate(root.getRChild());
		}
	}
	
	/**
	 * add child to the current node to construct a tree.
	 * Time: O( nlog(n) )
	 * **/
	public void addChild(int n){
		if(n<value){
			if(lChild!=null){
				lChild.addChild(n);
			}
			else{
				lChild = new BinaryNode(n, null, null);
			}
		}
		else{
			if(rChild!=null){
				rChild.addChild(n);
			}
			else{
				rChild = new BinaryNode(n, null, null);
			}
		}
	}
	
	//test case.
	public static void main(String[] args){
		System.out.println();
		int[] arr = new int[]{23,54,1,65,9,3,100};
		BinaryNode root = new BinaryNode(arr[0], null, null);
		for(int i=1; i<arr.length; i++){
			root.addChild(arr[i]);
		}
		BinaryNode.iterate(root);
	}
}

