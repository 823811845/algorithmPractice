package 给出数组_对数组的内容全排列_找到最小值;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class myString implements Comparable<myString> {
	public myString(String str) {
		this.str = str;
	}

	String str;

	@Override
	public int compareTo(myString anotherString) {
		return isMsmallerThanN(str, anotherString.str);
	}

	int isMsmallerThanN(String mstr, String nstr) {
		// 这里本来可以重写compareable接口，但是这里为了简化，直接用函数实现
		// String mstr=m+"";
		// String nstr=n+"";
		int minLength = Math.min(mstr.length(), nstr.length());
		for (int i = 0; i < minLength; i++) {
			if (mstr.charAt(i) < nstr.charAt(i)) {
				return 1;
			}
			if (mstr.charAt(i) > nstr.charAt(i)) {
				return -1;
			}
		}

		// 如果前面几个字符比较都是相同的，那就比较较长的字符串中多出来的几个字符。
		if (mstr.length() > nstr.length()) {
			mstr = mstr.substring(nstr.length(), mstr.length());
			// 把多出来的当成一个新的字符串赋给它本身，然后再次调用这个函数，和较短的字符串相比较
			return isMsmallerThanN(mstr, nstr);
		}
		if (mstr.length() < nstr.length()) {
			nstr = nstr.substring(mstr.length(), nstr.length());
			return isMsmallerThanN(mstr, nstr);
		}
		return 0;
	}

	/**
	 * 问题：输入一个整数数组，把数组里面所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个，
	 * 例如输入的数组是{3,32,321}，则打印出这三个数字能排除的最小的数字，
	 */
	public String fullPermutation(List<Integer> listCs) {
//		for (int i = 0; i < listCs.size(); i++) {
//			System.out.println(listCs.get(i).toString());
//		}
		
		Integer[] cs = listCs.toArray(new Integer[listCs.size()]);
		// 这里注意，tree数据结构的排序结果是从大到小的。
		TreeSet<myString> tree = new TreeSet<>();
		for (int i = 0; i < cs.length; i++) {
			myString str = new myString(cs[i] + "");
			tree.add(str);
		}
		ArrayList<myString> list = new ArrayList<>(tree);
		myString[] strings = (myString[]) list.toArray(new myString[list.size()]);
		String strs = new String();
		for (int i = 0; i < strings.length; i++) {
			strs += strings[strings.length - i - 1].str;
		}
		return strs;
	}
}
