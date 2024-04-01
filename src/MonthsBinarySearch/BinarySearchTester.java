package MonthsBinarySearch;

import java.util.ArrayList;

public class BinarySearchTester {
    public static void main(String[] args){
        SearchAlgorithm searcher = new SearchAlgorithm();
        ArrayList<String> months = new ArrayList<>();
        months.add("January");
        months.add("July");
        months.add("December");
        months.add("April");
        months.add("November");
        months.add("August");
        months.add("October");
        months.add("May");
        months.add("June");
        months.add("September");
        months.add("February");
        months.add("March");
        System.out.println(searcher.binarySearch(searcher.sortMonths(months),"February"));
    }
}
