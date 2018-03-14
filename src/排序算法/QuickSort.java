package 排序算法;

import java.util.Arrays;
/**
 * 快速排序
 * 
 * 从数列中挑出一个元素，称为“基准”
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
 * 该基准是它的最后位置。这个称为分割（partition）操作。 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 
 * @param numbers
 * @param start
 * @param end
 */
public class QuickSort {
	// 普通的快速排序
	// 这里的递归函数用来把下标在 start<=n<end的数组部分排序
	public int[] quickSort(int[] input, int start, int end) {
		if (end - start <= 1) {
			return input;
		}
		int i = start, j = end - 1;
		while (i < j) {
			// 令左边的数组部分都是小于等于base的
			while (input[j] >= input[i] && j > i) {
				j--;
			}
			if (i < j) {
				// 则进行交换
				swap(input, j, i);

			}
			while (input[i] <= input[j] && i < j) {
				i++;
			}
			if (i < j) {
				// 则进行交换
				swap(input, i, j);
			}
		}
		// 从循环跳出的时候，i一定是等于j的,这个位置就是base的位置
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
