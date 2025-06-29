import java.time.LocalDate;

public class Day {

    private String dayOfTheWeek;
    private Integer dayOfTheMonth;
    private boolean isToday;
    private Integer year;
    private String month;
    private Integer century;

    public Day(String month, Integer year, Integer dayOfTheMonth, Integer century){
        this.month = month;
        this.year = year;

        this.dayOfTheMonth = dayOfTheMonth;
        this.dayOfTheWeek = calculateDayOfTheWeek();
        this.isToday = calculateIsToday();
    }

    public Integer getCentury() {
        return century;
    }

    public Integer getDayOfTheMonth() {
        return dayOfTheMonth;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public boolean isToday() {
        return isToday;
    }

    public String getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    private boolean calculateIsToday(){
        LocalDate date = LocalDate.now();

        int[] dateInTable = getDateInTable(date);

        if(year == dateInTable[0]){
            if(getNumberFromMonth(month) == dateInTable[1]){
                if(dayOfTheMonth == dateInTable[2]){
                    return true;
                }
            }
        }
        return false;
    }

    private int[] getDateInTable(LocalDate date){
        return new int[] {date.getYear(), date.getMonthValue(), date.getDayOfMonth()};
    }

    private String calculateDayOfTheWeek(){
        int d = dayOfTheMonth;
        int m = getNumberFromMonth(month);
        int y = year;

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int K = y % 100;
        int J = y / 100;

        int h = (d + (13*(m + 1))/5 + K + K/4 + J/4 + 5*J) % 7;

        switch (h){
            case 2:{
                return "Mon";
            }

            case 3:{
                return "Tue";
            }

            case 4:{
                return "Wed";
            }

            case 5:{
                return "Thu";
            }

            case 6:{
                return "Fri";
            }

            case 0:{
                return "Sat";
            }

            case 1:{
                return "Sun";
            }
        }
        return null;
    }

    private int getNumberFromMonth(String month){
        switch (month){
            case "January":{
                return 1;
            }

            case "February":{
                return 2;
            }

            case "March":{
                return 3;
            }

            case "April":{
                return 4;
            }

            case "May":{
                return 5;
            }

            case "June":{
                return 6;
            }

            case "July":{
                return 7;
            }

            case "August":{
                return 8;
            }

            case "September": {
                return 9;
            }

            case "October":{
                return 10;
            }

            case "November":{
                return 11;
            }

            case "December":{
                return 12;
            }
        }
        return 0;
    }
}
