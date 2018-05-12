package tTiao试题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 题目：某匹配系统存在如下场景：有若干前缀字符串库（每个库有一百万个左右的字符串，保存的是utf8编码的字符串，包库哦汉字），需要判断的库中是否存在某个字符串，是给定字符串的前缀，
 * 输入m个字符串组成的前缀字符串库
 * 输入n个字符串组成的待查找字符串库
 * 对于40%的数据，0<m,n<20万
 * 对于100%的数据，0<m,n<200万
 * 字符串为UTF-8的编码，包括汉字等各种字符串，不仅限于ASCII码
 */

/**
 * 注意，这里一百万个字符串，可能出现内存溢出，所以，必须考虑使用硬盘资源，
 */
public class Two {
    //这里最好使用字典树
    public static void main(String[] args) {
        Two two = new Two();
        //main.show();
        two.test();
    }

    public void show() {
        //接收数据
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
     * 这里编写一个字典树
     * pass-test
     */
    class Tree {
        //这是树根的子节点,注意，这里的a是从来都不会用的
        Node root = new Node(null);

        /**
         * 检查前缀库中是否有这个单词的前缀
         */
        public boolean checkPrefix(String str) {
            Node node = root;
            for (int i = 0; i < str.length(); i++) {
                Character a = str.charAt(i);
                Node son = node.getSon(str.charAt(i));
                if (son != null) {
                    //说明这个字母可以找到
                    node = son;
                } else {
                    //说明有这个字母没有找到，则查看node是否没有子节点，
                    // 如果没有子节点，则前缀结束，存在匹配的前缀，返回true
                    // 如果有子节点，说明前缀不匹配，返回false
                    if (node.a == null && node.sons.size() == 0) {
                        //说明已经到前缀库中的一个单词的末尾了
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
                    //添加这个字母，然后指向这个节点，继续迭代
                    Node tempNode = new Node(a);
                    node.addSon(tempNode);
                    node = tempNode;
                }
            }
            //最后给这个单词末尾添加一个空节点，作为叶子节点
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
             * 打印二叉树
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
                    //两个队列互换
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
                        //说明重复，不再添加
                        return false;
                    }
                }

                this.sons.add(node);
                node.parent = this;
                return true;
            }

            /**
             * 如果有，则返回这个节点，如果没有则返回null
             *
             * @param a
             * @return
             */
            Node getSon(Character a) {
                for (Node temp : sons) {
                    if (temp.a.equals(a)) {
                        //说明存在
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
