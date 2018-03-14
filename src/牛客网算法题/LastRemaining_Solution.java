package 牛客网算法题;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Test;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,
 * 让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“
 * 名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class LastRemaining_Solution {
	public int LastRemaining_Solution(int n, int m) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i;
		}
		int index = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m; j++) {
				index++;
				if (index > n) {
					index -= n;
				}
				while (nums[index - 1] == -1) {
					index++;
					if (index > n) {
						index -= n;
					}
				}
			}
			nums[index - 1] = -1;
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] != -1) {
				return i;
			}
		}
		return -1;
		// 第一次抽中的小朋友和第二次抽中的小朋友相差m；
	}

	@Test
	public void test() {
		LastRemaining_Solution(5, 3);
	}
}