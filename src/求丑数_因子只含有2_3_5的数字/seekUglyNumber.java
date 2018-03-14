package 求丑数_因子只含有2_3_5的数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 我们把只包含因子2，3，5的数称为丑数，求从小到大的顺序的第1500个丑数，例如6,8是丑数，而14不是，因为它包含因子7.，我们习惯上把1当做第一个丑数
 * 
 * @author 823811845
 *
 */
public class seekUglyNumber {
	ArrayList<Integer> primeNumbers = new ArrayList<>(1000);

	// 这里先求0到num之间的所有素数，
	ArrayList<Integer> seekPrimeNumber(int num) {
		primeNumbers.add(2);
		for (int i = 3; i < num; i += 2) {
			for (int j = 0; j < primeNumbers.size(); j++) {
				if (i % primeNumbers.get(j) == 0) {
					// 说明这个数有其他因数,自动开始找下一个
					break;
				}
				if (j == primeNumbers.size() - 1) {
					// 说明没有找到在素数中找到因数，即这个i是一个素数
					primeNumbers.add(i);
					// System.out.println(i);
				}
			}
		}
		System.out.println(primeNumbers.size());
		return primeNumbers;
	}

	// 求一个数的所有素数因子
	// 思路：用小于等于这个数字的一半的所有素数，与这个数字取余数，找到那些素数因子
	ArrayList<Integer> seekPrimeFactor(int figure) {
		int halfFigure = figure / 2;
		ArrayList<Integer> primefactors = new ArrayList<>(1000);
		for (int i = 0; primeNumbers.get(i) <= halfFigure; i++) {
			if (figure % primeNumbers.get(i) == 0) {
				// 说明这个素数是figure的因数，则添加进来
				primefactors.add(primeNumbers.get(i));
				System.out.println(primeNumbers.get(i));
			}
		}
		// 再判断这个数字本身是不是一个素数：
		if (primeNumbers.contains(figure)) {
			primefactors.add(figure);
			System.out.println(figure);
		}
		return primefactors;
	}

	boolean seekPrimeFactors2_3_5(int figure) {
		int halfFigure = figure / 2;
		TreeSet<Integer> target_factors = new TreeSet<>();
		target_factors.add(2);
		target_factors.add(3);
		target_factors.add(5);

		// 先判断这个数字本身是不是2或3或5，：
		if (target_factors.contains(figure)) {
			// 说明这个数本身业是2或3或5，
			return true;
		}

		// 判断这个数字有没有2,3,5以外的因数。
		for (int i = 0; primeNumbers.get(i) <= halfFigure; i++) {
			if (figure % primeNumbers.get(i) == 0) {
				// 说明这个素数是figure的因数，则添加进来
				if (!target_factors.contains(primeNumbers.get(i))) {
					// 说明这个数是不符合要求。
					return false;
				}
			}
		}

		// 再判断这个数有没有素因数，（如果没有2,3,5以外的因数，且有因数，那就是说一定有因数是2,3,5中的）。
		if (primeNumbers.contains(figure)) {
			return false;
		} else {
			return true;
		}

	}

	// 寻找丑数：只包含因子2，3，5的数称为丑数,
	// 找前1500个
	ArrayList<Integer> seekUglyNumber(int range) {
		ArrayList<Integer> uglyNumbers = new ArrayList<>(1600);
		for (int i = 1; i < range; i++) {
			if (seekPrimeFactors2_3_5(i)) {
				// 说明这个数是一个丑数，把这个数添加进队列
				uglyNumbers.add(i);
			}
		}
		System.out.println(uglyNumbers.size());
		System.out.println(uglyNumbers);
		return uglyNumbers;
	}

	@Test
	public void testFunction() {
		seekPrimeNumber(10000000);
		// System.out.println(primeNumbers);
		// seekPrimeFactor(7);
		// System.out.println(seekPrimeFactors2_3_5(7));
		seekUglyNumber(10000000);
	}

	// 输出第k个丑数(因子只有2，3，5)
	@Test
	public void test() {
		findUglyNum(150);
	}

	public void findUglyNum(int index) {
		int[] num = new int[index];
		int next = 1;
		num[0] = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;

		while (next < index) {
			int num2 = num[index2] * 2;
			int num3 = num[index3] * 3;
			int num5 = num[index5] * 5;

			num[next] = getSuitable(num2, num3, num5);

			 while(num[index2]*2<=num[next]){
			 index2++;
			 }
			 while(num[index3]*3<=num[next]){
			 index3++;
			 }
			 while(num[index5]*5<=num[next]){
			 index5++;
			 }

//			if (num[index2] * 2 == num[next]) {
//				index2++;
//			}
//			if (num[index3] * 3 == num[next]) {
//				index3++;
//			}
//			if (num[index5] * 5 == num[next]) {
//				index5++;
//			}
			next++;
		}
		System.out.println(Arrays.toString(num));
		return;
	}

	public int getSuitable(int num2, int num3, int num5) {
		int s = num2;
		if (num3 < s) {
			s = num3;
		}
		if (num5 < s) {
			s = num5;
		}
		return s;
	}

}
