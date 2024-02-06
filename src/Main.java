import java.util.*;
public class Main {
    public static void main(String[] args) {
        AArrayList pp = new AArrayList();
        Random x = new Random();
        pp.input(324);
        System.out.println(pp.getBack(0));
        pp.precisionSet(0,247183);
        System.out.println(pp.getBack(0));
        pp.input(247);
        pp.input(8278);
        System.out.println(pp.length());
        pp.input(x.nextInt(3842));
        System.out.println(pp.getBack(3));
        for(int i = 0;i<10;i++){
            pp.input(x.nextInt(3842));
        }
        for (int k:pp.numbers){
            System.out.println(pp.getBack(k));
        }
    }
}