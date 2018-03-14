package 牛客网算法题;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

public class isSymmetrical {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}
		// 对于二叉树，如果它的两个子树互为镜像，那么它就是对称的
		if (isMirror(pRoot.left, pRoot.right)) {
			return true;
		}
		return false;
	}

	boolean isMirror(TreeNode left, TreeNode right) {
		if ((left == null & right == null)) {
			return true;
		}
		if ((left == null ^ right == null)) {
			return false;
		}
		if (left.val == right.val) {
			if (isMirror(left.left, right.right) && isMirror(left.right, right.left)) {
				return true;
			}
		}
		return false;
	}
}