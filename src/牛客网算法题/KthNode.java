package ţ�����㷨��;

/**
 * ����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
 */

public class KthNode {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	// �鿴ĳһ���ڵ�����к��Ǻ����ѵģ�������Գ����������
	int count=0;
    TreeNode result=null;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null||k<1){
            return null;
        }
        midTraversal(pRoot,k);
    	return result;
    }
    //���������ö�����,���Ҳ�������Ҫ�Ľڵ�
	void midTraversal(TreeNode node,int k){
        if(node==null||result!=null){
            return;
        }
            midTraversal(node.left,k);
        count++;
        if(count==k){
            result=node;
        }
            midTraversal(node.right,k);
	return ;
    }
	
	public class Backups{
		TreeNode KthNode(TreeNode pRoot, int k) {
			if (k < 1) {
				return null;
			}
			while (true) {
				int orderNum = findNum(pRoot);
				if (orderNum == k) {
					return pRoot;
				}
				if (orderNum > k) {
					pRoot = pRoot.left;
				}
				if (orderNum < k) {
					pRoot = pRoot.right;
				}
			}
		}

		// ����ĳһ���ڵ���ǵڼ���Ľڵ㣬
		int findNum(TreeNode node) {
			if (node == null) {
				return 0;
			}
			// ��������Ҫ�Ѹ��ڵ�����ӽڵ�����ݽڼӽ�ȥ��
			// if(node.)

			if (node.left == null) {
				return 1;
			} else {
				if (node.left.right != null) {
					return findNum(node.left) + countNum(node.left.right) + 1;
				} else {
					return findNum(node.left) + 1;
				}
			}
		}

		// ����ĳһ���ڵ���һ���ж��ٸ��ڵ㣨����ʱ����������ڵ����ڣ�
		int countNum(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int count = 1;
			if (node.left != null) {
				count += countNum(node.left);
			}
			if (node.right != null) {
				count += countNum(node.right);
			}
			return count;
		}
	}
	
}