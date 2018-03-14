package 排序算法;

import java.util.Arrays;

public class HeapSort {
	// 这里我们调整以input[start]为根的子树，其中，父节点input[n]的孩子节点为input[2*n+1]和input[2*n+2]
	// 范围是start<=n<end
	public void adjustHeap(int[] input, int start, int end) {
		int temp = input[start];
		for (int i = start * 2 + 1; i < end; i *= 2 + 1) {
			//这里重点看，为什么一定要加&&i<end-1，怎么注意这一类的问题？
			if (input[i] < input[i + 1]&&i<end-1) {
				i++;
				// 这时候，input[i]就是最大的孩子节点的值
			}
			if (temp >= input[i]) {
				// 说明这个树和他的孩子节点之间的关系是正确的。
				break;
			}
			// 否则，就交换这两个点的值
			input[start] = input[i];
			start=i;
			input[i] = temp;
		}
		
	}

	public void heapSort(int[] input) {
		// 先构建大顶堆
		for (int i = input.length / 2 - 1; i >= 0; i--) {
			adjustHeap(input, i, input.length);
		}

		// 然后把堆顶的最大的值和数组的最右边的值互换（因为是从小到大排序）
		for (int i = input.length - 1; i >= 0; i--) {
			int temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			// 然后在维护这个堆
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
