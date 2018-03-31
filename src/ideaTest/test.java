package ideaTest;


import java.util.Stack;

public class test extends Thread implements Runnable{
    void show(){
        Stack<test> show=new Stack<>();
        show.lastElement();
    }
    public static void main(String[] args) {

        test te=new test();
        Thread th=new Thread(te);
        th.start();
        System.out.println(th.getState());
    }
    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            i++;
        }
        System.out.println("run");
    }
}
