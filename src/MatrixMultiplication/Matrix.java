package MatrixMultiplication;

public class Matrix {
    private static int sum;
    private static int[][] array;


    public static void MatrixMult(int[][] a, int[][] b){
        int columOne = a[0].length;
        int columTwo = b[0].length;
        int rowOne = a.length;
        int rowTwo = b.length;
        int[][] finalArray = new int[rowOne][columTwo];
        for(int rowOneAdvance = 0; rowOneAdvance<rowOne;rowOneAdvance++){
            for(int columTwoAdvance = 0; columTwoAdvance<columTwo;columTwoAdvance++){
                sum=0;
                for(int adv = 0;adv<rowTwo;adv++){
                    sum+=a[rowOneAdvance][adv]*b[adv][columTwoAdvance];
                }
                finalArray[rowOneAdvance][columTwoAdvance]= sum;
            }
        }
        array = finalArray;
    }
    public static void getArray(){
        for(int x = 0;x<array.length;x++){
            for(int y = 0; y < array[x].length;y++){
                System.out.println(array[x][y]);
            }
        }
    }

}
