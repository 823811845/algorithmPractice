package 求完美数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import sun.reflect.generics.tree.Tree;

/**
 * 这里我们先找到一个数的所有素数因子，再使用递归的方法，让这些素数因子相乘，找到一个数的所有真因子， 运行中出现的问题，因为递归的层数太多，方法栈溢出。
 * 
 * @author 823811845
 *
 */
public class findPerfectFigure {
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
				// System.out.println(primeNumbers.get(i));
			}
		}
		// 再判断这个数字本身是不是一个素数：
		// if (primeNumbers.contains(figure)) {
		// primefactors.add(figure);
		// }
		return primefactors;
	}
	// @Test
	// public void testseekPrimeFactor(){
	// seekPrimeNumber(1000);
	// System.out.println(seekPrimeFactor(4));
	// }

	int[][] map = new int[20000][2];
	int index = 0;

	void mapAdd(int key) {
		for (int i = 0; i < index; i++) {
			if (map[i][0] == key) {
				map[i][1]++;
				return;
			}
		}
		map[index][0] = key;
		map[index][1]++;
		index++;
	}

	/**
	 * 定义一个递归函数，用来处理子程序
	 *
	 * @param multiplicator
	 * @param index1
	 *            表示当前已经递归到第几个元素了 递归相乘
	 */
	ArrayList<Integer> recursionMultiply(int multiplicator, int index1) {
		// 一层递归对应于一个因子，这个因子的次数乘满了，这一层才会返回。

		// 这里的循环次数等同于这个因子的出现次数，
		int multiplicator2 = 1;
		for (int i = 0; i <= map[index1][1]; i++) {
			// 乘以一个因子的相应次方，并且记录这个数。
			multiplicator2 = multiplicator * (int) Math.pow(map[index1][0], i);
			// 说明乘到最后一个因子了，将结果输出
			if (index1 + 1 == index) {
				factors.add(multiplicator2);
			}

			// 如果没有到最后一位，就继续调用递归
			if (index1 + 1 < index) {
				recursionMultiply(multiplicator2, index1 + 1);
			}
		}
		return factors;
	}

	// @Test
	// public void testMultiply() {
	// int[][] map = { { 2, 2 }, { 3, 2 },{ 4,4 } };
	// recursionMultiply(map, 1, 0);
	// System.out.println(factors);
	// System.out.println(factors.size());
	// }

	// 这个用来储存真因子
	ArrayList<Integer> factors = new ArrayList<>();

	/**
	 * 求一个数的所有真因子
	 * 
	 * 思路：我们把这个数按照它的素数因子来分解，把得到的因子进行，全排列，得到它所有的真因子。
	 * 比如60分解为2*2*3*5，然后2*3，2*5,3*5，2*2*5,2*3*5等等也都是它的因数
	 * 
	 * @param figure
	 * @return
	 */
	ArrayList<Integer> seekFactor(int figure) {
		int figure2 = figure;
		// 找出所有的素数因子
		map = new int[20000][2];
		ArrayList<Integer> primeFactors = seekPrimeFactor(figure2);
		// 然后对这个数按照因子分解，把每一个因子和相应的结果记录到map中
		for (int i = 0; i < primeFactors.size(); i++) {
			while (figure2 % primeFactors.get(i) == 0) {
				figure2 /= primeFactors.get(i);
				// 同时记录这个因子
				mapAdd(primeFactors.get(i));
			}
		}
		factors = new ArrayList<>();

		// 对素数因子进行组合，得到所有的真因子
		factors = recursionMultiply(1, 0);
		if (factors.contains(figure)) {
			factors.remove(factors.indexOf(figure));
		}
		return factors;
	}

	@Test
	public void testseekFactor() {
		seekPrimeNumber(1000);
		System.out.println(seekFactor(6));
	}

	void findPerfectNumber(int range) {
		// 获取所有素数
		seekPrimeNumber(range / 2 + 20);
		// 遍历小于等于range的所有整数，找到完美数
		for (int i = 0; i <= range; i++) {
			// System.out.println("i "+i);
			// 找到所有的真因子
			factors = seekFactor(i);
			// if (i == 6) {
			// System.out.println(factors);
			// }
			// 将真因子相加，和这个数比较：
			int sum = 0;

			for (int j = 0; j < factors.size(); j++) {
				sum += factors.get(j);
			}
			if (i == 8128) {
				System.out.println("i " + i);
				System.out.println(factors);
				System.out.println(sum);
			}
			if (sum == i) {
				System.out.println("找到完美数：" + i);
			}
		}
	}

	@Test
	public void testfindPerfectNumber() {
		// findPerfectNumber(10000);

	}

	public static void main(String[] args) {
//		HashSet<Integer> m = new HashSet<>();
//		System.out.println(m.add(1));
//		System.out.println(m.add(1));
//		System.out.println("sd");
		System.out.println(Arrays.toString(args));
	}

}
