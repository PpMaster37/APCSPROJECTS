//DAVID TSANG
package ArraylistSorting;

import java.util.ArrayList;

public class SelSort {
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> a){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i<a.size();i++){
            int low = a.get(i);
            for(int x = i; x<a.size();x++){
                if(a.get(x)<low){
                    int temp = low;
                    low = a.get(x);
                    a.set(x,temp);
                }
            }
            result.add(low);
        }
        return result;
    }
}
