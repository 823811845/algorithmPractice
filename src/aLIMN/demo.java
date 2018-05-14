package aLIMN;

public class demo {
    public static void main(String[] args) {
        demo d=new demo();
        int index=0;
        for (int i = 100000000; i <999999999 ; i++) {
            if(d.show(i)){
                index++;
                System.out.println(i);
            }
        }
        System.out.println("indexΪ"+ index);
    }

    boolean show(int a) {
        int b = a % 10000;
        int c = a / 100000;
        int d = b + c * 10000;
        if (a% d == 0) {
            return true;
        }
        return false;
    }
}
