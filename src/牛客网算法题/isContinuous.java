package ţ�����㷨��;

import java.util.Arrays;

/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,�����Լ�������,
 * �����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,��Oh My
 * God!������˳��.....LL��������,��������,������\С
 * �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So
 * Lucky!����LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
 *
 */
public class isContinuous {
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return false;
		}
		Arrays.sort(numbers);
		int zero = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				zero++;
			}
		}
		for (int i = zero; i < numbers.length - 1; i++) {
			// ����ж��ӣ��ͷ���false��
			if (numbers[i + 1] == numbers[i]) {
				return false;
			}
			if (zero >= numbers[i + 1] - numbers[i] - 1) {
				zero -= numbers[i + 1] - numbers[i] - 1;
			} else {
				return false;
			}
		}
		return true;
	}
}