package albb������;

import java.util.ArrayList;

public class NewDemo {
    char[] chars;
    //����涨��ά����ĵ�һ������Ϊ�кţ�Ҳ����x��
    boolean[][] flag;
    String str;

    ArrayList<Integer> from = new ArrayList<>();
    ArrayList<Integer> to = new ArrayList<>();

    public static void main(String[] args) {
        NewDemo demo = new NewDemo();
        //demo.init("�Ҷ�˵����Ҫ�˿���Ҫ�˿�hhh������Ҫ�˿�");
        //demo.init("Ҫ�˿�Ҫ�˿�hhh");
        demo.init("hhh");
        demo.checkSeq();

        System.out.println(demo.from);
        System.out.println(demo.to);
        System.out.println(demo.removeSeq());
    }

    public void init(String str) {
        this.str = str;
        chars = str.toCharArray();
        //��ʼ���ַ����ıȶ���Ϣ����flag��
        flag = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    flag[i][j] = true;
                }
            }
        }
    }

    public String removeSeq() {
        String newStr = str;
        for (int i = 0; i < from.size(); i++) {
            for (int j = 0; j < i; j++) {
                //���м�飬��û��֮ǰ��ɾ�������ǲ��������ɾ�����ݵ���ߣ�����ǣ�Ҫ������λ�ø���
                //FIXME �ϴ����������ˣ�
                if (to.get(j) < from.get(i)) {
                    from.set(i, from.get(i) - to.get(j) + from.get(j));
                    to.set(i, to.get(i) - to.get(j) + from.get(j));
                }
            }
            System.out.println("from" + from);
            System.out.println("to" + to);
            newStr = newStr.substring(0, from.get(i)) + newStr.substring(to.get(i));
        }
        return newStr;
    }

    public void checkSeq() {
        //����Ĺ����ǣ�����flag��������� flag[i][j]�� flag[i+k][j+k]������true������Ҫ��i!=j����
        //��ô˵���������ظ����ݣ�
        for (int i = 0; i < chars.length; i++) {
            //�����ֱ�������ж�i=j�����
            for (int j = i + 1; j < chars.length; j++) {
                int k = checkChar(i, j);
                //Ȼ����i+k�Ƿ���ڵ���j-1,������ڣ���˵���������ظ��������ڵģ�������ڣ�˵�����ظ������������ܲ�ֹ������
                //�ɴ˽�һ�����죬���k+1��j-i���࣬�õ������ݣ���0�Ļ���˵�����ظ������ݣ�������j-i���������������ڶ�����ڵ��ظ�������
                if (k != 0 && (k) % (j - i) == 0) {
                    //���������������˵���������ڵģ���
                    // Ӧ��ȥ����j��i+k֮��Ķ�������
                    /**
                     * ������ʱ������ɾ����Ϊ���ɾ�ˣ��ַ����ͺ�flag����ıȶԽ���Բ����ˣ�Ӧ���Ȱ����Ǵ�������
                     * return str.substring(0,j)+str.substring(j+k);
                     */
                    //����Ҫע���飬����ɾ���Ĳ������û���ص������ݡ�
                    if (checkToremove(j, j + k)) {
                        from.add(j);
                        to.add(j + k);
                    }
                }
            }
        }
    }

    public int checkChar(int i, int j) {
        //����Ϊ�˷�ֹ�ظ���飬���Լ���һ������
        if (i != 0 && j != 0) {
            if (flag[i - 1][j - 1] == true) {
                //˵������ط��Ѿ���������
                return 0;
            }
        }
        int k = 0;
        for (; k < flag.length - j; k++) {
            if (flag[i + k][j + k] != true)
                break;
        }
        boolean bool = true;
        //Ҫ��flag[i][j]��flag[i+k][j]����ȫ������true��
        // ��Ϊ������ڣ��Ǿ�˵������k���ַ���ͬһ���ַ��������ⲻ����
        for (int l = i; l < i + k; l++) {
            if (flag[l][j] == true) {
                continue;
            } else {
                bool = false;
                break;
            }
        }
        if (bool == true) {
            return 0;
        }
        return k;
    }

    /**
     * ����һ����飬����ɾ���Ĳ������û���ص������ݡ�
     */
    public boolean checkToremove(int a, int b) {
        for (int i = 0; i < from.size(); i++) {
            if (a > from.get(i) || b < to.get(i)) {
                //˵��û���ص�
                continue;
            } else {
                //˵�����ص�
                //FIXME ������Ŀ��һ��û�н�������ĵط�������ABCABCDCD����������Ҫ��ô�죨"ABC"���ظ��ģ�"CD"Ҳ���ظ��ģ����������м����ص���һ��C��
                //��ʱ��Ϊ����
                return false;
            }
        }
        return true;
    }
}
