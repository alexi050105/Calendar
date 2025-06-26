package Months;

import Days.*;

import java.util.ArrayList;

public class Month {

    private String name;

    private Integer numberOfDays;

    private ArrayList<Week> weeksInMonth;

    public Month(String name, Integer year) throws InvalidMonth {
        this.name = name;

        this.numberOfDays = setNumberOfDays(year);
    }

    private Integer setNumberOfDays(Integer year) throws InvalidMonth {

        if(this.name.equals("February")) return calculateForFebruary(year);

        if(DaysInMonths.is31(this.name)) return 31;

        if(DaysInMonths.is30(this.name)) return 30;

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
