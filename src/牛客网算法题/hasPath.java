package 牛客网算法题;

import java.util.ArrayList;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 * 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
//FIXME 未完成
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
		// 遍历整个矩阵，
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
		// 向上检查：
		if (0 < node - cols && str[index] == matrix[node - cols]) {
			path2 = insertNode(path, node - cols);
			findPath(path2);
		}
		// 向下检查
		if (matrix.length > node + cols && str[index] == matrix[node + cols]) {
			path2 = insertNode(path, node + cols);
			findPath(path2);
		}
		// 向左检查
		if (node % cols != 0 && str[index] == matrix[node - 1]) {
			path2 = insertNode(path, node - 1);
			findPath(path2);
		}
		// 向右检查
		if (node % cols != cols - 1 && str[index] == matrix[node + 1]) {
			path2 = insertNode(path, node + 1);
			findPath(path2);
		}
	}

	ArrayList<Integer> insertNode(ArrayList<Integer> path, int address) {
		// 检查这个字母有没有在path中出现过
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