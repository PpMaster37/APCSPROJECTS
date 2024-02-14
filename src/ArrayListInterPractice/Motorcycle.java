package ArrayListInterPractice;

public class Motorcycle implements Vehicle{
    private String brand;
    private String model;
    public Motorcycle(String brand, String model){
        this.brand = brand;
        this.model = model;

    }
    public void start(){
        System.out.println("Starting the "+brand+" "+model);
    }
    public  void stop(){
        System.out.println("Stopping the "+brand+" "+model);
    }
}
