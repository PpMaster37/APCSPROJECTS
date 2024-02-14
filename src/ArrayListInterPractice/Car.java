package ArrayListInterPractice;

public class Car extends VehicleBase implements Vehicle{
    private String model;
    public Car(String brand, String model){
        super(brand);
        this.model = model;
    }
    public void start(){
        System.out.println("Starting the " + getBrand() + " "+model);
    }
    public void stop(){
        System.out.println("Stopping the " + getBrand() + " "+model);
    }
}
