package 小米面试题;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 有一个非空整数数组，返回数组第三大元素的值，如果不存在，返回数组最大值。时间复杂度必须为O(n)。 比如： 输入：[2,3,1]；输出：1
 * 输入：[1,2]；输出：2 输入：[1,2,2,3,3]；输出：1
 * 
 */
public class FindThirdFigure {
	public static int show(int[] input) {
		// 这里使用一下链表，方便添加数据
		LinkedList<Integer> nums = new LinkedList<Integer>();
		// 这里还有一个更好的方法，不去预先加入这三个初始的数字，而是在下面设置判断条件，当链表长度大于三的时候，才会remove。
		// nums.add(new Integer(Integer.MIN_VALUE));
		// nums.add(new Integer(Integer.MIN_VALUE));
		// nums.add(new Integer(Integer.MIN_VALUE));
		// 这里的一个更好的写法是链表中什么也不初始添加，等到添加的时候，如果长度大于三，那就去除末尾的一个。

		for (int i = 0; i < input.length; i++) {
			if (nums.size() == 0) {
				nums.add(input[i]);
			}
			for (int j = nums.size() - 1; j >= 0; j--) {
				if (input[i] == nums.get(j)) {
					// 如果相等，不做任何处理
					break;
				}
				if (input[i] < nums.get(j)) {
					nums.add(j + 1, new Integer(input[i]));
					// 改进方法，在这里添加一个判断，如果这里添加的是Integer.MIN_VALUE，
					// 那么我们就把把一个计数器index++,表示链表中的多了一个“真实”的Integer.MIN_VALUE
					if (nums.size() > 3) {
						nums.remove(3);
					}
					break;
				}
				if (j == 0) {
					nums.add(0, new Integer(input[i]));
					if (nums.size() > 3) {
						nums.remove(3);
					}
					break;
				}
			}
		}
		// 这时候链表中第三大的数字，
		if (nums.size() == 3) {
			return nums.get(2);
		} else {
			// 否则输出最大的数字
			if (nums.size() == 0) {
				return 0;

			} else {
				return nums.get(0);
			}

		}
	}

	public static void main(String[] args) {
//		int[] input = { 1, 2, 2, 3, 3 ,4};
		 int[] input = { 2, 3, 1,};

		System.out.println(show(input));
		System.out.println(Arrays.toString(input));
	}
}