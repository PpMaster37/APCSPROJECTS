package ArraylistSorting;

import java.util.ArrayList;

public class QuickSort {
    public static ArrayList<Integer> quickSort(ArrayList<Integer> x) {
        ArrayList<Integer> result = new ArrayList<>();
        if (x.size()>2) {
            int iCount = 0;
            int pivot = x.get(x.size()-1);
            boolean isOk = false;
            for(int a = 0; a<x.size();a++){
                int check = x.get(a);
                if(check<pivot){
                    isOk = true;
                }
            }
            if(!isOk){
                pivot = x.get(0);
            }
            for (int a = 0; a < x.size(); a++) {
                int i = x.get(iCount);
                int j = x.get(a);
                if(j<pivot){
                    int temp = i;
                    x.set(iCount,j);
                    x.set(a,temp);
                    iCount++;
                }
            }
            int temp = x.get(x.size()-1);
            x.set(x.size()-1,x.get(iCount));
            x.set(iCount,temp);
            ArrayList<Integer> small = new ArrayList<>();
            for(int i = 0; i<iCount;i++){
                small.add(x.get(i));
            }
            ArrayList<Integer> large = new ArrayList<>();
            for (int i = iCount; i<x.size();i++){
                large.add(x.get(i));
            }
            for (int i = 0; i<quickSort(small).size()-1;i++){
                result.add(quickSort(small).get(i));
            }
            for (int i = 0;i<quickSort(large).size();i++){
                result.add(quickSort(large).get(i));
            }
            return result;
        } else if (x.size() == 2){
            if(x.get(1)<x.get(0)){
                int temp = x.get(1);
                x.set(1,x.get(0));
                x.set(0,temp);
                return x;
            }
            else{
                return x;
            }
        } else {
            return x;
        }
    }
}
