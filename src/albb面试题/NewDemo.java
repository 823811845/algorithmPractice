package albb面试题;

import java.util.ArrayList;

public class NewDemo {
    char[] chars;
    //这里规定二维数组的第一个数字为列号（也就是x）
    boolean[][] flag;
    String str;

    ArrayList<Integer> from = new ArrayList<>();
    ArrayList<Integer> to = new ArrayList<>();

    public static void main(String[] args) {
        NewDemo demo = new NewDemo();
        //demo.init("我都说了我要退款我要退款hhh，就是要退款");
        //demo.init("要退款要退款hhh");
        demo.init("hhh");
        demo.checkSeq();

        System.out.println(demo.from);
        System.out.println(demo.to);
        System.out.println(demo.removeSeq());
    }

    public void init(String str) {
        this.str = str;
        chars = str.toCharArray();
        //开始把字符串的比对信息放入flag中
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
                //进行检查，有没有之前的删除内容是不是在这次删除内容的左边，如果是，要把坐标位置更新
                //FIXME 上次做到这里了，
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
        //这里的规则是，遍历flag，如果存在 flag[i][j]到 flag[i+k][j+k]都等于true（这里要求i!=j，）
        //那么说明，存在重复内容，
        for (int i = 0; i < chars.length; i++) {
            //这里就直接跳过判断i=j的情况
            for (int j = i + 1; j < chars.length; j++) {
                int k = checkChar(i, j);
                //然后检查i+k是否大于等于j-1,如果等于，则说明这两个重复串是相邻的，如果大于，说明这重复串的数量可能不止是两个
                //由此进一步延伸，如果k+1和j-i作余，得到的内容，是0的话，说明，重复的内容，长度是j-i的整数倍，即存在多个相邻的重复复内容
                if (k != 0 && (k) % (j - i) == 0) {
                    //（如果有余数，则说明不是相邻的），
                    // 应该去除从j到i+k之间的多余内容
                    /**
                     * 这里暂时还不能删，因为如果删了，字符串就和flag里面的比对结果对不上了，应该先把他们储存起来
                     * return str.substring(0,j)+str.substring(j+k);
                     */
                    //这里要注意检查，看看删除的部分里，有没有重叠的内容。
                    if (checkToremove(j, j + k)) {
                        from.add(j);
                        to.add(j + k);
                    }
                }
            }
        }
    }

    public int checkChar(int i, int j) {
        //这里为了防止重复检查，可以加设一个条件
        if (i != 0 && j != 0) {
            if (flag[i - 1][j - 1] == true) {
                //说明这个地方已经被检查过了
                return 0;
            }
        }
        int k = 0;
        for (; k < flag.length - j; k++) {
            if (flag[i + k][j + k] != true)
                break;
        }
        boolean bool = true;
        //要求flag[i][j]到flag[i+k][j]不能全都等于true，
        // 因为如果等于，那就说明，这k个字符是同一个字符，与题意不符）
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
     * 进行一个检查，看看删除的部分里，有没有重叠的内容。
     */
    public boolean checkToremove(int a, int b) {
        for (int i = 0; i < from.size(); i++) {
            if (a > from.get(i) || b < to.get(i)) {
                //说明没有重叠
                continue;
            } else {
                //说明有重叠
                //FIXME 这是题目中一个没有交代清楚的地方，形如ABCABCDCD这样的内容要怎么办（"ABC"是重复的，"CD"也是重复的，但是他们中间又重叠了一个C）
                //暂时定为作废
                return false;
            }
        }
        return true;
    }
}
