package test;

import java.util.Scanner;

/**
 * 这个类用于作为测试算法题目标准输入输出的测试程序
 */
public class 标准输入输出的测试程序 {
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
