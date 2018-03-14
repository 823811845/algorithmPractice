package 牛客网算法题;

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

	// 根据子树的前序和中序，建立子树：(这里约定，子树的内容为ni<=x<nj,pi<=x<pj)
	public TreeNode findInList(int[] pre, int ni, int nj, int[] in, int pi, int pj) {
		if (pj - pi < 1) {
			return null;
		}
		// 先找到根节点：
		int index = map.get(pre[ni]);
		TreeNode treeNode = new TreeNode(pre[ni]);
		// 为什么把判断条件放在这里就不行？
		// if(pj-pi<1){
		// return null;
		// }

		// 递归的方法找到左子树：
		treeNode.left = findInList(pre, ni + 1, ni + 1 + index - pi, in, pi, index);// 其中index-pi是左子树的元素数量
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
