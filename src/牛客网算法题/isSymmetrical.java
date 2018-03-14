package ţ�����㷨��;

/**
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
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
		// ���ڶ������������������������Ϊ������ô�����ǶԳƵ�
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