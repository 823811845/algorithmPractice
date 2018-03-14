package 牛客网算法题;

import java.util.ArrayList;
import org.junit.Test;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class maxInWindows {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		if (size == 0 || size > num.length) {
			return list;
		}
		int temp = num[0];
		for (int i = 0; i < size; i++) {
			if (temp < num[i]) {
				temp = num[i];
			}
		}
		list.add(temp);
		for (int i = size; i < num.length; i++) {
			if (temp < num[i]) {
				temp = num[i];
				list.add(temp);
				continue;
			}
			if (temp == num[i - size]) {
				temp = num[i - size + 1];
				for (int j = i - size + 1; j < i + 1; j++) {
					if (temp < num[j]) {
						temp = num[j];
					}
				}
				list.add(temp);
			} else {
				list.add(temp);
			}
		}
		return list;
	}

	@Test
	public void show() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		maxInWindows(nums, 3);
	}
}