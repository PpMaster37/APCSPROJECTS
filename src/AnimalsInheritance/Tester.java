package AnimalsInheritance;

public class Tester {
    public static void main(String[] args){
        Fox pet = new Fox("fox", 4);
        pet.displayInfo();
        pet.giveName("Zesty EagleClaw 100");
        pet.walk();
        pet.action();
        pet.makeSound();
        System.out.println(pet.toString());
    }
}
