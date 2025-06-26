import java.util.HashSet;
import java.util.Set;

public class DaysInMonths {

    private Set<String> months31 = new HashSet<>();
    private Set<String> months30 = new HashSet<>();

    public DaysInMonths(){
        months31.add("January");
        months31.add("March");
        months31.add("May");
        months31.add("July");
        months31.add("August");
        months31.add("October");
        months31.add("December");

        months30.add("April");
        months30.add("June");
        months30.add("September");
        months30.add("November");
    }

    public Set<String> getMonths30() {
        return months30;
    }

    public Set<String> getMonths31() {
        return months31;
    }
}
