package tTiao����;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * ��Ŀ��ĳƥ��ϵͳ�������³�����������ǰ׺�ַ����⣨ÿ������һ��������ҵ��ַ������������utf8������ַ���������Ŷ���֣�����Ҫ�жϵĿ����Ƿ����ĳ���ַ������Ǹ����ַ�����ǰ׺��
 * ����m���ַ�����ɵ�ǰ׺�ַ�����
 * ����n���ַ�����ɵĴ������ַ�����
 * ����40%�����ݣ�0<m,n<20��
 * ����100%�����ݣ�0<m,n<200��
 * �ַ���ΪUTF-8�ı��룬�������ֵȸ����ַ�������������ASCII��
 */

/**
 * ע�⣬����һ������ַ��������ܳ����ڴ���������ԣ����뿼��ʹ��Ӳ����Դ��
 */
public class Two {
    //�������ʹ���ֵ���
    public static void main(String[] args) {
        Two two = new Two();
        //main.show();
        two.test();
    }

    public void show() {
        //��������
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < a; i++) {
            tree.addword(sc.nextLine());
        }

        for (int i = 0; i < b; i++) {
            String line = sc.nextLine();

            //line.
        }
    }


    public void test() {
        Tree tree = new Tree();
        tree.addword("hello");
        tree.addword("hellol");
        tree.addword("show");
        tree.addword("xixihaha");


        System.out.println(tree.checkPrefix("showme"));
        System.out.println(tree.checkPrefix("hellosindi"));
        System.out.println(tree.checkPrefix("xoxohaha"));
        System.out.println(tree.toString());
    }

    /**
     * �����дһ���ֵ���
     * pass-test
     */
    class Tree {
        //�����������ӽڵ�,ע�⣬�����a�Ǵ����������õ�
        Node root = new Node(null);

        /**
         * ���ǰ׺�����Ƿ���������ʵ�ǰ׺
         */
        public boolean checkPrefix(String str) {
            Node node = root;
            for (int i = 0; i < str.length(); i++) {
                Character a = str.charAt(i);
                Node son = node.getSon(str.charAt(i));
                if (son != null) {
                    //˵�������ĸ�����ҵ�
                    node = son;
                } else {
                    //˵���������ĸû���ҵ�����鿴node�Ƿ�û���ӽڵ㣬
                    // ���û���ӽڵ㣬��ǰ׺����������ƥ���ǰ׺������true
                    // ������ӽڵ㣬˵��ǰ׺��ƥ�䣬����false
                    if (node.a == null && node.sons.size() == 0) {
                        //˵���Ѿ���ǰ׺���е�һ�����ʵ�ĩβ��
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

        public String toString() {
            return root.treeToString();
        }

        void addword(String word) {
            Node node = this.root;
            for (int i = 0; i < word.length(); i++) {
                Character a = word.charAt(i);
                Node son = node.getSon(a);
                if (son != null) {
                    node = son;
                } else {
                    //��������ĸ��Ȼ��ָ������ڵ㣬��������
                    Node tempNode = new Node(a);
                    node.addSon(tempNode);
                    node = tempNode;
                }
            }
            //�����������ĩβ���һ���սڵ㣬��ΪҶ�ӽڵ�
            node.addSon(new Node(null));
        }

        class Node implements Comparable<Node> {
            Node parent;
            Character a;
            TreeSet<Node> sons;

            Node(Character a) {
                this.a = a;
                this.sons = new TreeSet<>();
            }

            @Override
            public String toString() {
                return a + "-" + sons.size();
            }

            /**
             * ��ӡ������
             *
             * @return
             */
            public String treeToString() {
                Queue<Node> queue1 = new LinkedList<>();
                Queue<Node> queue2 = new LinkedList<>();
                String str = "";

                queue1.add(this);
                str += "[" + this.toString() + ",]\n";
                while (!queue1.isEmpty()) {
                    while (!queue1.isEmpty()) {
                        Node node = queue1.poll();
                        if (node.sons.size() != 0) {
                            str += "[";
                            for (Node temp : node.sons) {
                                if (temp == null) {
                                    str += "null,";
                                    break;
                                }
                                str += temp.toString() + ",";
                                queue2.add(temp);
                            }
                            str += "]";
                        }
                    }
                    //�������л���
                    Queue queue = queue1;
                    queue1 = queue2;
                    queue2 = queue;
                    str += "\n";
                }
                return str;
            }

            boolean addSon(Node node) {
                for (Node temp : sons) {
                    if (temp.a.equals(node.a)) {
                        //˵���ظ����������
                        return false;
                    }
                }

                this.sons.add(node);
                node.parent = this;
                return true;
            }

            /**
             * ����У��򷵻�����ڵ㣬���û���򷵻�null
             *
             * @param a
             * @return
             */
            Node getSon(Character a) {
                for (Node temp : sons) {
                    if (temp.a.equals(a)) {
                        //˵������
                        return temp;
                    }
                }
                return null;
            }

            @Override
            public int compareTo(Node node) {
                if (node.a == null) {
                    return -1;
                }
                if (this.a > node.a) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
