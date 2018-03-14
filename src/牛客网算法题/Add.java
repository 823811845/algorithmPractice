package 牛客网算法题;
/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
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
