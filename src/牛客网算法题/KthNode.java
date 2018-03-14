package 牛客网算法题;

/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
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
	// 查看某一个节点的序列号是很困难的，这里可以尝试中序遍历
	int count=0;
    TreeNode result=null;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null||k<1){
            return null;
        }
        midTraversal(pRoot,k);
    	return result;
    }
    //中序遍历这棵二叉树,并且查找所需要的节点
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

		// 查找某一个节点的是第几大的节点，
		int findNum(TreeNode node) {
			if (node == null) {
				return 0;
			}
			// 这里是需要把父节点的左子节点的内容节加进去的
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

		// 计算某一个节点下一共有多少个节点（计算时，包括这个节点在内）
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