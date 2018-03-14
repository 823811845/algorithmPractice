package ţ�����㷨��;

import java.util.ArrayList;

/**
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ�
 * �����ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� ���� a b c e s f c s a d e e
 * �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��
 * ·�������ٴν���ø��ӡ�
 */
//FIXME δ���
public class hasPath {
	class TreeNode {
		public int x, y;

		public TreeNode(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public ArrayList<TreeNode> sonNode = new ArrayList<TreeNode>();
	}

	char[] matrix, str;
	boolean flag = false;
	int rows, cols;

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		char[][] map = new char[cols][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				map[j][i] = matrix[i * rows + j];
			}
		}
		this.matrix = matrix;
		this.str = str;
		this.rows = rows;
		this.cols = cols;
		// ������������
		ArrayList<Integer> rootNode = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			if (str[0] == matrix[i]) {
				rootNode.add(i);
			}
		}
		for (int i = 0; i > rootNode.size(); i++) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(rootNode.get(i));
			findPath(path);
		}
		return flag;
	}

	public void findPath(ArrayList<Integer> path) {
		int index = path.size();
		if (flag == true || index == str.length) {
			flag = true;
			return;
		}
		int node = path.get(index - 1);
		ArrayList<Integer> path2;
		// ���ϼ�飺
		if (0 < node - cols && str[index] == matrix[node - cols]) {
			path2 = insertNode(path, node - cols);
			findPath(path2);
		}
		// ���¼��
		if (matrix.length > node + cols && str[index] == matrix[node + cols]) {
			path2 = insertNode(path, node + cols);
			findPath(path2);
		}
		// ������
		if (node % cols != 0 && str[index] == matrix[node - 1]) {
			path2 = insertNode(path, node - 1);
			findPath(path2);
		}
		// ���Ҽ��
		if (node % cols != cols - 1 && str[index] == matrix[node + 1]) {
			path2 = insertNode(path, node + 1);
			findPath(path2);
		}
	}

	ArrayList<Integer> insertNode(ArrayList<Integer> path, int address) {
		// ��������ĸ��û����path�г��ֹ�
		if (path.contains(address)) {
			return null;
		} else {
			ArrayList<Integer> path2 = new ArrayList<Integer>();
			path2.addAll(path);
			path2.add(address);
			return path2;
		}
	}
}