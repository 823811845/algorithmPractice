package tTiao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 某公司招聘，有n个人入围，HR在黑板上依次写下m个正整数A1，A2，A3，.....,然后让n个人围成一圈，
 * 并且按照顺时针给他们编号0,1,2,3,4.....n-1。录取规则是：第一轮从0号的人开始，取用黑板上的第1个数字，
 * 也就是A1，黑板上的数字按次序循环取用，即如果某轮用了第m个，则下一轮需要使用第1个，如果某轮用到第k个，
 * 则下轮需要用第k+1个（k<m）
 * 每一轮按照黑板上的次序取用到的一个数字Ax，淘汰掉从当前轮到的人开始按照顺时针顺序数到第Ax个人，
 * 下一轮开始轮到的人即为被淘汰的人的顺时针顺序下一个人，被淘汰的人直接回家，所以不会被后续轮次计数时计数到，
 * 经过n-1轮后，剩下的最后一个人即被录取
 * 所以最后被录取的人的编号与（n，m，A1，A2，A3，....Am）相关
 * 试由（n，m，A1，A2，A3，....Am）计算出最后一人的编号。
 * <p>
 * 例如（n，m，）分别为4,2，（A1，A2，A3，....Am）为3,1
 * 那么输出1
 */
public class Three {
    /**
     * 这一类的场景题，最简单的方法莫过于直接去模拟它；
     */

    LinkedList<Integer> ns = new LinkedList<>();
    int[] ms;

    public static void main(String[] args) {
        Three main = new Three();
        main.show();
    }

    public void show() {
        //接收数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ms = new int[m];

        for (int i = 0; i < n; i++) {
            ns.add(i);
        }
        for (int i = 0; i < m; i++) {
            ms[i] = sc.nextInt();
        }
        System.out.println(process());
    }

    public int process() {
        //分别表示当前轮的m和n
        int m = 0, n = 0;
        for (int i = 0; ns.size() > 1; i++) {
            m = ms[i];
            for (int j = 0; j < m; j++) {
                n++;
                if (n >= ns.size()) {
                    n = 0;
                }
            }
            //淘汰这个人
            ns.remove(n);
            if (i >= ms.length-1) {
                i = 0;
            }
        }
        return ns.get(0);
    }


}