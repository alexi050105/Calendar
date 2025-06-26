import java.util.Calendar;

public class Year {

    private Integer year;

    private Month[] months;

    public Year() throws InvalidMonth {
        this.year = Calendar.getInstance().get(Calendar.YEAR);

        addMonths(months);
    }

    private void addMonths(Month[] months) throws InvalidMonth {
        months = new Month[12];

        months[0] = new Month("January", this.year);
        months[1] = new Month("February", this.year);
        months[2] = new Month("March", this.year);
        months[3] = new Month("April", this.year);
        months[4] = new Month("May", this.year);
        months[5] = new Month("June", this.year);
        months[6] = new Month("July", this.year);
        months[7] = new Month("August", this.year);
        months[8] = new Month("September", this.year);
        months[9] = new Month("October", this.year);
        months[10] = new Month("November", this.year);
        months[11] = new Month("December", this.year);
    }
}
