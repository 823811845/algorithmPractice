package 牛客网算法题;

public class TreeToList_备用 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * 定义这个递归函数，输入一个子树的根，它会把这个子树变成一个链表输出链表的表头，
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
		// p是当前链表的最大值；
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