package С��������;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ��һ���ǿ��������飬�������������Ԫ�ص�ֵ����������ڣ������������ֵ��ʱ�临�Ӷȱ���ΪO(n)�� ���磺 ���룺[2,3,1]�������1
 * ���룺[1,2]�������2 ���룺[1,2,2,3,3]�������1
 * 
 */
public class FindThirdFigure {
	public static int show(int[] input) {
		// ����ʹ��һ�����������������
		LinkedList<Integer> nums = new LinkedList<Integer>();
		// ���ﻹ��һ�����õķ�������ȥԤ�ȼ�����������ʼ�����֣����������������ж��������������ȴ�������ʱ�򣬲Ż�remove��
		// nums.add(new Integer(Integer.MIN_VALUE));
		// nums.add(new Integer(Integer.MIN_VALUE));
		// nums.add(new Integer(Integer.MIN_VALUE));
		// �����һ�����õ�д����������ʲôҲ����ʼ��ӣ��ȵ���ӵ�ʱ��������ȴ��������Ǿ�ȥ��ĩβ��һ����

		for (int i = 0; i < input.length; i++) {
			if (nums.size() == 0) {
				nums.add(input[i]);
			}
			for (int j = nums.size() - 1; j >= 0; j--) {
				if (input[i] == nums.get(j)) {
					// �����ȣ������κδ���
					break;
				}
				if (input[i] < nums.get(j)) {
					nums.add(j + 1, new Integer(input[i]));
					// �Ľ����������������һ���жϣ����������ӵ���Integer.MIN_VALUE��
					// ��ô���ǾͰѰ�һ��������index++,��ʾ�����еĶ���һ������ʵ����Integer.MIN_VALUE
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
		// ��ʱ�������е���������֣�
		if (nums.size() == 3) {
			return nums.get(2);
		} else {
			// ���������������
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