package tTiao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ĳ��˾��Ƹ����n������Χ��HR�ںڰ�������д��m��������A1��A2��A3��.....,Ȼ����n����Χ��һȦ��
 * ���Ұ���˳ʱ������Ǳ��0,1,2,3,4.....n-1��¼ȡ�����ǣ���һ�ִ�0�ŵ��˿�ʼ��ȡ�úڰ��ϵĵ�1�����֣�
 * Ҳ����A1���ڰ��ϵ����ְ�����ѭ��ȡ�ã������ĳ�����˵�m��������һ����Ҫʹ�õ�1�������ĳ���õ���k����
 * ��������Ҫ�õ�k+1����k<m��
 * ÿһ�ְ��պڰ��ϵĴ���ȡ�õ���һ������Ax����̭���ӵ�ǰ�ֵ����˿�ʼ����˳ʱ��˳��������Ax���ˣ�
 * ��һ�ֿ�ʼ�ֵ����˼�Ϊ����̭���˵�˳ʱ��˳����һ���ˣ�����̭����ֱ�ӻؼң����Բ��ᱻ�����ִμ���ʱ��������
 * ����n-1�ֺ�ʣ�µ����һ���˼���¼ȡ
 * �������¼ȡ���˵ı���루n��m��A1��A2��A3��....Am�����
 * ���ɣ�n��m��A1��A2��A3��....Am����������һ�˵ı�š�
 * <p>
 * ���磨n��m�����ֱ�Ϊ4,2����A1��A2��A3��....Am��Ϊ3,1
 * ��ô���1
 */
public class Three {
    /**
     * ��һ��ĳ����⣬��򵥵ķ���Ī����ֱ��ȥģ������
     */

    LinkedList<Integer> ns = new LinkedList<>();
    int[] ms;

    public static void main(String[] args) {
        Three main = new Three();
        main.show();
    }

    public void show() {
        //��������
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
        //�ֱ��ʾ��ǰ�ֵ�m��n
        int m = 0, n = 0;
        for (int i = 0; ns.size() > 1; i++) {
            m = ms[i];
            for (int j = 0; j < m; j++) {
                n++;
                if (n >= ns.size()) {
                    n = 0;
                }
            }
            //��̭�����
            ns.remove(n);
            if (i >= ms.length-1) {
                i = 0;
            }
        }
        return ns.get(0);
    }


}