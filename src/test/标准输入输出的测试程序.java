package test;

import java.util.Scanner;

/**
 * �����������Ϊ�����㷨��Ŀ��׼��������Ĳ��Գ���
 */
public class ��׼��������Ĳ��Գ��� {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        String[] s = read.split(" ");
        Integer[] ints=new Integer[s.length];
        int result=0;
        for (int i = 0; i <ints.length ; i++) {
            ints[i]=Integer.parseInt(s[i]);
            result+=ints[i];
        }
        System.out.println(result);

    }
}
