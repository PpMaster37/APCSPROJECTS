package ClassPractice;

public class MyFormatting {
    private String testString;
    public MyFormatting(){

    }
    public boolean isitaNumber(String str){
        testString = str;
        try{
            double x = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }

    }
}
