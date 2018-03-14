package 小米面试题;

import org.junit.Test;

/**
 * 第一题：输入一个已编码字符串，输出解码后的字符串。编码的规则是：n[string]，中括号内的字符串string重复n次。n为正整数，string不为空，
 * 不含空格，均为英文字符。 比如： 输入："2[a]3[b]"；输出：“aabbb” 输入：“2[a3[b]]”; 输出：“abbbabbb”
 * 输入：“2[ab]3[c]def”; 输出：“ababcccdef”
 */
// FIXME 这道题要求用迭代的方式，递归的方式，分别做出来，一个问题递归能不能自顶向下？
// 注，不能，因为递归解决问题的基本原则是先解决一部分问题，问题的其他部分不能有改动，这样才能有规律可循，程序设计才能更大程度上减少错误。
// 注：递归的思路精髓，当一个问题的一部分的解决方式和这个问题的整体的解决方式相似时候，我们可以尝试将部分问题的解拼凑成完整问题的解，这个过程就是一个递归层，我们编写的函数体就是在描述这个递归层。
public class CodingMessage {
	String input = "2[a3[b]]c4[d]";
	String result = "1";
	char[] chars;
	int end = 0; // 表示每次找到字符组以后，记录字符组的结尾位置

	// @Test
	// public void test() {
	// show();
	// // apartUnit();
	// System.out.println(result);
	// }

	@Test
	public void test() {
		Recursion obj = new Recursion();
		obj.show();
		System.out.println(result);
	}

	/**
	 * 对函数进行嵌套拆箱（从外部向内部）
	 */
	public void show() {
		result = input;
		while (result.contains("[")) {
			input = result;
			result = "";
			apartUnits();
		}
	}

	// 对字符组单次拆箱
	public void apartUnits() {
		chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] > 48 && chars[i] <= 57) {
				// 如果某一个数字时大于0小于等于9之间的一个字符，那就说明有封装
				String result1 = apartUnit(chars, i);
				i = end - 1;
				result += result1;
			} else {
				result += chars[i] + "";
			}
		}
	}

	public int findFigure(char[] chars, int start) {
		int end = start;
		for (int i = start; i < chars.length; i++) {
			if (chars[i] > 48 && chars[i] <= 57) {
				end++;
			} else {
				break;
			}
		}
		String str = "";
		for (int i = start; i < end; i++) {
			str += chars[i];
		}
		return Integer.parseInt(str);
	}

	/**
	 * 当我们遍历字符串，发现数字的时候，这个函数用来找到相应的unit的结尾位置,并且把相应的unit返回。
	 * 
	 * @param chars
	 * @param start
	 * @param end
	 * @return
	 */

	public String apartUnit(char[] chars, int start) {
		int figure = findFigure(chars, start);
		int index = 0;
		end = start;
		String result = "";
		for (int j = start + ((figure + "").length()); j < chars.length; j++) {
			// 这里j的初始值一定是chars[j] == '['的
			if (chars[j] == '[') {
				index++;
			}
			if (chars[j] == ']') {
				index--;
			}
			if (index == 0) {
				end = j + 1;
				break;
			}
		}

		StringBuffer buffer = new StringBuffer();
		for (int i = start + ((figure + "").length()) + 1; i < end - 1; i++) {
			buffer.append(chars[i]);
		}
		// 这里进行拆箱：一个字符组展开成一个字符串，返回回去，用于被在原字符串的相应位置。
		for (int i = 0; i < figure; i++) {
			result += buffer.toString();
		}
		return result;
	}

	/**
	 * 这里我们再去尝试用递归来解决问题
	 */
	public class Recursion {
		public void show() {
			chars = input.toCharArray();
			result = apartUtil(0, chars.length);
		}

		// "2[a3[b]]c4[d]";
		// 整体递归，例如a2[a3[b]]c,则这里传入的就是a3[b]
		public String apartUtil(int start, int end) {
			int start1 = 0, end1 = 0;
			String result = "";

			for (int i = start; i < end; i++) {
				if (chars[i] > 48 && chars[i] <= 57) {
					int figure = findFigure(chars, i);
					int index = 0;
					// 注意，你在这里迷惑过,是i和start到底是哪个，应该是i，这里设计算法的时候，你必须要知道每一个变量代表的内容。
					for (int j = i + ((figure + "").length()); j < end; j++) {
						// 这里j的初始值一定是chars[j] == '['的
						if (chars[j] == '[') {
							if (index == 0) {
								start1 = j + 1;
							}
							index++;
						}
						if (chars[j] == ']') {
							index--;
							if (index == 0) {
								end1 = j;
							}
						}
						if (index == 0) {
							// 递归调用函数
							String result1 = apartUtil(start1, end1);

							// StringBuffer buffer = new StringBuffer();
							// for (int k = start + ((figure + "").length()) +
							// 1; k < end - 1; j++) {
							// buffer.append(chars[i]);
							// }
							for (int k = 0; k < figure; k++) {
								// result+=buffer.toString();
								result += result1;
							}
							i = j;
							break;
						}
					}

				} else {
					result += chars[i];
				}
			}
			return result;
		}
	}
}
