package 牛客网算法题;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class printMatrix {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		// 这里我们使用动态规划：
		int startRow = 0, endRow = matrix.length - 1, startCol = 0, endCol = matrix[0].length - 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (true) {
			// 第一行
			for (int i = startCol; i <= endCol; i++) {
				list.add(matrix[startRow][i]);
			}
			if (startRow == endRow)
				break;
			startRow++;
			// 最后一列
			for (int i = startRow; i <= endRow; i++) {
				list.add(matrix[i][endCol]);
			}
			if (startCol == endCol)
				break;
			endCol--;
			// 最后一行
			for (int i = endCol; i >= startCol; i--) {
				list.add(matrix[endRow][i]);
			}
			if (startRow == endRow)
				break;
			endRow--;
			// 第一列
			for (int i = endRow; i >= startRow; i--) {
				list.add(matrix[i][startCol]);
			}
			if (startCol == endCol)
				break;
			startCol++;
		}
		return list;

	}
}