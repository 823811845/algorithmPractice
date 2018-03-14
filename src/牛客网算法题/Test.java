package Å£¿ÍÍøËã·¨Ìâ;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public String ReverseSentence(String str) {
		if (str.length() <= 1) {
			return str;
		}
		String[] strs = str.split(" ");
		String result = "";
		for (int i = strs.length - 1; i >= 0; i--) {
			result += strs[i] + " ";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}
	
	public static void main(String[] args) {
//		System.out.println(2+5/2.0);
//		System.out.println("w".getClass().getName());
//		Test test=new Test();
//		System.out.println(test.ReverseSentence(" "));
		Integer i1=new Integer(1);
		int i2=1;
		System.out.println(i1==i2);
		ArrayList<Integer> s=new ArrayList<>();
		s.contains(i2);
		// //test the stringBuffer
		// StringBuffer str=new StringBuffer();
		// str.append(true);
		// str.append("123231251123412333333333333333333333333333333333333333333");
		// str.append(1);
		// System.out.println(str.toString());
		// System.out.println(str.charAt(2));
		// System.out.println(str.substring(0,2));
		// System.out.println(str.substring(0, 2));
		// Collections.sort(new ArrayList<String>());
		// String str=new String();
		// str.toCharArray();
		// str.replace(1,3,str.charAt(1)+"");
		int[] input = { 5, 4, 4, 3, 2, 1 };
		// Integer[] in = { 5, 4, 4, 3, 2, 1 };
		// ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(in));
		// Integer[] in2 = list.toArray(new Integer[5]);
		// System.out.println(Arrays.toString(in2));

		// test.quickSort(input, 0, 6);
		// quickSort1(input, 0, 5);
		Stack<Integer> stack=new Stack<>();
		LinkedList<Integer> i=new LinkedList<>();
	}
}
