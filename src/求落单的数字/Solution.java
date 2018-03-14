package 求落单的数字;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Vector;

/**
 * 题目假如说有100001个int数字，其中所有数字都是成对出现的（但是位置随机），唯独只有一个数字时是只出现过一次，要求找出这个数字，
 * 限制条件：所给的计算机配置比较低，内存只有10kb
 *
 */
public class Solution implements InvocationHandler {
	/**
	 * return: The single number.
	 */
	int singleNumber(Vector<Integer> A) {
		// write your code here
		int ans = 0;
		for (int i = 0; i < A.size(); ++i) {
			ans ^= A.get(i);
			System.out.println(ans);
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		Vector<Integer> a = new Vector<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(3);
		a.add(2);
		a.add(1);
		int s = so.singleNumber(a);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	// public static void main(String[] args) {
	// System.out.println(3^5);
	// }
}