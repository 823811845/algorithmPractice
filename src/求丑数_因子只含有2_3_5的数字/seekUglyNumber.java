package �����_����ֻ����2_3_5������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import org.junit.Test;

/**
 * ���ǰ�ֻ��������2��3��5������Ϊ���������С�����˳��ĵ�1500������������6,8�ǳ�������14���ǣ���Ϊ����������7.������ϰ���ϰ�1������һ������
 * 
 * @author 823811845
 *
 */
public class seekUglyNumber {
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
		System.out.println(primeNumbers.size());
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
				System.out.println(primeNumbers.get(i));
			}
		}
		// ���ж�������ֱ����ǲ���һ��������
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

		// ���ж�������ֱ����ǲ���2��3��5����
		if (target_factors.contains(figure)) {
			// ˵�����������ҵ��2��3��5��
			return true;
		}

		// �ж����������û��2,3,5�����������
		for (int i = 0; primeNumbers.get(i) <= halfFigure; i++) {
			if (figure % primeNumbers.get(i) == 0) {
				// ˵�����������figure������������ӽ���
				if (!target_factors.contains(primeNumbers.get(i))) {
					// ˵��������ǲ�����Ҫ��
					return false;
				}
			}
		}

		// ���ж��������û���������������û��2,3,5����������������������Ǿ���˵һ����������2,3,5�еģ���
		if (primeNumbers.contains(figure)) {
			return false;
		} else {
			return true;
		}

	}

	// Ѱ�ҳ�����ֻ��������2��3��5������Ϊ����,
	// ��ǰ1500��
	ArrayList<Integer> seekUglyNumber(int range) {
		ArrayList<Integer> uglyNumbers = new ArrayList<>(1600);
		for (int i = 1; i < range; i++) {
			if (seekPrimeFactors2_3_5(i)) {
				// ˵���������һ�����������������ӽ�����
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

	// �����k������(����ֻ��2��3��5)
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
