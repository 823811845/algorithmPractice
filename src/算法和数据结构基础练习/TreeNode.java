package 算法和数据结构基础练习;

/**
 * 算法练习，二叉树的旋转和自平衡
 */
public class TreeNode<T extends Comparable<T>> {
	T val = null;
	TreeNode parentNode = null;
	TreeNode leftNode = null;
	TreeNode rightNode = null;
	private int depth = 0;
	// / 用来记录节点的高度，进行单旋转或双旋转

	public TreeNode(T t) {
		this.val = t;
	}

	/**
	 * 给当前节点增加一个左子节点，
	 */
	public void setLeftNode(TreeNode t) {
		this.leftNode = t;
		t.parentNode = this;
		t.depth = this.depth + 1;
	}

	/**
	 * 给本节点增加一个右子节点，
	 */
	public void setRightNode(TreeNode t) {
		this.rightNode = t;
		t.parentNode = this;
		t.depth = this.depth + 1;
	}

	// @Override
	// public int compareTo(TreeNode o) {
	// if(){}
	// if(this.val.compareTo((T)o.val)>0){
	// return 1;
	// }
	// else{
	//
	// }
	// return 0;
	// }

}
