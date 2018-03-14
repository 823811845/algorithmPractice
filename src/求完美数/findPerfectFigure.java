package ��������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import sun.reflect.generics.tree.Tree;

/**
 * �����������ҵ�һ�����������������ӣ���ʹ�õݹ�ķ���������Щ����������ˣ��ҵ�һ���������������ӣ� �����г��ֵ����⣬��Ϊ�ݹ�Ĳ���̫�࣬����ջ�����
 * 
 * @author 823811845
 *
 */
public class findPerfectFigure {
	ArrayList<Integer> primeNumbers = new ArrayList<>(1000);

	// ��������0��num֮�������������
	ArrayList<Integer> seekPrimeNumber(int num) {
		primeNumbers.add(2);
		for (int i = 3; i < num; i += 2) {
			for (int j = 0; j < primeNumbers.size(); j++) {
				if (i % primeNumbers.get(j) == 0) {
					// ˵�����������������,�Զ���ʼ����һ��
					break;
				}
				if (j == primeNumbers.size() - 1) {
					// ˵��û���ҵ����������ҵ������������i��һ������
					primeNumbers.add(i);
					// System.out.println(i);
				}
			}
		}
		return primeNumbers;
	}

	// ��һ������������������
	// ˼·����С�ڵ���������ֵ�һ����������������������ȡ�������ҵ���Щ��������
	ArrayList<Integer> seekPrimeFactor(int figure) {
		int halfFigure = figure / 2;
		ArrayList<Integer> primefactors = new ArrayList<>(1000);
		for (int i = 0; primeNumbers.get(i) <= halfFigure; i++) {
			if (figure % primeNumbers.get(i) == 0) {
				// ˵�����������figure������������ӽ���
				primefactors.add(primeNumbers.get(i));
				// System.out.println(primeNumbers.get(i));
			}
		}
		// ���ж�������ֱ����ǲ���һ��������
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
	 * ����һ���ݹ麯�������������ӳ���
	 *
	 * @param multiplicator
	 * @param index1
	 *            ��ʾ��ǰ�Ѿ��ݹ鵽�ڼ���Ԫ���� �ݹ����
	 */
	ArrayList<Integer> recursionMultiply(int multiplicator, int index1) {
		// һ��ݹ��Ӧ��һ�����ӣ�������ӵĴ��������ˣ���һ��Ż᷵�ء�

		// �����ѭ��������ͬ��������ӵĳ��ִ�����
		int multiplicator2 = 1;
		for (int i = 0; i <= map[index1][1]; i++) {
			// ����һ�����ӵ���Ӧ�η������Ҽ�¼�������
			multiplicator2 = multiplicator * (int) Math.pow(map[index1][0], i);
			// ˵���˵����һ�������ˣ���������
			if (index1 + 1 == index) {
				factors.add(multiplicator2);
			}

			// ���û�е����һλ���ͼ������õݹ�
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

	// �����������������
	ArrayList<Integer> factors = new ArrayList<>();

	/**
	 * ��һ����������������
	 * 
	 * ˼·�����ǰ�������������������������ֽ⣬�ѵõ������ӽ��У�ȫ���У��õ������е������ӡ�
	 * ����60�ֽ�Ϊ2*2*3*5��Ȼ��2*3��2*5,3*5��2*2*5,2*3*5�ȵ�Ҳ������������
	 * 
	 * @param figure
	 * @return
	 */
	ArrayList<Integer> seekFactor(int figure) {
		int figure2 = figure;
		// �ҳ����е���������
		map = new int[20000][2];
		ArrayList<Integer> primeFactors = seekPrimeFactor(figure2);
		// Ȼ���������������ӷֽ⣬��ÿһ�����Ӻ���Ӧ�Ľ����¼��map��
		for (int i = 0; i < primeFactors.size(); i++) {
			while (figure2 % primeFactors.get(i) == 0) {
				figure2 /= primeFactors.get(i);
				// ͬʱ��¼�������
				mapAdd(primeFactors.get(i));
			}
		}
		factors = new ArrayList<>();

		// ���������ӽ�����ϣ��õ����е�������
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
		// ��ȡ��������
		seekPrimeNumber(range / 2 + 20);
		// ����С�ڵ���range�������������ҵ�������
		for (int i = 0; i <= range; i++) {
			// System.out.println("i "+i);
			// �ҵ����е�������
			factors = seekFactor(i);
			// if (i == 6) {
			// System.out.println(factors);
			// }
			// ����������ӣ���������Ƚϣ�
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
				System.out.println("�ҵ���������" + i);
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
