package 牛客网算法题;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list = new ArrayList<>();
	int target;

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		this.target = target;
		findPath2(root, 0);
		return lists;
	}

	// 这里使用前序遍历
	public void findPath2(TreeNode root, int num) {
		if (root == null) {
			return;
		}
		num += root.val;
		list.add(root.val);
		if (root.left != null) {
			findPath2(root.left, num);
		}
		if (root.right != null) {
			findPath2(root.right, num);
		}
		if (root.left == null && root.right == null) {
			// 已经到达了叶子节点，开始比对和目标值的大小
			if (num == target) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(list);
				lists.add(temp);
			}
		}
		list.remove(list.size() - 1);
	}
}