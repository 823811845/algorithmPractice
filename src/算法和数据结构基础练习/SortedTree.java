package �㷨�����ݽṹ������ϰ;

import org.junit.Test;
/**
 *������������һ������������ 
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
				//������ڵ�ǰ�ڵ㣬�ͺ��������ӽڵ�Ƚ�
				if (lastNode.rightNode==null) {
					//������ӽڵ�Ϊ�գ����Ŀ��ڵ��������
					lastNode.setRightNode(treeNode);
				}else{
					//�����Ϊ�գ��Ͱѵ�ǰ�ڵ�����һλ
					lastNode=head.rightNode;
					break;
				}
			}else{
				//���С�ڻ��ߵ��ڣ�һ�ɷ�������������￼�ǲ�ȥ�ص������
				if(lastNode.leftNode==null){
					//������ӽڵ�Ϊ�գ����Ŀ��ڵ��������
					lastNode.setLeftNode(treeNode);
				}else{
					//�����Ϊ�գ��Ͱѵ�ǰ�ڵ�����һλ
					lastNode=head.leftNode;
					break;
				}
			}
		}
		//�ҵ���Žڵ��λ�ú󣬿�ʼ�Զ�����������ƽ��,
		//�ж�����ڵ�ĸ��ڵ��ǲ���ƽ��ģ����жϸ��ڵ�ĸ��ڵ�....
		//�ҵ�����ת�����ƽ��ڵ�
	}
	/**
	 * ������ȣ��������������
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
