package 牛客网算法题;


/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
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