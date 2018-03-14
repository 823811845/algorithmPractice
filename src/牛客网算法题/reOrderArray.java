package 牛客网算法题;

import java.util.Arrays;

import org.junit.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
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

	// 借助类似于选择排序的调整方法；
	// 把奇数添加到分界线的左边（紧贴着分界线）；把偶数添加到分界线的右边（紧贴着分界线）
	boolean exchange() {
		boolean flag = false;
		int odd = 0, even = 0;
		int oddFigure=0, evenFigure=0;
		for (int i = divide - 1; i >= 0; i--) {
			if (array[i] % 2 == 0) {
				flag = true;
				even = i;
				evenFigure=array[even];
				// 向左移动相应的部分数组，
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
		// 把找到的数字写入相应的位置：
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