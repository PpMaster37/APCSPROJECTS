package Final.Logic;

public interface Card {
    void use(int amount, int pin);
    void changePin(int p, int n);
    boolean checkPin(int p);
    String getType();
    String getName();
}
