package ţ�����㷨��;

import java.util.ArrayList;

/**
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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

	// ����ʹ��ǰ�����
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
			// �Ѿ�������Ҷ�ӽڵ㣬��ʼ�ȶԺ�Ŀ��ֵ�Ĵ�С
			if (num == target) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(list);
				lists.add(temp);
			}
		}
		list.remove(list.size() - 1);
	}
}