package ţ�����㷨��;

public class TreeToList_���� {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * ��������ݹ麯��������һ�������ĸ������������������һ�������������ı�ͷ��
	 */
	public TreeNode Convert(TreeNode root) {
		TreeNode node = show(root);
		node.left = null;
		return node;
	}

	public TreeNode show(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			root.left = root;
			return root;
		}
		TreeNode left = Convert(root.left);
		// p�ǵ�ǰ��������ֵ��
		if (left != null) {
			TreeNode maxNode = left.left;
			maxNode.right = root;
			root.left = maxNode;
		} else {
			left = root;
		}
		TreeNode right = Convert(root.right);
		TreeNode maxNode = null;
		if (right != null) {
			maxNode = right.left;
			root.right = right;
			right.left = root;
		} else {
			maxNode = root;
		}
		left.left = maxNode;
		return left;
	}
}