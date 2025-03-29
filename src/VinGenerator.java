import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VinGenerator {
    private static final Set<String> globalVins = new HashSet<>();
    private static final Random random = new Random();

    public static String vinGenerator() {
        String vin = IntStream.range(0, 17)
                .mapToObj(i -> random.nextBoolean()
                        ? String.valueOf(random.nextInt(10)) // 0-9
                        : String.valueOf((char) (random.nextInt(26) + 65))) // A-Z
                .collect(Collectors.joining());

        if (!globalVins.add(vin)) {
            return vinGenerator();
        }
        return vin;
    }
    public static void main (String[]args){
        System.out.println("Wygenerowany VIN: " + vinGenerator());
    }
}
