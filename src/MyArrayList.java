import java.util.ArrayList;
public class MyArrayList {
    ArrayList<Integer> numbers;
    public MyArrayList(){
        numbers = new ArrayList<Integer>();
    }
    public void input(int x){
        numbers.add(x);
    }
    public void erase(int x){
        numbers.remove(x);
    }
    public int getBack(int y){
        return numbers.get(y);
    }
    public void precisionSet(int a, int b){
        numbers.set(a,b);
    }
    public int length(){
        return numbers.size();
    }
    public String toString(){
        String str = "The ArrayList has values ";
        for(int i = 0; i<length();i++){
            str += numbers.get(i)+" ";
        }
        return str;
    }
}
