package �����㷨;

import java.util.Arrays;

public class javaSort {
	/**
	 * �������� ���������п���һ�����飬�ѵ����λ�ÿ������ᣬ�����һ���ȣ��������С���������������κδ����������Ժ��ٺ�С���Ƕ˱ȣ�
	 * ����С�������������󽻻�������ѭ��������һ��������ɣ���߾��Ǳ�����С�ģ��ұ߾��Ǳ������ģ�Ȼ�����÷��η����ֱ�������������������������
	 * ���ҳ����ᣨĬ�������λlow������numbers�������������λ��
	 * 
	 * @param numbers����������
	 * @param low��ʼλ��
	 * @param high����λ��
	 * @return ��������λ��
	 */
	public static int getMiddle(int[] numbers, int low, int high) {
		int temp = numbers[low]; // ����ĵ�һ����Ϊ����
		while (low < high) {
			while (low < high && numbers[high] > temp) {
				high--;
			}
			numbers[low] = numbers[high];// ������С�ļ�¼�Ƶ��Ͷ�
			while (low < high && numbers[low] < temp) {
				low++;
			}
			numbers[high] = numbers[low]; // �������ļ�¼�Ƶ��߶�
		}
		numbers[low] = temp; // �����¼��β
		return low; // ���������λ��
	}

	/**
	 * ��������
	 * 
	 * ������������һ��Ԫ�أ���Ϊ����׼��
	 * �����������У�����Ԫ�رȻ�׼ֵС�İڷ��ڻ�׼ǰ�棬����Ԫ�رȻ�׼ֵ��İ��ڻ�׼�ĺ��棨��ͬ�������Ե���һ�ߣ���������ָ�֮��
	 * �û�׼���������λ�á������Ϊ�ָpartition�������� �ݹ�ذ�С�ڻ�׼ֵԪ�ص������кʹ��ڻ�׼ֵԪ�ص�����������
	 * 
	 * @param numbers
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] numbers, int start, int end) {
		if (start < end) {
			int base = numbers[start];

			int i = start, j = end;
			do {
				while ((numbers[i] < base) && (i < end))
					i++;
				while ((numbers[j] > base) && (j > start))
					j--;
				if (i <= j) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
					i++;
					j--;
				}
			} while (i <= j);
			if (start < j)
				quickSort(numbers, start, j);
			if (end > i)
				quickSort(numbers, i, end);
		}
	}

	/**
	 * ��������
	 * 
	 * �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ������� ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��
	 * �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�� �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�� ����Ԫ�ز��뵽��λ���� �ظ�����2
	 * 
	 * @param numbers
	 *            ����������
	 */
	public static void insertSort(int[] numbers) {
		int size = numbers.length;
		int temp = 0;
		int j = 0;

		for (int i = 0; i < size; i++) {
			temp = numbers[i];
			// ����temp��ǰ���ֵС����ǰ���ֵ����
			for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
				numbers[j] = numbers[j - 1];
			}
			numbers[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] params = { 1, 5, 3, 7, 2, 6 };
		insertSort(params);
		System.out.println(Arrays.toString(params));
	}
}
