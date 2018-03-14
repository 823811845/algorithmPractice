package 牛客网算法题;
/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
//本次基本思路：让target与左下角的数比较，如果大了，就右移，如果小了，就上移（说白了，每移动一次，就排除一行，或者一列），
public class DyadicArray2 {
	public boolean Find(int target, int[][] array) {
        int max1 = array.length-1;
		int max2 = array[0].length-1;
		int i1=0,i2=max2;
    	while(true){
            if(target==array[i1][i2]){
                return true;
            }
			if(target>array[i1][i2]){
                i1++;
            }else{
                i2--;
            }
            if(i1>max1||i2<0){
                return false;
            }
        }
    }
	public static void main(String[] args) {
		DyadicArray2 so = new DyadicArray2();
		int[][] array = { { 1, 5, 10 }, { 3, 6, 11 } };
		System.out.println(so.Find(10, array));
	}
}
