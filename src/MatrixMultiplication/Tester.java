package MatrixMultiplication;

public class Tester {
    public static void main(String[] args){
        int[][] arrayOne = {{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        int[][] arrayTwo = {{1,1},{1,1},{1,1},{1,1}};
        Matrix.MatrixMult(arrayOne,arrayTwo);
        Matrix.getArray();
    }
}
