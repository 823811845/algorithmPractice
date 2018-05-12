package tTiao试题;

import java.util.Scanner;

/**
 * C语言中有两种注释，单行注释//和多行注释"/* * /",请编写程序统计注释数量，注意引号内的不要统计，以及引号中可能出现的转移字符的影响。
 *  输入示例
 *  //line comment
 *  /*block comment * /  /*block comment * /
 * int main(){
 *     char[] s="/*string * /";
 *     return 0;
 * }
 * 输出示例：
 * 3，（因为字符串中的注释不算在内。）
 *
 */
public class One {
    String code = "";
    int index = 0;
    String[] lines;

    public static void main(String[] args) {
        One main = new One();
        main.show();
    }

    public void show() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            code += line + "\n";
        }

        //去除字符串：
        while (code.contains("\"")) {
            //删除这一部分的内容
            int from = code.indexOf('\"', 0);
            int to = code.indexOf('\"', from + 1);
            code = code.substring(0, from) + code.substring(to, code.length());
        }

        //分割成行
        lines = code.split("\n");
        //查找单行注释
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("//")) {
                index++;
            }

        }
        //查找多行注释
        while (code.contains("/*")) {
            //删除这一部分的内容
            String regex = "(\\[(^\\])*\\])";
            int from = code.indexOf('\"', 0);
            int to = code.indexOf('\"', from + 1);
            code = code.substring(0, from) + code.substring(to, code.length());
            index++;
        }

        System.out.println(index);
    }
}