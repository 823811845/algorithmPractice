package �����㷨;

import java.util.Arrays;
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
public class QuickSort {
	// ��ͨ�Ŀ�������
	// ����ĵݹ麯���������±��� start<=n<end�����鲿������
	public int[] quickSort(int[] input, int start, int end) {
		if (end - start <= 1) {
			return input;
		}
		int i = start, j = end - 1;
		while (i < j) {
			// ����ߵ����鲿�ֶ���С�ڵ���base��
			while (input[j] >= input[i] && j > i) {
				j--;
			}
			if (i < j) {
				// ����н���
				swap(input, j, i);

			}
			while (input[i] <= input[j] && i < j) {
				i++;
			}
			if (i < j) {
				// ����н���
				swap(input, i, j);
			}
		}
		// ��ѭ��������ʱ��iһ���ǵ���j��,���λ�þ���base��λ��
		if (start < i)
			quickSort(input, start, i);
		if (end > j)
			quickSort(input, j + 1, end);
		return input;
	}

	public int[] swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		return input;
	}

	public static void main(String[] args) {
		int[] input = { 5, 4, 4, 3, 6, 2, 1 };
		QuickSort sort = new QuickSort();
		sort.quickSort(input,0,input.length);
		System.out.println(Arrays.toString(input));
	}
	
	
	
	

}
