package �㷨�����ݽṹ������ϰ;

/**
 * �㷨��ϰ������������ת����ƽ��
 */
public class TreeNode<T extends Comparable<T>> {
	T val = null;
	TreeNode parentNode = null;
	TreeNode leftNode = null;
	TreeNode rightNode = null;
	private int depth = 0;
	// / ������¼�ڵ�ĸ߶ȣ����е���ת��˫��ת

	public TreeNode(T t) {
		this.val = t;
	}

	/**
	 * ����ǰ�ڵ�����һ�����ӽڵ㣬
	 */
	public void setLeftNode(TreeNode t) {
		this.leftNode = t;
		t.parentNode = this;
		t.depth = this.depth + 1;
	}

	/**
	 * �����ڵ�����һ�����ӽڵ㣬
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
