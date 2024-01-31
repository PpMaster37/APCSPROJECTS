package DataLab;

public class Cereal {
    private String name;
    private int calories;
    private char type;
    private int protein;
    private int fat;
    private int sodium;
    private int fiber;
    private int carb;
    private int sugar;
    private int potassium;
    private int vitamins;
    private int shelf;
    private double weight;
    private double cups;
    private double rating;
    public Cereal(String a,char b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, double m, double n, double o){
        a = name;
        b = type;
        c = calories;
        d = protein;
        e = fat;
        f = sodium;
        g = fiber;
        h = carb;
        i = sugar;
        j = potassium;
        k = vitamins;
        l = shelf;
        m = weight;
        n = cups;
        o = rating;
    }
    public String toString(){
        return name;
    }
}
