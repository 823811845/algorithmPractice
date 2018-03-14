package 牛客网算法题;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）,注意这里说的子结构是指B树是A树中的一个"零件" 比如 A
 * ：5,6,7,8,9 B:5,6,7 这时候B就是一个A的一个子结构，而B:5,6,7,8则不是A的子结构，因为B树中7的右节点应该有一个9
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

	// 中序遍历
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

	// 这个旗标用来检验所检查的树是不是和root2的左右子树完全相同；（即同空，或同非空且相等）
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