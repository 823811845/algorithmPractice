package ��������_�����������ȫ����_�ҵ���Сֵ;

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
		// ���ﱾ��������дcompareable�ӿڣ���������Ϊ�˼򻯣�ֱ���ú���ʵ��
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

		// ���ǰ�漸���ַ��Ƚ϶�����ͬ�ģ��ǾͱȽϽϳ����ַ����ж�����ļ����ַ���
		if (mstr.length() > nstr.length()) {
			mstr = mstr.substring(nstr.length(), mstr.length());
			// �Ѷ�����ĵ���һ���µ��ַ�������������Ȼ���ٴε�������������ͽ϶̵��ַ�����Ƚ�
			return isMsmallerThanN(mstr, nstr);
		}
		if (mstr.length() < nstr.length()) {
			nstr = nstr.substring(mstr.length(), nstr.length());
			return isMsmallerThanN(mstr, nstr);
		}
		return 0;
	}

	/**
	 * ���⣺����һ���������飬������������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
	 * ���������������{3,32,321}�����ӡ���������������ų�����С�����֣�
	 */
	public String fullPermutation(List<Integer> listCs) {
//		for (int i = 0; i < listCs.size(); i++) {
//			System.out.println(listCs.get(i).toString());
//		}
		
		Integer[] cs = listCs.toArray(new Integer[listCs.size()]);
		// ����ע�⣬tree���ݽṹ���������ǴӴ�С�ġ�
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
