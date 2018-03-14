package ţ�����㷨��;

import java.util.TreeMap;

public class FindTreeNode {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null) {
			return null;
		}
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return findInList(pre, 0, pre.length, in, 0, in.length);
	}

	// ����������ǰ������򣬽���������(����Լ��������������Ϊni<=x<nj,pi<=x<pj)
	public TreeNode findInList(int[] pre, int ni, int nj, int[] in, int pi, int pj) {
		if (pj - pi < 1) {
			return null;
		}
		// ���ҵ����ڵ㣺
		int index = map.get(pre[ni]);
		TreeNode treeNode = new TreeNode(pre[ni]);
		// Ϊʲô���ж�������������Ͳ��У�
		// if(pj-pi<1){
		// return null;
		// }

		// �ݹ�ķ����ҵ���������
		treeNode.left = findInList(pre, ni + 1, ni + 1 + index - pi, in, pi, index);// ����index-pi����������Ԫ������
		treeNode.right = findInList(pre, ni + 1 + index - pi, nj, in, index + 1, pj);
		return treeNode;
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		FindTreeNode find = new FindTreeNode();
		find.reConstructBinaryTree(pre, in);
	}
}
