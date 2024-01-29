package ClassPractice;

public class MyDataFile {
    private String[] arr;
    public MyDataFile(){

    }
    public MyDataFile(String[] aray){
        arr = aray;
    }
    public String check(){
        int len = arr.length;
        boolean bl;
        String s = "";
        MyFormatting mf = new MyFormatting();
        for (int x = 0; x<len; x++){
            bl = mf.isitaNumber(arr[x]);
            s = s + bl;
        }
        return s;
    }
}
