package MonthsBinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchAlgorithm {
    public int binarySearch(ArrayList<String> input, String search){
        int mid = input.size()/2;
        int low = 0;
        int high = input.size()-1;
        while(high>=low){
            if(input.get(mid).compareTo(search)==0){
                return mid;
            }
            if(input.get(mid).compareTo(search)<0){
                low = mid + 1;
                int temp = high + low;
                mid = temp / 2;
            } else {
                high = mid - 1;
                int temp = high + low;
                mid = temp / 2;
            }
        }
        return -1;
    }
    public ArrayList<String> sortMonths(ArrayList<String> input){
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i<input.size();i++){
            String low = input.get(i);
            for(int x = i; x<input.size();x++){
                if(input.get(x).compareTo(low)<0){
                    String temp = low;
                    low = input.get(x);
                    input.set(x,temp);
                }
            }
            result.add(low);
        }
        return result;
    }
}
