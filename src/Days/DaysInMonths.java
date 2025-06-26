package Days;

import java.util.Set;

public class DaysInMonths {

    private static final Set<String> months31 = Set.of("January", "March", "May", "July", "August", "October", "December");
    private static final Set<String> months30 = Set.of("April", "June", "September", "November");

    public static boolean is30(String month) {
        return months30.contains(month);
    }

    public static boolean is31(String month) {
        return months31.contains(month);
    }

}
