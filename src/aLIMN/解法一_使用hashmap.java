package aLIMN;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * �ڰ���Ͱ͵��������ܿͷ������У�����ַ���ת�����������ת����ʱ�����ǻ��������ժҪ��������ժҪ֮ǰҪ���û�˵���Ļ�����ȥ�ش����ַ���ȥ�صĹ����ǣ�
 * 1.���ڵ�����ظ�����Ҫȥ��������˵�����ղ���˵����Ҫ�˿���Ҫ�˿���Ҫ�˿�Ҷ�˵����Ҫ�˿ ȥ��֮�󣺡��ղ���˵����Ҫ�˿�Ҷ�˵����Ҫ�˿
 * 2.�ظ��������������1�����ԣ�������������������Ҫȥ�أ�������һ��ϸ��û˵���������ǡ������������������ظ���������1�������ظ������ִ��ڵ���4�����֣�Ҫ��Ҫȥ�أ�
 * 3.���ֲ��ܽ���ȥ�أ����ԣ���10000��������Ҫȥ��
 */
public class �ⷨһ_ʹ��hashmap {
    String str;
    HashMap<Character, LinkedList<Integer>> map;

    public static void main(String[] args) {
        �ⷨһ_ʹ��hashmap obj = new �ⷨһ_ʹ��hashmap();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            //demo.init("�Ҷ�˵����Ҫ�˿���Ҫ�˿�hhh������������������Ҫ�˿�");
            //demo.init("Ҫ�˿�Ҫ�˿�hhh");
            //demo.init("hhh");
            obj.str = scan.nextLine();
            System.out.println(obj.removeSeq());
        }
    }

    void init() {
        map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                LinkedList<Integer> list = map.get(str.charAt(i));
                list.add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(str.charAt(i), list);
            }

        }
    }

    /**
     * �ַ���ȥ�غ���
     * �����˼·�ǣ������ڵ���������ĸ��ͬ���Ӵ����бȽϣ�����Ӵ��ĳ��ȴ���1������������ȫ��ͬ���Ǿ�ɾ��������Ӵ���
     * Ȼ������ͳ�������ַ�������һ����û��ʲô�Ż����㷨�����ظ���ô�����鷳����
     */
    public String removeSeq() {
        init();
        //Iterator iterator = map.keySet().iterator();
        //while (iterator.hasNext()) {
        //    Object key = iterator.next();
        //    System.out.println("map.get(key) is :"+map.get(key));
        //}

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)) && map.get(str.charAt(i)).size() >= 2) {
                //���п��ܴ����ظ��ַ�����������
                //�鿴�ظ������Ƿ����2������2��ʱ�����Ҫ����
                //FIXME ����ҿ��������Ŀ��д���ǣ��ظ��������������1���������ظ��Ĵ���
                checkSeq(map.get(str.charAt(i)));
            }
        }
        return str;
    }

    /**
     * @param list
     * @return
     */
    public String checkSeq(LinkedList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int tail = checkNeighbor(str, list, i);
            int b = list.get(i + 1);
            if (tail > b) {
                //˵�����ظ�������
                str = str.substring(0, b) + str.substring(tail);
                init();
            } else {
                //˵��û���ظ�������
            }
        }
        return null;
    }

    /**
     * �ݹ�Ƕ�ף������ַ����ظ��ж��ٴΣ������±�Ϊһ��
     * FIXME ���ڵ����⣬���ﵱȥ�ع�һ�κ���֮ǰ�����ݾͲ������ˣ��������¸���һ�¡�
     *
     * @param str
     * @param list
     * @param i
     * @return
     */
    public int checkNeighbor(String str, LinkedList<Integer> list, int i) {
        if (i >= list.size() - 1) {
            //-1��ʾ�Ѿ���ĩβ��
            return -1;
        }
        int a = list.get(i);
        int b = list.get(i + 1);
        //����Ҫ����һ�£����b+b-a�����ַ�����������ô��,(��˵���������Ӵ���������ͬ��ֱ�ӷ���)
        if (b + b - a > str.length() - 1) {
            return b;
        }
        if (str.substring(a, b).equals(str.substring(b, b + b - a))) {
            //���еݹ���֤��
            int tail = checkNeighbor(str, list, i + 1);
            //������ȡ֮ǰ���õ��źţ�
            if (tail == -1) {
                //��ʾ�Ѿ���ĩβ�ˣ�
                return b + b - a;
            }
            if (tail > b + b - a) {
                //˵���������ַ�����ͬ
                return tail;
            }
            return b + b - a;
        }
        return b;
    }


    /**
     * ����Ǳ��õģ�
     * ��һ������ʱ����Ŀ�������ˣ����ظ�����������1������ȥ�ء��������ˡ����ظ��Ĵ���1��ʱ����ȥ�ء�
     * �ⲿ�ִ���ľͲ�ɾ�ˣ���Ϊ�������������ݰ�
     */
    class Alternate {
        public void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            while (scan.hasNext()) {
                String str = scan.nextLine();
                System.out.println(removeSeq(str));
            }
        }

        //�ַ���ȥ�غ���
        public String removeSeq(String str) {
            //����һ�����ݽṹ�������ȶ�����
            HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(str.charAt(i), list);
            }

            for (int i = 0; i < str.length(); i++) {
                if (map.containsKey(str.charAt(i)) && map.get(str.charAt(i)).size() > 2) {
                    //���п��ܴ����ظ��ַ�����������
                    //�鿴�ظ������Ƿ����2������2��ʱ�����Ҫ����
                    //FIXME ����ҿ��������Ŀ��д���ǣ��ظ��������������1���������ظ��Ĵ���
                }

            }
            return null;
        }

        /**
         * @param str
         * @param list
         * @return
         */
        public String checkSeq(String str, LinkedList<Integer> list) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (checkNeighbor(str, list, list.get(i))) {
                    //˵���������ַ�����ͬ

                }
            }
            return null;
        }

        /**
         * �ݹ�Ƕ�ף������ַ����ظ��ж��ٴΣ������±�Ϊһ��
         * FIXME ���ڵ����⣬���ﵱȥ�ع�һ�κ���֮ǰ�����ݾͲ������ˣ��������¸���һ�¡�
         *
         * @param str
         * @param list
         * @param a
         * @return
         */
        public boolean checkNeighbor(String str, LinkedList<Integer> list, int a) {
            int b = list.get(a + 1);
            if (str.substring(list.get(a), b).equals(str.substring(b, b + b - a))) {
                //���еݹ���֤��
                if (checkNeighbor(str, list, a + 1)) {
                    //˵���������ַ�����ͬ

                }
                return true;
            }
            return false;
        }
    }
}