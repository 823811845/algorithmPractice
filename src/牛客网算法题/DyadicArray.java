package 牛客网算法题;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
// 注意：处理好了宏观的问题以后，还要去想，怎样处理比较微观的问题：比如说如果这是个二乘二的矩阵，这个算法能不能应对？
//这种方法是错的，因为假如十乘十的矩阵，target大于array[5][0],你只能排除array[0][0]到array[0][5]这五个数，而不能证明其他95个数和target的关系,
public class DyadicArray {
	public boolean Find(int target, int[][] array) {
		// 这里规定max1，min1,分别是列值的最大值最小值（相当于x）；
		// 规定max2，min2，分别是行值的最大值和最小值（相当于y）；
		int max1 = array.length-1;
		int max2 = array[0].length-1;
		int min1 = 0, min2 = 0;
		int i1 = Findmiddle(min1, max1);
		// 小于第一行的最小值，则返回false
		if (target < array[min1][min2]||target>array[max1][max2]) {
			return false;
		}
		// 如果target大于array的第一行的最大值，则返回这个列号
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
				if (max1 - min1 <= 1) {// 这里去min1做为行值，开始比对min1这一行中的所有的数据
					if (target >= array[max1][min2]) {
						//如果target大于这个二乘二矩阵的右上角的值，那么探针i1的最终值为max1
						i1=max1;
					}else{
						//否则探针i1的最终值为min1;
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