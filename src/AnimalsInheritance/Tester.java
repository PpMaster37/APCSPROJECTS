package AnimalsInheritance;
//David Tsang

public class Tester {
    public static void main(String[] args){
        Fox pet = new Fox("fox", 4);
        Mammal petTwo = new Fox("fox",4);
        Animal petThree = new Fox("fox",4);
        pet.displayInfo();
        pet.giveName("Zesty EagleClaw 100");
        pet.walk();
        pet.action();
        pet.makeSound();
        petTwo.displayInfo();
        petTwo.makeSound();
        petTwo.walk();
        petThree.makeSound();
        petThree.displayInfo();
        System.out.println(pet.toString());
        System.out.println(petTwo.toString());
        System.out.println(petThree.toString());
    }
}
