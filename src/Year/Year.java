package Year;

import Months.InvalidMonth;
import Months.Month;

import java.util.Calendar;

public class Year {

    private Integer year;

    private Month[] months;

    public Year() throws InvalidMonth {
        this.year = Calendar.getInstance().get(Calendar.YEAR);

        addMonths();
    }

    private void addMonths() throws InvalidMonth {
        this.months = new Month[12];

        this.months[0] = new Month("January", this.year);
        this.months[1] = new Month("February", this.year);
        this.months[2] = new Month("March", this.year);
        this.months[3] = new Month("April", this.year);
        this.months[4] = new Month("May", this.year);
        this.months[5] = new Month("June", this.year);
        this.months[6] = new Month("July", this.year);
        this.months[7] = new Month("August", this.year);
        this.months[8] = new Month("September", this.year);
        this.months[9] = new Month("October", this.year);
        this.months[10] = new Month("November", this.year);
        this.months[11] = new Month("December", this.year);
    }
}
