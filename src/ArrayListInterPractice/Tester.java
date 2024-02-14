package ArrayListInterPractice;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args){
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car("Tesla","Cybertruck"));
        vehicleList.add(new Motorcycle("Kawasaki","Z9000"));
        vehicleList.add(new Car("Arcsaber","11 Tour"));
        vehicleList.add(new Motorcycle("Nanoflare",("1000z")));
        for (int i = 0; i<vehicleList.size();i++){
            VehicleReporter.reportVehicle(vehicleList.get(i));
        }
    }
}
