package ţ�����㷨��;
/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ��������
 * �ж��������Ƿ��и�������
 */
//���λ���˼·����target�����½ǵ����Ƚϣ�������ˣ������ƣ����С�ˣ������ƣ�˵���ˣ�ÿ�ƶ�һ�Σ����ų�һ�У�����һ�У���
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
