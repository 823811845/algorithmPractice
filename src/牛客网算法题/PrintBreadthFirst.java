package ţ�����㷨��;

import java.util.ArrayList;

import java.util.Stack;

/**
 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
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
		// ˼·����������ջ��������ջ�ֱ���洢ÿһ��ڵ���ӽڵ���
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