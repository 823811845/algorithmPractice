package tTiao����;

import java.util.Scanner;

/**
 * C������������ע�ͣ�����ע��//�Ͷ���ע��"/* * /",���д����ͳ��ע��������ע�������ڵĲ�Ҫͳ�ƣ��Լ������п��ܳ��ֵ�ת���ַ���Ӱ�졣
 *  ����ʾ��
 *  //line comment
 *  /*block comment * /  /*block comment * /
 * int main(){
 *     char[] s="/*string * /";
 *     return 0;
 * }
 * ���ʾ����
 * 3������Ϊ�ַ����е�ע�Ͳ������ڡ���
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

        //ȥ���ַ�����
        while (code.contains("\"")) {
            //ɾ����һ���ֵ�����
            int from = code.indexOf('\"', 0);
            int to = code.indexOf('\"', from + 1);
            code = code.substring(0, from) + code.substring(to, code.length());
        }

        //�ָ����
        lines = code.split("\n");
        //���ҵ���ע��
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("//")) {
                index++;
            }

        }
        //���Ҷ���ע��
        while (code.contains("/*")) {
            //ɾ����һ���ֵ�����
            String regex = "(\\[(^\\])*\\])";
            int from = code.indexOf('\"', 0);
            int to = code.indexOf('\"', from + 1);
            code = code.substring(0, from) + code.substring(to, code.length());
            index++;
        }

        System.out.println(index);
    }
}