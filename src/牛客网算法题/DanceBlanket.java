package ţ�����㷨��;

import java.util.Scanner;

/**
 * ���ڳ���ȱ���˶���С�ڷ����Լ������ӷ������࣬�������뽡����׼ȷ��˵�Ǽ��ʡ�
 * С������һ��Բ�ε�̺�ӣ������Ƿֳ����ȷ֣��ֱ����A,B,C����֮Ϊ������̺���������˶���ʽ��ÿ�ζ���A��ʼ����ÿ�ζ������������������飬������������A���Ҳ���ԭ����.Ϊ�ﵽ����Ч����С��ÿ�춼������n�Σ�������ͻȻ��֪��������n��ʱ������������������˺ü���û�������_��
 * ���ھ���������������ܹ��ж���������
 * <p>
 * ��������:
 * ��������������ɲ���������ÿ����������ռһ�У���ʾn��ֵ(1<=n<=1000)��
 * ��nΪ0ʱ���������
 * <p>
 * �������:
 * ÿ���������������ռһ�У����������ǳ��࣬������10000ȡģ�Ľ��.
 */
public class DanceBlanket {

    public static void main(String[] args) {
        DanceBlanket dance = new DanceBlanket();
//        Recursion recursion=dance.new Recursion();
//        recursion.theMain();
        dance.demo2();
    }

    /**
     * ʹ�õ����ķ�ʽ
     */
    void demo2() {
        /**
         *  ˼·�������Ѿ�֪��A(n)=B(n-1)+C(n-1)=2*A(n-2)+B(n-2)+C(n-2)
         *  ��ΪA(n-1)=B(n-2)+C(n-2)
         *  ��ôA(n)=2*A(n-2)+A(n-1)
         *   ���ǵõ�����:A(n)=A(n-1)+2*A(n-2)
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
         * ע�⣬�����㷨�Ľ���ǶԵģ����Ǹ��Ӷ�̫���ˣ���Ϊ�㷨����ʹ�õ��ǵݹ飬����A(n)ʱ��ʵ�����ǰ�A(0)��A(n)������һ��
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