
/**
 * This class represents a Date Object.
 * @author (Tova Noyman).
 * @version 03/12/24 (2025a).
 */
public class Date 
{
    private int _day;
    private int  _month;
    private int _year;
    private static final int JANUARY = 1;
    private static final int FEBUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTENMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVENBER = 11;
    private static final int DECENBER = 12;
    private static final int DAYS_IN_JANUARY_MARCH_MAY_JULY_AUGUST_OCTOBER_DECENBER = 31;
    private static final int DAYS_IN_FEBRUARY = 28;
    private static final int DAYS_IN_LEAP_FEBRUARY = 29;
    private static final int DAYS_IN_MARCH_APRIL_JUNE_SEPTEMBER_NOVEMBER = 30;
    private static final int MAX_YEAR = 9999;
    private static final int MIN_YEAR =1000;
    private static final int NIN_DAY = 1;
    private static final int DEFAULT_DAY =01;
    private static final int DEFAULT_MONTH =01;
    private static final int DEFAULT_YEAR =2024;
    private static final int TWO_DIGIT_NUM = 10;
    //constructors:
    /**
     * Date constructor - If the given date is valid - creates a new Date object, otherwise creates the date 01/01/2024.
     * @param day - the day in the month (1-31).
     * @param month - the month in the year (1-12).
     * @param year - the year (4 digits).
     */
    public Date(int day, int month, int year) 
    {
        if(!isRealDate(day, month, year))
        {
            _day = 01;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
        else 
        {
            _day = day;
            _month = month;
            _year = year;
        }
    }

    /**
     * Default constructor.
     */
    public Date() 
    {
        _day = 01;
        _month = DEFAULT_MONTH;
        _year = DEFAULT_YEAR;
    }

    /**
     * Copy Constructor.
     * @param other - the date to be copied.
     */
    public Date(Date other)
    {
        _day = other._day;
        _month = other._month;
        _year = other._year;

    }

    /** 
     * Gets the year.
     * @return the year of this date.
     */ 
    public int getYear()
    {
        return _year;
    }

    /** 
     * Gets the month. 
     * @return the month of this date.
     */
    public int getMonth()
    {
        return _month;
    }

    /** 
     * Gets the Day.
     * @return the day of this date.
     */ 
    public int getDay()
    {
        return _day;
    }

    /** 
     * Sets the year (only if date remains valid).
     * @param yearToSet - the new year value. 
     */
    public void setYear(int yearToSet)
    {
        int priveseYaer= _year;
        if(isRealDate(_day, _month, yearToSet))
            _year = yearToSet;
    }

    /** 
     * Sets the month (only if date remains valid).
     * @param monthToSet - the new month value. 
     */
    public void setMonth(int monthToSet)
    {
        int priveseMonth= _month;
        if(isRealDate(_day, monthToSet, _year))
            _month = monthToSet;
    }

    /** 
     * Sets the day (only if date remains valid). 
     *  @param dayToSet - the new day value.
     */
    public void  setDay(int dayToSet)
    {
        int priveseDay= _day;
        if(isRealDate(dayToSet, _month, _year ))
            _day =  dayToSet;
    }

    /** 
     * Checks if two dates are the same.
     * @param other - the date to compare this date to. 
     * @return true if the dates are the same.
     */
    public boolean equals(Date other)
    {
        if(_day == other._day && _month == other._month && _year == other._year)
            return true;
        return false;
    }

    /** 
     * Checks if this date comes before another date.
     * @param other - date to compare this date to. 
     * @return true if this date is before the other date.
     */
    public boolean before (Date other)
    {
        return calculateDate( _day, _month, _year) < calculateDate( other._day, other._month, other._year); 
    }

    /** 
     * Checks if this date comes after another date.
     * @param other - date to compare this date to.
     * @return true if this date is after the other date.
     */
    public boolean after (Date other)
    {
        return other.before(this);
    }

    /** 
     * calculates the difference in days between two dates.
     * @param other - the date to calculate the difference between.
     * @return the number of days between the dates (non negative value).
     */
    public int difference (Date other)
    {
        return Math.abs(calculateDate( _day, _month, _year) - calculateDate( other._day, other._month, other._year));
    }

    /**
     * Returns a String that represents this date.
     * @return a String that represents this date in the following format: day (2 digits) / month(2 digits) / year (4 digits) for example: 02/03/1998.
     */
    public String toString() 
    {
        String day ="" + _day;
        String month ="" + _month;
        if(_day < TWO_DIGIT_NUM) // case _day is one digit number.
            day = "0" +_day;
        if(_month < TWO_DIGIT_NUM) // case _month is one digit number.
            month = "0" +_month;
        return day +"/" + month + "/" + _year;
    }

    /**
     * Calculate the date of tomorrow.
     * @param the date of tomorrow.
     */
    public Date tomorrow()
    {
        Date d;
        if( isRealDate( _day+1, _month, _year)) // case _day is'nt the last day in the month.
            d =new Date( _day+1, _month, _year);
        else if(isRealDate( NIN_DAY, _month+1, _year)) // case _day is the last day in the month and _month is'nt the last month in the year.
            d =new Date( NIN_DAY, _month+1, _year);
        else // case _day is the last day in the month and _month is the last day in the year.
            d =new Date( NIN_DAY, NIN_DAY, _year+1);
        return d;
    }
    // checks if the values of the given date is repesent un exisiting date. 
    
    private boolean isRealDate(int day, int month, int year)
    {
        int maxDay = 31;
        if(year > MAX_YEAR || year < MIN_YEAR || day < NIN_DAY || month < 1 || month > 12) // case yaer or month or day are'nt real.
            return false;
        switch(month)
        {
            case JANUARY: case MARCH: case MAY: case JULY: 
            case AUGUST: case OCTOBER: case DECENBER: 
                maxDay = DAYS_IN_JANUARY_MARCH_MAY_JULY_AUGUST_OCTOBER_DECENBER;
                break;
            case FEBUARY:
                if(isLeapYear(year)) // case day is'nt real day depend on the month and if laep yaer.
                    maxDay = DAYS_IN_LEAP_FEBRUARY ;
                else 
                    maxDay = DAYS_IN_FEBRUARY;   
                break;
            case APRIL: case JUNE:
            case SEPTENMBER: case NOVENBER:
               maxDay = DAYS_IN_MARCH_APRIL_JUNE_SEPTEMBER_NOVEMBER; // case day is'nt real day depend on the month.   
                break;
        }
        return day <= maxDay;
    }

    // computes the day number since the beginning of the Christian counting of years
    private int calculateDate ( int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }
    // checks if the year is a leap year
    private boolean isLeapYear (int y)
    {
        return (y%4==0 && y%100!=0) || (y%400==0) ? true : false;
    }
}