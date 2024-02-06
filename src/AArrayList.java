import java.util.ArrayList;
public class AArrayList {
    ArrayList<Integer> numbers;
    public AArrayList(){
        numbers = new ArrayList<Integer>();
    }
    public void input(int x){
        numbers.add(x);
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
}
