package �����㷨;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * ѡ�������㷨 ��δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ�� �ٴ�ʣ��δ����Ԫ���м���Ѱ����СԪ�أ�Ȼ��ŵ���������ĩβ��
 * �Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�
 * 
 * @param numbers
 */
public class SelectSort {
	// ѡ������
	public int[] selectSort(int[] input) {
		for (int i = 0; i < input.length; i++) {
			int index = i;
			int val = input[i];
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < val) {
					val = input[j];
					index = j;
				}
			}
			int temp = input[i];
			input[i] = val;
			input[index] = temp;
		}
		return input;
	}

	public static void main(String[] args) {
		int[] input = { 5, 4, 4, 3,6, 2, 1 };
		SelectSort sort = new SelectSort();
		sort.selectSort(input);

		System.out.println(Arrays.toString(input));
	}

}
