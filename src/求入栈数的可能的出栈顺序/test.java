package ����ջ���Ŀ��ܵĳ�ջ˳��;

import java.util.Stack;

public class test {
public static void main(String[] args) {
	Stack<String> stack = new Stack<String>();  
    stack.add("zhangsan");  
    stack.add("lisi");  
    stack.add("wangwu");  
    stack.add("qianliu");  
    stack.add("zhaoda");  
    int index = stack.search("qianliu");// Ѱ�Ҷ���λ��  
    int index1 = stack.search("zhaoda");// Ѱ�Ҷ���λ��  
    System.out.println("λ��Ϊ:"+index+":"+index1);  
    stack.add(3, "�����");  
      
    String first=stack.firstElement();  
    System.out.println("first="+first);  
    stack.push("����");  
    System.out.println("top="+stack.lastElement());  
}
}
