package ţ�����㷨��;

import java.util.ArrayList;

/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class printMatrix {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		// ��������ʹ�ö�̬�滮��
		int startRow = 0, endRow = matrix.length - 1, startCol = 0, endCol = matrix[0].length - 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (true) {
			// ��һ��
			for (int i = startCol; i <= endCol; i++) {
				list.add(matrix[startRow][i]);
			}
			if (startRow == endRow)
				break;
			startRow++;
			// ���һ��
			for (int i = startRow; i <= endRow; i++) {
				list.add(matrix[i][endCol]);
			}
			if (startCol == endCol)
				break;
			endCol--;
			// ���һ��
			for (int i = endCol; i >= startCol; i--) {
				list.add(matrix[endRow][i]);
			}
			if (startRow == endRow)
				break;
			endRow--;
			// ��һ��
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