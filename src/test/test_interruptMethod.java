package test;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class test_interruptMethod extends AbstractSequentialList {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    System.out.println("1");
//                    try {
                    //sleep��һ����̬������thread���ã��͵�ͬ��Thread����
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

            }

        });
        thread.start();


        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        thread.sleep(10);
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
