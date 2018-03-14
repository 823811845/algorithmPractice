package 牛客网算法题;

public class Fibonacci {
	//这里我们讨论求斐波那契数列第n个数的方法：
	//迭代法：
	int Iteration(int target){
		int i1=0,i2=1;
		int val=0;
		for(int i=2;i<=target;i++){
			val=i1+i2;
			i2=val;
			i1=i2;
		}
		return val;
	}
	//方法二：递归的方法来处理这个问题：
	int recursion(int target){
		if(target==0){
			return 0;
		}
		if(target==1){
			return 1;
		}
		return recursion(target-1)+recursion(target-2);
	}
	public static void main(String[] args) {
		int i=3;
		System.out.println(1<<--i);
	}
}
