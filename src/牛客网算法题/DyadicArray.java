package ţ�����㷨��;

/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ��������
 * �ж��������Ƿ��и�������
 */
// ע�⣺������˺�۵������Ժ󣬻�Ҫȥ�룬��������Ƚ�΢�۵����⣺����˵������Ǹ����˶��ľ�������㷨�ܲ���Ӧ�ԣ�
//���ַ����Ǵ�ģ���Ϊ����ʮ��ʮ�ľ���target����array[5][0],��ֻ���ų�array[0][0]��array[0][5]���������������֤������95������target�Ĺ�ϵ,
public class DyadicArray {
	public boolean Find(int target, int[][] array) {
		// ����涨max1��min1,�ֱ�����ֵ�����ֵ��Сֵ���൱��x����
		// �涨max2��min2���ֱ�����ֵ�����ֵ����Сֵ���൱��y����
		int max1 = array.length-1;
		int max2 = array[0].length-1;
		int min1 = 0, min2 = 0;
		int i1 = Findmiddle(min1, max1);
		// С�ڵ�һ�е���Сֵ���򷵻�false
		if (target < array[min1][min2]||target>array[max1][max2]) {
			return false;
		}
		// ���target����array�ĵ�һ�е����ֵ���򷵻�����к�
		if (target > array[max1][min2]) {
			i1 = max1;
		} else {
			while (true) {
				if (target == array[0][i1]) {
					return true;
				}
				if (target > array[0][i1]) {
					min1 = i1;
					i1 = Findmiddle(max1, min1);
				}
				if (target < array[0][i1]) {
					max1 = i1;
					i1 = Findmiddle(min1, max1);
				}
				if (max1 - min1 <= 1) {// ����ȥmin1��Ϊ��ֵ����ʼ�ȶ�min1��һ���е����е�����
					if (target >= array[max1][min2]) {
						//���target����������˶���������Ͻǵ�ֵ����ô̽��i1������ֵΪmax1
						i1=max1;
					}else{
						//����̽��i1������ֵΪmin1;
						i1=min1;
					}
//					System.out.println(min1);
					break;
				}
			}
		}
		int i2 = Findmiddle(min2, max2);
		while (true) {
			if (target == array[i1][i2]) {
				return true;
			}
			if (target > array[i1][i2]) {
				min2 = i2;
				i2 = Findmiddle(max2, min2);
			}
			if (target < array[i1][i2]) {
				max2 = i2;
				i2 = Findmiddle(max2, min2);
			}
			if (max2 - min2 <= 1) {
				if (target == array[i1][max2]) {
					return true;
				}
				return false;
			}
		}
	}

	public int Findmiddle(int min, int max) {
		return (min + max) / 2;
	}

	public static void main(String[] args) {
		DyadicArray so = new DyadicArray();
		int[][] array = { { 1, 5, 10 }, { 3, 6, 11 } };
		System.out.println(so.Find(11, array));
	}
}