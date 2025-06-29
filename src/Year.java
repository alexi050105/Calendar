public class Year {

    private Month[] months;
    private Integer number;
    private boolean isLeapYear;
    private Integer century;


    public Year(int number){
        this.number = validYear(number);
        this.isLeapYear = isLeap(this.number);
        this.century = calculateCentury(number);
        fillMonths();
    }

    private int validYear(int year){
        if (year >= 0){
            return year;
        }
        return java.time.Year.now().getValue();
    }

    private boolean isLeap(int year){
        if(year % 4 == 0){
            if(year % 100 == 0){
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    private int calculateCentury(int year){
        int century = 0;
        while (year > 0){
            year -= 100;
            century++;
        }
        return century;
    }

    public Integer getCentury() {
        return century;
    }

    public boolean isLeapYear() {
        return isLeapYear;
    }

    public Month[] getMonths() {
        return months;
    }

    public Integer getNumber() {
        return number;
    }

    private void fillMonths(){
        this.months = new Month[12];

        this.months[0] = new Month("January", isLeapYear, number, century);
        this.months[1] = new Month("February", isLeapYear, number, century);
        this.months[2] = new Month("March", isLeapYear, number, century);
        this.months[3] = new Month("April", isLeapYear, number, century);
        this.months[4] = new Month("May", isLeapYear, number, century);
        this.months[5] = new Month("June", isLeapYear, number, century);
        this.months[6] = new Month("July", isLeapYear, number, century);
        this.months[7] = new Month("August", isLeapYear, number, century);
        this.months[8] = new Month("September", isLeapYear, number, century);
        this.months[9] = new Month("October", isLeapYear, number, century);
        this.months[10] = new Month("November", isLeapYear, number, century);
        this.months[11] = new Month("December", isLeapYear, number, century);
    }
}
