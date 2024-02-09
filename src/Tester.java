import java.util.*;
public class Tester {
    public static void main(String[] args) {
        MyArrayList A = new MyArrayList();
        Random ran = new Random();
        for(int x = 0; x<=20;x++){
            A.input(ran.nextInt(99));
        }
        System.out.println(A);
        A.input(347637);
        A.precisionSet(3,3663);
        System.out.println(A.getBack(4));
        A.erase(16);
        System.out.println(A.length());
        System.out.println(A);
    }
}