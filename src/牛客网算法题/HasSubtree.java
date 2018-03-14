package ţ�����㷨��;

/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��,ע������˵���ӽṹ��ָB����A���е�һ��"���" ���� A
 * ��5,6,7,8,9 B:5,6,7 ��ʱ��B����һ��A��һ���ӽṹ����B:5,6,7,8����A���ӽṹ����ΪB����7���ҽڵ�Ӧ����һ��9
 *
 */
public class HasSubtree {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	boolean flag = false;

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		midErgodic(root1, root2);
		return flag;
	}

	// �������
	public void midErgodic(TreeNode root1, TreeNode root2) {
		if (flag) {
			return;
		}
		if (root1.left != null) {
			midErgodic(root1.left, root2);
		}
		if (isSame(root1, root2)) {
			flag = true;
			return;
		}
		if (root1.right != null) {
			midErgodic(root1.right, root2);
		}
	}

	// �����������������������ǲ��Ǻ�root2������������ȫ��ͬ������ͬ�գ���ͬ�ǿ�����ȣ�
	public boolean isSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1.val == root2.val) {
			if (root2.left == null && root2.right == null) {
				return true;
			}
			if (root1.left == null ^ root2.left == null) {
				return false;
			}
			if (root1.right == null ^ root2.right == null) {
				return false;
			}

			if (isSame(root1.left, root2.left) && isSame(root1.right, root2.right)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}