package ClassPractice;

public class MyProgram {
    public static String run(){
        String[] arr = {"a","2","dafd","742","-27","327","ajkd"};
        MyDataFile df = new MyDataFile(arr);
        return df.check();
    }
}
