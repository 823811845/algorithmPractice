package ţ�����㷨��;
/**
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 */
public class Add {
	public int Add(int num1,int num2) {
        int num3,num4;
        do{
            num3=num1^num2;
            num4=(num1&num2)<<1;
            num1=num3;
            num2=num4;
        }while(num4!=0);
            return num1;
    }
}
