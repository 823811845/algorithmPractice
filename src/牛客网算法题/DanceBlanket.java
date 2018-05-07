package 牛客网算法题;

import java.util.Scanner;

/**
 * 由于长期缺乏运动，小黑发现自己的身材臃肿了许多，于是他想健身，更准确地说是减肥。
 * 小黑买来一块圆形的毯子，把它们分成三等分，分别标上A,B,C，称之为“跳舞毯”，他的运动方式是每次都从A开始跳，每次都可以任意跳到其他块，但最后必须跳回A，且不能原地跳.为达到减肥效果，小黑每天都会坚持跳n次，有天他突然想知道当他跳n次时共几种跳法，结果想了好几天没想出来－_－
 * 现在就请你帮帮他，算出总共有多少跳法。
 * <p>
 * 输入描述:
 * 测试输入包含若干测试用例。每个测试用例占一行，表示n的值(1<=n<=1000)。
 * 当n为0时输入结束。
 * <p>
 * 输出描述:
 * 每个测试用例的输出占一行，由于跳法非常多，输出其对10000取模的结果.
 */
public class DanceBlanket {

    public static void main(String[] args) {
        DanceBlanket dance = new DanceBlanket();
//        Recursion recursion=dance.new Recursion();
//        recursion.theMain();
        dance.demo2();
    }

    /**
     * 使用迭代的方式
     */
    void demo2() {
        /**
         *  思路：我们已经知道A(n)=B(n-1)+C(n-1)=2*A(n-2)+B(n-2)+C(n-2)
         *  因为A(n-1)=B(n-2)+C(n-2)
         *  那么A(n)=2*A(n-2)+A(n-1)
         *   我们得到规律:A(n)=A(n-1)+2*A(n-2)
          */
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String read = scan.nextLine();
            int n = Integer.parseInt(read);
            double result = 0, temp1 = 0, temp2 = 1;
            if (n == 0) {
                //System.out.println();
                continue;
            }
            if (n == 1) {
                System.out.println(0);
                continue;
            }
            for (int j = 1; j < n; j++) {
                result = temp1 + 2 * temp2;
                result = result % 10000;
                temp2 = temp1;
                temp1 = result;

            }
            System.out.println((int) (result));
        }
    }

    class Recursion {
        /**
         * 注意，这套算法的结果是对的，但是复杂度太高了，因为算法本身使用的是递归，计算A(n)时候，实际上是把A(0)到A(n)都算了一遍
         */
        public void theMain() {
            Scanner scan = new Scanner(System.in);
            while (scan.hasNextLine()) {
                String read = scan.nextLine();
                int n = Integer.parseInt(read);
                System.out.println(A(n));
            }
        }

        public int A(int n) {
            if (n <= 1) {
                return 0;
            }
            return B(n - 1) + C(n - 1);
        }

        public int B(int n) {
            if (n == 1) {
                return 1;
            }
            return A(n - 1) + C(n - 1);
        }

        public int C(int n) {
            if (n == 1) {
                return 1;
            }
            return B(n - 1) + A(n - 1);
        }
    }
}