package AnimalsInheritance;
//David Tsang
public class Animal {
    protected String species;
    public Animal(String spec){
        species = spec;
    }

    public void makeSound(){

    }

    public void displayInfo(){
        System.out.println(species);
    }

    @Override
    public String toString() {
        return species;
    }
}
