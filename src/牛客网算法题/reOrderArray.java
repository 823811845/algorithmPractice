package ţ�����㷨��;

import java.util.Arrays;

import org.junit.Test;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�����֤������������
 * ż����ż��֮������λ�ò��䡣
 */

public class reOrderArray {
	int divide = 0;
	int[] array;

	public void reOrderArray(int[] array) {
		this.array = array;
		for (int i : array) {
			if (i % 2 == 1) {
				divide++;
			}
		}
		while (exchange())
			;
	}

	// ����������ѡ������ĵ���������
	// ��������ӵ��ֽ��ߵ���ߣ������ŷֽ��ߣ�����ż����ӵ��ֽ��ߵ��ұߣ������ŷֽ��ߣ�
	boolean exchange() {
		boolean flag = false;
		int odd = 0, even = 0;
		int oddFigure=0, evenFigure=0;
		for (int i = divide - 1; i >= 0; i--) {
			if (array[i] % 2 == 0) {
				flag = true;
				even = i;
				evenFigure=array[even];
				// �����ƶ���Ӧ�Ĳ������飬
				for (int j = i; j < divide - 1; j++) {
					array[j] = array[j + 1];
				}
				break;
			}
		}
		for (int i = divide; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				odd = i;
				oddFigure=array[odd];
				//FIXME
				
				for (int j = i; j >divide; j--) {
					array[j] = array[j-1];
				}
				break;
			}
		}
		// ���ҵ�������д����Ӧ��λ�ã�
		if (flag == true) {
			array[divide - 1] =oddFigure;
			array[divide] = evenFigure;
		}
		return flag;
	}

	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, };
		reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}