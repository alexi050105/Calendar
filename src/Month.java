import java.util.ArrayList;

public class Month {

    private String name;

    private Integer numberOfDays;

    private ArrayList<Day[]> daysInWeeks;

    public Month(String name, Integer year) throws InvalidMonth {
        this.name = name;

        this.numberOfDays = setNumberOfDays(year);
    }

    private Integer setNumberOfDays(Integer year) throws InvalidMonth {

        if(this.name == "Luty") return calculateForFebruary(year);

        DaysInMonths daysInMonths = new DaysInMonths();

        if(daysInMonths.getMonths31().contains(this.name)) return 31;

        if(daysInMonths.getMonths30().contains(this.name)) return 30;

        throw new InvalidMonth();
    }

    private Integer calculateForFebruary(Integer year){
        if(isLeapYear(year)){
            return 29;
        }
        return 28;
    }

    private boolean isLeapYear(Integer year){
        if(year % 4 == 0){
            if(year % 100 == 0){
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }
}
