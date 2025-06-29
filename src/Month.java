import java.util.Objects;

public class Month {

    private Day[] days;
    private String name;
    private Integer numberOfDays = 0;
    private Integer year;
    private Integer century;

    public Month(String name, boolean isLeapYear, Integer year, Integer century){
        this.year = year;
        this.century = century;
        this.name = validName(name, isLeapYear);
        fillDays();
    }

    private String validName(String name, boolean isLeapYear){
        if (DaysInMonths.isIn30(name)){
            numberOfDays = 30;
            return name;
        }
        if (DaysInMonths.isIn31(name)){
            numberOfDays = 31;
            return name;
        }
        if (Objects.equals(name, "February")){
            if(isLeapYear){
                numberOfDays = 29;
            } else {
                numberOfDays = 28;
            }
            return name;
        }
        numberOfDays = 31;
        return "January";
    }

    public Integer getCentury() {
        return century;
    }

    public Day[] getDays() {
        return days;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public Integer getYear() {
        return year;
    }

    private void fillDays(){
        this.days = new Day[numberOfDays];

        for(int i = 0; i < numberOfDays; i++){
            this.days[i] = new Day(name, year, i + 1, century);
        }
    }
}
