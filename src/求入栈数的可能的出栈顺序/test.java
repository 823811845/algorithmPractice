package 求入栈数的可能的出栈顺序;

import java.util.Stack;

public class test {
public static void main(String[] args) {
	Stack<String> stack = new Stack<String>();  
    stack.add("zhangsan");  
    stack.add("lisi");  
    stack.add("wangwu");  
    stack.add("qianliu");  
    stack.add("zhaoda");  
    int index = stack.search("qianliu");// 寻找对象位置  
    int index1 = stack.search("zhaoda");// 寻找对象位置  
    System.out.println("位置为:"+index+":"+index1);  
    stack.add(3, "孙二娘");  
      
    String first=stack.firstElement();  
    System.out.println("first="+first);  
    stack.push("王五");  
    System.out.println("top="+stack.lastElement());  
}
}
