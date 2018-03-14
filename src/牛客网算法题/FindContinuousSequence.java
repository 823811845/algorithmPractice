package 牛客网算法题;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class FindContinuousSequence {
	// 最简单的求法：数列中值*数列长度 例如3,4,5,6的中值就是4.5,4.5*4=18,
	// 输入一个数，遍历这个数的所有因子，其中所有为奇数的因子还可以被除以2，得到一个小数部分是0.5的数字
	// 总结的规律如下：这个数除以双数一定得是.5，这个数除以单数一定得是整数，
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		// 序列中只有一个数的情况不考虑；

		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		// for(int i=sum/2+1;i>=2;i-=2){
		for (int i = 2; i < sum / 2 + 2; i++) {
			int index = sum % i;
			int result = 0;
			result = sum / i;
			// 假设有双数个连续的正整数和等于sum
			if (i % 2 == 0) {
				// 这里要求相除后必须是.5;
				if (index != 0 && i / index == 2) {
					// 令result等于这队数列的最小值。
					result -= (i / 2 - 1);
					if (result > 0) { // 这里添加判断条件是因为防止result为0或者负数。
						ArrayList<Integer> list = new ArrayList<Integer>();
						for (int j = 0; j < i; j++) {
							list.add(result + j);
						}
						lists.add(0, list);
					}
				}
			}
			// 假设有单数个连续的正整数和等于sum
			if (i % 2 != 0) {
				// 这里要求相除后必须是整数;
				if (index == 0) {
					// 令result等于这队数列的最小值。
					result -= (i / 2);
					if (result > 0) { // 这里添加判断条件是因为防止result为0或者负数。
						ArrayList<Integer> list = new ArrayList<Integer>();
						for (int j = 0; j < i; j++) {
							list.add(result + j);
						}
						lists.add(0, list);
					}
				}
			}

		}
		return lists;
	}
}