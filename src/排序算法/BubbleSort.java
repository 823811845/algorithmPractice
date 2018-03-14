package �����㷨;

import java.util.Arrays;
/**
 * ð������ �Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������
 * ��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ�����һ�㣬����Ԫ��Ӧ�û����������� ������е�Ԫ���ظ����ϵĲ��裬�������һ����
 * ����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�
 * 
 * @param numbers
 *            ��Ҫ�������������
 */
public class BubbleSort {
	public int[] bubbleSort(int[] input) {
		boolean flag = true;
		while (flag) {
			flag=false;
			for (int i = 0; i < input.length - 1; i++) {
				if (input[i] > input[i + 1]) {
					swap(input, i, i + 1);
					flag = true;
				}
			}
		}
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
		BubbleSort sort=new BubbleSort();
		sort.bubbleSort(input);
		System.out.println(Arrays.toString(input));
		
	}
}
