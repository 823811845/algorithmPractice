package ţ�����㷨��;

import java.util.ArrayList;

/**
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100�����������������ڴ�,
 * �����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 */
public class FindContinuousSequence {
	// ��򵥵��󷨣�������ֵ*���г��� ����3,4,5,6����ֵ����4.5,4.5*4=18,
	// ����һ������������������������ӣ���������Ϊ���������ӻ����Ա�����2���õ�һ��С��������0.5������
	// �ܽ�Ĺ������£����������˫��һ������.5����������Ե���һ������������
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		// ������ֻ��һ��������������ǣ�

		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		// for(int i=sum/2+1;i>=2;i-=2){
		for (int i = 2; i < sum / 2 + 2; i++) {
			int index = sum % i;
			int result = 0;
			result = sum / i;
			// ������˫�����������������͵���sum
			if (i % 2 == 0) {
				// ����Ҫ������������.5;
				if (index != 0 && i / index == 2) {
					// ��result����������е���Сֵ��
					result -= (i / 2 - 1);
					if (result > 0) { // ��������ж���������Ϊ��ֹresultΪ0���߸�����
						ArrayList<Integer> list = new ArrayList<Integer>();
						for (int j = 0; j < i; j++) {
							list.add(result + j);
						}
						lists.add(0, list);
					}
				}
			}
			// �����е������������������͵���sum
			if (i % 2 != 0) {
				// ����Ҫ����������������;
				if (index == 0) {
					// ��result����������е���Сֵ��
					result -= (i / 2);
					if (result > 0) { // ��������ж���������Ϊ��ֹresultΪ0���߸�����
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