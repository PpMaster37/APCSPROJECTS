package MonthsBinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchAlgorithm {
    public int searchMonths(ArrayList<String> input, String month){
        int index = 0;
        int x = 0;
        switch(month){
            case "January": x = 1;
                break;
            case "February": x=2;
                break;
            case  "March" : x=3;
                break;
            case "April" : x=4;
                break;
            case "May" : x=5;
                break;
            case "June" : x=6;
                break;
            case "July" : x=7;
                break;
            case "August" : x=8;
                break;
            case "September" : x=9;
                break;
            case "October" : x=10;
                break;
            case "November" : x=11;
                break;
            case "December" : x=12;
                break;
        }
        ArrayList<Integer> sortedData = intSort(monthToInt(input));
        index = binarySearch(sortedData, x, sortedData);
        return index;
    }
    public ArrayList<Integer> monthToInt(ArrayList<String> months){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i<months.size();i++){
            String temp = months.get(i);
            switch (temp){
                case "January": result.add(1);
                break;
                case "February": result.add(2);
                break;
                case  "March" : result.add(3);
                break;
                case "April" : result.add(4);
                break;
                case "May" : result.add(5);
                break;
                case "June" : result.add(6);
                break;
                case "July" : result.add(7);
                break;
                case "August" : result.add(8);
                break;
                case "September" : result.add(9);
                break;
                case "October" : result.add(10);
                break;
                case "November" : result.add(11);
                break;
                case "December" : result.add(12);
                break;
            }
        }
        return result;
    }
    public ArrayList<Integer> intSort(ArrayList<Integer> input){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i<input.size();i++){
            int low = input.get(i);
            for(int x = i; x<input.size();x++){
                if(input.get(x)<low){
                    int temp = low;
                    low = input.get(x);
                    input.set(x,temp);
                }
            }
            result.add(low);
        }
        return result;
    }
    public int binarySearch(ArrayList<Integer> sortedData, int x, ArrayList<Integer> setArray){
        int startPoint = sortedData.get(0);
        int endPoint = sortedData.get(sortedData.size()-1);
        int midPoint = sortedData.get((sortedData.size()-1)/2);
        if (midPoint == x) {
            return setArray.indexOf(midPoint);
        } else if (startPoint == x) {
            return setArray.indexOf(startPoint);
        } else if (endPoint == x) {
            return setArray.indexOf(endPoint);
        }
        else if (startPoint<x&&x<midPoint){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int a = 0; a<(sortedData.size())/2;a++){
                    temp.add(sortedData.get(a));
                }
                return binarySearch(temp,x, setArray);
            } else if (midPoint<x&&x<endPoint){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int a = (sortedData.size())/2; a<sortedData.size();a++){
                    temp.add(sortedData.get(a));
                }
                return binarySearch(temp,x, setArray);
            } else{
                return -1;
            }
        }
    }
