//DAVID TSANG
package ArraylistSorting;

import java.util.ArrayList;

public class InSort {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> b){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(b.get(0));
        if(b.get(1)>b.get(0)){
            result.add(b.get(1));
        } else{
            result.add(0,b.get(1));
        }
        for(int i = 2;i<b.size();i++){
            int temp = b.get(i);
            for(int x = 0;x<result.size();x++){
                if(temp>result.get(x)&&temp<result.get(x+1)){
                    result.add(x+1,temp);
                    x = result.size();
                } else if(temp<result.get(0)){
                    result.add(0,temp);
                    x = result.size();
                } else if (temp>result.get(result.size()-1)){
                    result.add(temp);
                    x = result.size();
                }
            }
        }
        return result;
    }
}
