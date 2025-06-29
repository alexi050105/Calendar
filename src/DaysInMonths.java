import java.util.Set;

public class DaysInMonths {

    static final Set<String> days30 = Set.of("April", "June", "September", "November");
    static final Set<String> days31 = Set.of("January", "March", "May", "July", "August", "October", "December");

    public static boolean isIn30(String name){
        return days30.contains(name);
    }

    public static boolean isIn31(String name){
        return days31.contains(name);
    }
}
