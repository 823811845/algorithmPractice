package 算法和数据结构基础练习;

import org.junit.Test;
/**
 *这里我们事先一个二叉排序树 
 *
 */
public class SortedTree<T> {
	TreeNode head=null;
	public SortedTree(TreeNode head){
		super();
		this.head=head;
	}
	
	public SortedTree(){
		super();
	}
	public void add(TreeNode treeNode){
		if(head==null){
			head=treeNode;
		}
		TreeNode lastNode=head;
		while(true){
			if(treeNode.val.compareTo(lastNode.val)>0){
				//如果大于当前节点，就和它的右子节点比较
				if (lastNode.rightNode==null) {
					//如果右子节点为空，则把目标节点放在这里
					lastNode.setRightNode(treeNode);
				}else{
					//如果不为空，就把当前节点下移一位
					lastNode=head.rightNode;
					break;
				}
			}else{
				//如果小于或者等于，一律放在左子树里（这里考虑不去重的情况）
				if(lastNode.leftNode==null){
					//如果左子节点为空，则把目标节点放在这里
					lastNode.setLeftNode(treeNode);
				}else{
					//如果不为空，就把当前节点下移一位
					lastNode=head.leftNode;
					break;
				}
			}
		}
		//找到存放节点的位置后，开始对二叉树进行自平衡,
		//判断这个节点的父节点是不是平衡的，再判断父节点的父节点....
		//找到后，旋转这个不平衡节点
	}
	/**
	 * 深度优先，中序遍历二叉树
	 */
	public void show(){
		
	}
	
	@Test
	public void test(){
		int[] param={4,5,3,9,7,1};
		SortedTree<Integer> tree=new SortedTree<Integer>();
		for(int i=0;i<param.length;i++){
			TreeNode treeNode=new TreeNode(param[i]);
			tree.add(treeNode);
		}
	}
}
