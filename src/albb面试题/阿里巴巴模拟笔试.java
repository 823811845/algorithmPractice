package albb������;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * �ڰ���Ͱ͵��������ܿͷ������У�����ַ���ת�����������ת����ʱ�����ǻ��������ժҪ��������ժҪ֮ǰҪ���û�˵���Ļ�����ȥ�ش����ַ���ȥ�صĹ����ǣ�
 * 1.���ڵ�����ظ�����Ҫȥ��������˵�����ղ���˵����Ҫ�˿���Ҫ�˿���Ҫ�˿�Ҷ�˵����Ҫ�˿ ȥ��֮�󣺡��ղ���˵����Ҫ�˿�Ҷ�˵����Ҫ�˿
 * 2.�ظ��������������1�����ԣ�������������������Ҫȥ�أ�������һ��ϸ��û˵���������ǡ������������������ظ���������1�������ظ������ִ��ڵ���4�����֣�Ҫ��Ҫȥ�أ�
 * 3.���ֲ��ܽ���ȥ�أ����ԣ���10000��������Ҫȥ��
 */
public class ����Ͱ�ģ����� {
    public static void main(String[] args) {
        ����Ͱ�ģ����� obj = new ����Ͱ�ģ�����();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(obj.removeSeq(str));
        }
    }

    /**
     * �ַ���ȥ�غ���
     * �����˼·�ǣ������ڵ���������ĸ��ͬ���Ӵ����бȽϣ�����Ӵ��ĳ��ȴ���1������������ȫ��ͬ���Ǿ�ɾ��������Ӵ���
     * Ȼ������ͳ�������ַ�������һ����û��ʲô�Ż����㷨�����ظ���ô�����鷳����
     */
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