package 排序算法;

import java.util.Arrays;
/**
 * 冒泡排序 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 
 * @param numbers
 *            需要排序的整型数组
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
