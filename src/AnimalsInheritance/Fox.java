package AnimalsInheritance;
//David Tsang
public class Fox extends Mammal{
    private String breed;
    private String name;
    public Fox(String species, int legs){
        super(species,legs);
    }
    public void giveName(String n){
        name = n;
    }
    public void action() {
        System.out.println("The "+species+" eats food");
    }
    public void makeSound(){
        System.out.println("Ring-ding-ding-ding-dingeringeding" +
                "Gering-ding-ding-ding-dingeringeding" +"Wa-pa-pa-pa-pa-pa-pow" +
                "Wa-pa-pa-pa-pa-pa-pow"+"Hatee-hatee-hatee-ho" +
                "Hatee-hatee-hatee-ho" + "Joff-tchoff-tchoffo-tchoffo-tchoff" +
                "Tchoff-tchoff-tchoffo-tchoffo-tchoff" + "Jacha-chacha-chacha-chow" +
                "Chacha-chacha-chacha-chow"+"Fraka-kaka-kaka-kaka-kow" +
                "Fraka-kaka-kaka-kaka-kow"+ "A-oo-oo-oo-ooo" +
                "Woo-oo-oo-ooo");
    }

    @Override
    public String toString() {
        return name;
    }
}
