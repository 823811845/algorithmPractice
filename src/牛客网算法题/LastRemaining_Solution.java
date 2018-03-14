package ţ�����㷨��;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Test;

/**
 * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ������,�и���Ϸ��������:����,
 * ��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,
 * ���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�
 * ����̽���ϡ���ذ�(��������Ŷ!!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
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
		// ��һ�γ��е�С���Ѻ͵ڶ��γ��е�С�������m��
	}

	@Test
	public void test() {
		LastRemaining_Solution(5, 3);
	}
}