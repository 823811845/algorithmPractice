package Å£¿ÍÍøËã·¨Ìâ;

public class NumberOf1 {
	public int NumberOf1(int n) {
		int index = 0;
		if (n >= 0) {
			while (n != 0) {
				if (n % 2 == 1) {
					index++;
				}
				n = n >> 1;
				int i = 1;
				i++;
			}
			return index;
		} else {
			n++;
			while (n != 0) {
				if (n % 2 == 0) {
					index++;
				}
				n /= 2;
			}
			return index;
		}
	}

	public int NumberOf2(int n) {
		int t = 0;
		char[] ch = Integer.toBinaryString(n).toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '1') {
				t++;
			}
		}
		return t;
	}

	public int NumberOf3(int n) {
		int index = 0;
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (a == '1') {
				index++;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		NumberOf1 n = new NumberOf1();
		System.out.println(n.NumberOf2(-2));
		System.out.println((-1) / 2);
		System.out.println((-1) >> 1);
		String str = Integer.toBinaryString(0);
		StringBuffer strb;
		System.out.println(Integer.toBinaryString(6));
	}
}
