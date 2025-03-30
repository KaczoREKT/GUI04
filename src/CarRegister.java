import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String message) {
        super(message);
    }
}

class IllegalFormatException extends RuntimeException {
    public IllegalFormatException(String message) {
        super(message);
    }
}

public class CarRegister {
    private static final Set<String> usedIdentifiers = new HashSet<>(); // Przechowuje unikalne identyfikatory w programie
    private final String identifier;
    private final Map<String, Car> registry = new HashMap<>(); // Mapa numerów rejestracyjnych do obiektów Car

    public CarRegister(String identifier) {
        if (usedIdentifiers.contains(identifier)) {
            throw new IllegalArgumentException("Identyfikator " + identifier + " już istnieje.");
        }

        if (!identifier.matches("^[A-NP-Z]{2,3}$")) {
            throw new IllegalFormatException("Identyfikator powinien zawierać 2 lub 3 litery (bez 'O').");
        }

        this.identifier = identifier;
        usedIdentifiers.add(identifier);
    }

    public void registerCar(Car car, String plateNumber) {
        if (registry.containsKey(plateNumber)) {
            throw new IllegalArgumentException("Tablica rejestracyjna " + plateNumber + " już istnieje.");
        }

        if (!plateNumber.matches(identifier + " [A-NP-Z0-9]{4,5}")) {
            throw new IllegalFormatException("Numer rejestracyjny nie spełnia wymaganego formatu.");
        }

        registry.put(plateNumber, car);
    }

    public Car getCar(String plateNumber) {
        return registry.get(plateNumber);
    }

    public void unregisterCar(String plateNumber) {
        registry.remove(plateNumber);
    }

    public Map<String, Car> listRegisteredCars() {
        return new HashMap<>(registry);
    }
}