package albb面试题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 在阿里巴巴的在线智能客服场景中，会出现服务转交的情况，在转交的时候，我们会进行智能摘要，但是在摘要之前要对用户说过的话进行去重处理，字符串去重的规则是：
 * 1.相邻的最大重复串需要去掉：比如说：【刚才我说了我要退款我要退款我要退款，我都说了我要退款】 去重之后：【刚才我说了我要退款，我都说了我要退款】
 * 2.重复的字数必须大于1，所以：【阿里旺旺】，不需要去重（这里有一个细节没说清楚，如果是【阿里旺旺旺旺】，重复字数等于1，但是重复次数又大于等于4的这种，要不要去重）
 * 3.数字不能进行去重，所以：【10000】，不需要去重
 */
public class 阿里巴巴模拟笔试 {
    public static void main(String[] args) {
        阿里巴巴模拟笔试 obj = new 阿里巴巴模拟笔试();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(obj.removeSeq(str));
        }
    }

    /**
     * 字符串去重函数
     * 这里的思路是，将相邻的两个首字母相同的子串进行比较，如果子串的长度大于1，而且内容完全相同，那就删除多余的子串，
     * 然后重新统计整个字符串（这一步有没有什么优化的算法？，重复这么做很麻烦）。
     */
    public String removeSeq(String str) {
        //定义一个数据结构，用来比对数据
        HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            map.put(str.charAt(i), list);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)) && map.get(str.charAt(i)).size() > 2) {
                //则有可能存在重复字符串，做处理
                //查看重复次数是否大于2，大于2的时候才需要处理
                //FIXME 你给我看清楚，题目上写的是，重复的字数必须大于1，而不是重复的次数
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
                //说明这两个字符串相同

            }
        }
        return null;
    }

    /**
     * 递归嵌套，无论字符串重复有多少次，都重新变为一次
     * FIXME 存在的问题，这里当去重过一次后，你之前的数据就不可用了，必须重新更新一下。
     *
     * @param str
     * @param list
     * @param a
     * @return
     */
    public boolean checkNeighbor(String str, LinkedList<Integer> list, int a) {
        int b = list.get(a + 1);
        if (str.substring(list.get(a), b).equals(str.substring(b, b + b - a))) {
            //进行递归验证，
            if (checkNeighbor(str, list, a + 1)) {
                //说明这两个字符串相同

            }
            return true;
        }
        return false;
    }

    /**
     * 这个是备用的，
     * 第一次做的时候题目给看错了，“重复的字数大于1，进行去重”，看成了“把重复的大于1次时，做去重”
     * 这部分错误的就不删了，作为这道题的延伸内容吧
     */
    class Alternate {
        public void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            while (scan.hasNext()) {
                String str = scan.nextLine();
                System.out.println(removeSeq(str));
            }
        }

        //字符串去重函数
        public String removeSeq(String str) {
            //定义一个数据结构，用来比对数据
            HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(str.charAt(i), list);
            }

            for (int i = 0; i < str.length(); i++) {
                if (map.containsKey(str.charAt(i)) && map.get(str.charAt(i)).size() > 2) {
                    //则有可能存在重复字符串，做处理
                    //查看重复次数是否大于2，大于2的时候才需要处理
                    //FIXME 你给我看清楚，题目上写的是，重复的字数必须大于1，而不是重复的次数
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
                    //说明这两个字符串相同

                }
            }
            return null;
        }

        /**
         * 递归嵌套，无论字符串重复有多少次，都重新变为一次
         * FIXME 存在的问题，这里当去重过一次后，你之前的数据就不可用了，必须重新更新一下。
         *
         * @param str
         * @param list
         * @param a
         * @return
         */
        public boolean checkNeighbor(String str, LinkedList<Integer> list, int a) {
            int b = list.get(a + 1);
            if (str.substring(list.get(a), b).equals(str.substring(b, b + b - a))) {
                //进行递归验证，
                if (checkNeighbor(str, list, a + 1)) {
                    //说明这两个字符串相同

                }
                return true;
            }
            return false;
        }
    }
}