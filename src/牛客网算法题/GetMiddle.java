package ţ�����㷨��;

/**
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 */
import java.util.Vector;

import org.junit.Test;

public class GetMiddle {
	Vector<Integer> nums = new Vector<>();

	public void Insert(Integer num) {
		if (nums.size() == 0) {
			nums.add(num);
			return;
		}
		for (int i = 0; i < nums.size(); i++) {
			if (num < nums.get(i)) {
				nums.add(i, num);
				return;
			}
			if (i == nums.size() - 1) {
				nums.add(nums.size(),num);
				return ;
			}
		}
		
	}

	public Double GetMedian() {
		if (nums.size() == 0) {
			return 0.0;
		}
		int count = nums.size() / 2;
		if (nums.size() % 2 == 0) {
			return Double.valueOf((nums.get(count - 1) + nums.get(count)) / 2.0);
		} else {
			return Double.valueOf(nums.get(count) * 1.0);
		}
	}
	@Test
	public void show(){//[5,2,3,4,1,6,7,0,8]
		Insert(5);
		Insert(2);
		Insert(3);
		Insert(4);
		Insert(1);
		Insert(6);
		System.out.println(GetMedian());
		Insert(7);
		Insert(0);
		Insert(8);
		
	}
}