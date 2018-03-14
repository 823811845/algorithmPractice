package 给出数组_对数组的内容全排列_找到最小值;

import java.util.Arrays;
import java.util.List;

public class test {
	// public static void main(String[] args) {
	// int[][] params = { { 321, 32, 3 }, { 11, 45, 156, 12 } };
	//
	// // System.out.println(Arrays.toString(params[0]));
	// // Integer i=Arrays.asList(params[0]).get(0)[0];
	// // System.out.println(Arrays.asList(params[0]).get(0));
	// // System.out.println(Arrays.asList(params[0]).get(0).getClass());
	// // System.out.println(Arrays.asList(params[0]));
	//
	// // Integer d=0;
	// // System.out.println(d.getClass());
	//
	// Integer[] data = { 1, 2, 3, 4, 5 };
	// List list = Arrays.asList(data);
	// System.out.println("元素类型：" + list.get(0).getClass());
	// System.out.println("前后是否相等：" + data.equals(list.get(0)));
	// System.out.println("列表中的元素数量是：" + list.size());
	// }

	public static int test(int N) {
		if (N == 0) {
			return 0;
		}
		if (N <= 2) {
			return 1;
		}
		int index = 1;
		int index2 = 1;
		int temp = 0;
		for (int i = 0; i < N - 2; i++) {
			temp = index + index2;
			index = index2;
			index2 = temp;
		}
		return temp;
	}

	int[] input = { 5, 3, 7, 2, 11, 6 };
	public int findValue(int N) {
		int index = input[N];
		int index2 = 0;
		for (int i = N; i < input.length; i++) {
			if (index2 < input[i]) {
				index2 = input[i];
			}
		}
		int value = index2 - index;
		return value;
	}

	public int test() {
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			if(i< input.length-1&&input[i]<input[i+1]){
				int temp = findValue(i);
				if (result < temp) {
					result = temp;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		test te = new test();
		System.out.println(te.test());
	}

}
