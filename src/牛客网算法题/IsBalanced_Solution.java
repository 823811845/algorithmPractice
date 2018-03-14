package 牛客网算法题;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced_Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}
		int depth1 = 0, depth2 = 0;
		if (root.left != null) {
			if (!IsBalanced_Solution(root.left))
				return false;
			depth1 = getDepth(root.left);
		}
		if (root.right != null) {
			if (!IsBalanced_Solution(root.right))
				return false;
			depth2 = getDepth(root.right);
		}
		if (Math.abs(depth1 - depth2) <= 1) {
			return true;
		}
		return false;
	}

	public int getDepth(TreeNode root) {
		if (root.right == null && root.left == null) {
			return 1;
		}
		int depth1 = 0, depth2 = 0;
		if (root.left != null) {
			depth1 = getDepth(root.left);
		}
		if (root.right != null) {
			depth2 = getDepth(root.right);
		}
		return (depth1 > depth2) ? depth1 + 1 : depth2 + 1;
	}
}