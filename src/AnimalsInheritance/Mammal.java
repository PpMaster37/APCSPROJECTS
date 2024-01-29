package AnimalsInheritance;

public class Mammal extends Animal{
    protected int numberOfLegs;
    public Mammal(String species,int legs){
        super(species);
        numberOfLegs = legs;
    }
    public void walk() {
        System.out.println("The "+species+" walks on "+numberOfLegs+" legs");
    }
    public void makeSound(){
        System.out.println("The "+species+" makes a sound");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
