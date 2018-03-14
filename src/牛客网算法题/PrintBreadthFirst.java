package 牛客网算法题;

import java.util.ArrayList;

import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBreadthFirst {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		if (pRoot == null) {
			return new ArrayList<ArrayList<Integer>>();
		}
		// 思路：建立两个栈，这两个栈分别交替存储每一层节点的子节点们
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		stack1.add(pRoot);
		boolean flag = true;
		while (!stack1.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (!stack1.isEmpty()) {
				TreeNode node = stack1.pop();
				list.add(node.val);
				if (flag) {
					if (node.left != null) {
						stack2.push(node.left);
					}
					if (node.right != null) {
						stack2.push(node.right);
					}
				} else {
					if (node.right != null) {
						stack2.push(node.right);
					}
					if (node.left != null) {
						stack2.push(node.left);
					}
				}
			}
			flag = !flag;
			lists.add(list);
			Stack<TreeNode> stackTemp = stack1;
			stack1 = stack2;
			stack2 = stackTemp;
		}
		return lists;
	}

}