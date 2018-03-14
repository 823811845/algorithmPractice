package 排序算法;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 选择排序算法 在未排序序列中找到最小元素，存放到排序序列的起始位置 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
 * 以此类推，直到所有元素均排序完毕。
 * 
 * @param numbers
 */
public class SelectSort {
	// 选择排序
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
