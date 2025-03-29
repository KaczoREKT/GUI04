import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mechanic {
    private HashMap<Car, Integer> repairedCars = new HashMap<>();
    private String name;

    public void repairCar(Car car){
        if (!repairedCars.containsKey(car)) {
            repairedCars.put(car, 1);
        } else {
            repairedCars.put(car, repairedCars.get(car) + 1);
        }

    }
    public boolean wasRepaired(Car car){
        return repairedCars.containsKey(car);
    }

    public int repairesCount(Car car){
        return repairedCars.get(car);
    }
}
