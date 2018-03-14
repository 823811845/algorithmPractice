package �����㷨;

import java.util.Arrays;

public class HeapSort {
	// �������ǵ�����input[start]Ϊ�������������У����ڵ�input[n]�ĺ��ӽڵ�Ϊinput[2*n+1]��input[2*n+2]
	// ��Χ��start<=n<end
	public void adjustHeap(int[] input, int start, int end) {
		int temp = input[start];
		for (int i = start * 2 + 1; i < end; i *= 2 + 1) {
			//�����ص㿴��Ϊʲôһ��Ҫ��&&i<end-1����ôע����һ������⣿
			if (input[i] < input[i + 1]&&i<end-1) {
				i++;
				// ��ʱ��input[i]�������ĺ��ӽڵ��ֵ
			}
			if (temp >= input[i]) {
				// ˵������������ĺ��ӽڵ�֮��Ĺ�ϵ����ȷ�ġ�
				break;
			}
			// ���򣬾ͽ������������ֵ
			input[start] = input[i];
			start=i;
			input[i] = temp;
		}
		
	}

	public void heapSort(int[] input) {
		// �ȹ����󶥶�
		for (int i = input.length / 2 - 1; i >= 0; i--) {
			adjustHeap(input, i, input.length);
		}

		// Ȼ��ѶѶ�������ֵ����������ұߵ�ֵ��������Ϊ�Ǵ�С��������
		for (int i = input.length - 1; i >= 0; i--) {
			int temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			// Ȼ����ά�������
			adjustHeap(input, 0, i);
		}
	}

	public static void main(String[] args) {
		int[] input = { 5, 4, 4, 3, 6, 2, 1 };
		HeapSort sort = new HeapSort();
		sort.heapSort(input);
		System.out.println(Arrays.toString(input));

	}
}
