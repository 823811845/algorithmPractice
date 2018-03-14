package С��������;

import org.junit.Test;

/**
 * ��һ�⣺����һ���ѱ����ַ���������������ַ���������Ĺ����ǣ�n[string]���������ڵ��ַ���string�ظ�n�Ρ�nΪ��������string��Ϊ�գ�
 * �����ո񣬾�ΪӢ���ַ��� ���磺 ���룺"2[a]3[b]"���������aabbb�� ���룺��2[a3[b]]��; �������abbbabbb��
 * ���룺��2[ab]3[c]def��; �������ababcccdef��
 */
// FIXME �����Ҫ���õ����ķ�ʽ���ݹ�ķ�ʽ���ֱ���������һ������ݹ��ܲ����Զ����£�
// ע�����ܣ���Ϊ�ݹ�������Ļ���ԭ�����Ƚ��һ�������⣬������������ֲ����иĶ������������й��ɿ�ѭ��������Ʋ��ܸ���̶��ϼ��ٴ���
// ע���ݹ��˼·���裬��һ�������һ���ֵĽ����ʽ��������������Ľ����ʽ����ʱ�����ǿ��Գ��Խ���������Ľ�ƴ�ճ���������Ľ⣬������̾���һ���ݹ�㣬���Ǳ�д�ĺ������������������ݹ�㡣
public class CodingMessage {
	String input = "2[a3[b]]c4[d]";
	String result = "1";
	char[] chars;
	int end = 0; // ��ʾÿ���ҵ��ַ����Ժ󣬼�¼�ַ���Ľ�βλ��

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
	 * �Ժ�������Ƕ�ײ��䣨���ⲿ���ڲ���
	 */
	public void show() {
		result = input;
		while (result.contains("[")) {
			input = result;
			result = "";
			apartUnits();
		}
	}

	// ���ַ��鵥�β���
	public void apartUnits() {
		chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] > 48 && chars[i] <= 57) {
				// ���ĳһ������ʱ����0С�ڵ���9֮���һ���ַ����Ǿ�˵���з�װ
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
	 * �����Ǳ����ַ������������ֵ�ʱ��������������ҵ���Ӧ��unit�Ľ�βλ��,���Ұ���Ӧ��unit���ء�
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
			// ����j�ĳ�ʼֵһ����chars[j] == '['��
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
		// ������в��䣺һ���ַ���չ����һ���ַ��������ػ�ȥ�����ڱ���ԭ�ַ�������Ӧλ�á�
		for (int i = 0; i < figure; i++) {
			result += buffer.toString();
		}
		return result;
	}

	/**
	 * ����������ȥ�����õݹ����������
	 */
	public class Recursion {
		public void show() {
			chars = input.toCharArray();
			result = apartUtil(0, chars.length);
		}

		// "2[a3[b]]c4[d]";
		// ����ݹ飬����a2[a3[b]]c,�����ﴫ��ľ���a3[b]
		public String apartUtil(int start, int end) {
			int start1 = 0, end1 = 0;
			String result = "";

			for (int i = start; i < end; i++) {
				if (chars[i] > 48 && chars[i] <= 57) {
					int figure = findFigure(chars, i);
					int index = 0;
					// ע�⣬���������Ի��,��i��start�������ĸ���Ӧ����i����������㷨��ʱ�������Ҫ֪��ÿһ��������������ݡ�
					for (int j = i + ((figure + "").length()); j < end; j++) {
						// ����j�ĳ�ʼֵһ����chars[j] == '['��
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
							// �ݹ���ú���
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
