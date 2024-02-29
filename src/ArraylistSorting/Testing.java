//David Tsang
package ArraylistSorting;

import java.util.ArrayList;
import java.util.Random;

public class Testing {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> x = new ArrayList<>();
        for(int i = 0; i<10;i++) {
            x.add(r.nextInt(100));
        }
        x = InSort.insertionSort(x);
        System.out.println("Insertion Sort");
        for (int i = 0;i<x.size();i++){
            System.out.println(x.get(i));
        }
        System.out.println("\n");
        System.out.println("Selection Sort");
        ArrayList<Integer> y = new ArrayList<>();
        for(int i = 0; i<10;i++) {
            y.add(r.nextInt(100));
        }
        y = SelSort.selectionSort(y);
        for (int i = 0;i<x.size();i++){
            System.out.println(y.get(i));
        }
    }
}
