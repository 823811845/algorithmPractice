package ţ�����㷨��;


/**
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 */
public class StrToInt {
    public int StrToInt(String str) {
        String p = "^[+-]?\\d+$";
        if (!str.matches(p)) {
            return 0;
        }
        int index = 0;
        boolean sign = false;
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == '+') {
                continue;
            }
            if (a == '-' && i == 0) {
                sign = true;
                continue;
            }

            int temp = ((int) (a - 48));
            index += (int) temp * Math.pow(10, str.length() - i - 1);

            System.out.println(temp * Math.pow(10, str.length() - i - 1));
        }
        if (sign) index *= -1;
        return index;
    }


    public void testName() throws Exception {

    }

    public void test() {
        System.out.println(StrToInt("-2147483648"));
    }
}