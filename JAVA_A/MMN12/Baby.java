
/**
 * This class represents a Baby Object.
 * @author (Tova Noyman).
 * @version (15/12/24).
 */
public class Baby
{
    // instance variables - replace the example below with your own
    private String _firstName;
    private String _lastName;
    private String _id;
    private Date _dateOfBirth;
    private Weight _birthWeight;
    private Weight _currentWeight;
    private static final int DEFUALT_ID_DIGIT = 9;
    private static final int MAX_NUM_DAY = 365;
    private static final int MIN_NUM_DAY = 0;
    //constructors:
    /**
     * Baby constructor - If the given id and birthWeightInGrams are valid - creates a new Baby object with the parameters, otherwise, if the id is not calid creates the Baby with id = "000000000" and all other parameters. if the weight of the baby at birth is not 1KG and above it willset it to 1KG.
     * @param the first name of the baby.
     * @param the last name of the baby..
     * @param the id of the baby (9 characters).
     * @param the day of the baby's birth.
     * @param the month of the baby's birth.
     * @param the year of the baby's birth.
     * @param the weight of the baby at birth in grams (should be minimum 1KG).
     */
    public Baby(String fName, String lName, String id, int day, int month, int year, int birthWeightInGrams)
    {
        if( fName.charAt(0) > 90) // case first name came with small first letter.
            fName = fName.toUpperCase().substring(0,1) +fName.substring(1);
        if( lName.charAt(0) > 90)// case last name came with small first letter.
            lName = lName.toUpperCase().substring(0,1) +lName.substring(1);
        _firstName = fName;
        _lastName = lName;
        if(id.length() != DEFUALT_ID_DIGIT ) // case id is'nt in the right length.
            _id = "000000000";
        else 
            _id = id;
        _dateOfBirth = new Date( day, month, year);
        _birthWeight = new Weight(birthWeightInGrams);
        _currentWeight = new Weight(_birthWeight); 
    }

    /**
     *copy constructor.
     *@param the baby to be copied.
     */
    public Baby(Baby other)
    {
        _firstName = other._firstName;
        _lastName = other._lastName;
        _id = other._id;
        _dateOfBirth = new Date(other._dateOfBirth);
        _birthWeight = new Weight(other._birthWeight);
        _currentWeight = new Weight(other._currentWeight); 
    }

    /**
     * Gets the first name.
     * @return the first name of this baby.
     */
    public String getFirstName()
    {
        return _firstName;
    }

    /**
     * Gets the last name.
     * @return the last name of this baby. 
     */
    public String getLastName()
    {
        return _lastName;
    }

    /**
     * Gets the id.
     * @return the id of this baby.
     */
    public String getId()
    {
        return _id;
    }

    /**
     * Gets the date of birth.
     *@return the date of birth of this baby.
     */
    public Date getDateOfBirth()
    {
        Date d = new Date(_dateOfBirth);
        return d;
    }

    /**
     *Gets the birth weight.
     *@return the weight of this baby at birth.
     */
    public Weight getBirthWeight()
    {
        Weight w = new Weight(_birthWeight);
        return w;
    }

    /**
     * Gets the current weight.
     * @return the current weight of this baby.
     */
    public Weight getCurrentWeight()
    {
        Weight w = new Weight(_currentWeight);
        return w;
    }

    /**
     * Sets the current weight if the given parameter is valid.
     * @param weightToSet - the new current weight.
     */
    public void setCurrentWeight(Weight weightToSet)
    {
        _currentWeight = new Weight(weightToSet);
    }

    /**
     * Returns a String that represents this baby.
     * @return a String that represents this baby.
     */
    public String toString()
    {
        return ( "Name: " + _firstName + " " + _lastName + "\n" + "Id: " + _id + "\n" + "Date of Birth: " + _dateOfBirth + "\n" + "Birth Weight: " + _birthWeight + "\n" + "Current Weight: " + _currentWeight + "\n");
    }

    /**
     * Checks if two babies are the same. Two babies are consider the same if they have the same first and last name, same ID and similar date of birth.
     * @param other - the baby to compare this baby with.
     * @return true if the babies are the same.
     */
    public boolean equals (Baby other)
    {
        if(!_firstName.equals(other._firstName)) // case their names are diference.
            return false;
        if(!_lastName.equals(other._lastName)) // case their last names are diference.
            return false;
        if(!_id.equals(other._id)) // case their ids are diference.
            return false;
        if(!_dateOfBirth.equals(other._dateOfBirth)) // case their birth date are diference.
            return false;
        return true;
    }

    /**
     * Checks if two babies are twins. Twins should have similar last name, different first name, different ID and similar date of birth or difference of one day between the date of birth of the current baby and the other.
     * @param other - the baby to compare this baby with.
     * @return true if the babies are twins.
     */
    public boolean areTwins (Baby other)
    {
        if(_firstName.equals(other._firstName))// case their names are equals. 
            return false;
        if(!_lastName.equals(other._lastName))// case their last names are'nt equals. 
            return false;
        if(_id.equals(other._id)) // case their ids are equals.
            return false; 
        if(_dateOfBirth.equals(other._dateOfBirth) || _dateOfBirth.equals(other._dateOfBirth.tomorrow()) || _dateOfBirth.tomorrow().equals(other._dateOfBirth)) // case their date of birth is close.
            return true;
        return false;
    }

    /**
     * Checks if the weight of this baby is heavier than the weight of another baby.
     * @param other - baby to compare this baby's weight to.
     * @return true if the weight of this baby is heavier than the weight of the other baby.
     */
    public boolean heavier (Baby other)
    {
        if(_currentWeight.heavier(other._currentWeight))
            return true;
        return false;
    }

    /**
     * Updates the baby's current weight by adding the additional grams. If the sum of the current weight and the additional grams is negative, the baby's current weight will remain unchanged.
     * @param grams - the number of grams to add to he baby's current weight (can be negative).
     */
    public void updateCurrentWeight (int grams)
    {
        _currentWeight = _currentWeight.add(grams);
    }

    /**
     * Checks if the date of birth of this baby is before than the date of birth of another baby.
     * @param other - baby to compare this baby's date of birth to.
     * @return true if the date of birth of this baby is before the date of birth of the other baby.
     */
    public boolean older (Baby other)
    {
        if(_dateOfBirth.before(other._dateOfBirth))
            return true;
        return false;
    }

    /**
     * Checks if the current weight of this baby is within the valid range.
     * @param number - of days passed since the baby was born.
     * @return 1- If the date given as a parameter is less than a week or more than a year. 2- If the progress is not correct according to the rules.
     * 3- If the progress is correct according to the rules.
     */
    public int isWeightInValidRange (int numOfDays)
    {
        int totalCurrentWeigt = _currentWeight.getKilos() * 1000 + _currentWeight.getGrams();
        int totalBirthWeigt = _birthWeight.getKilos() * 1000 + _birthWeight.getGrams();
        if ( numOfDays > 365 || numOfDays < 0)// the day is uncorrect.
            return 1;
        if (numOfDays <= 7 && (totalCurrentWeigt <  (totalBirthWeigt - (totalBirthWeigt * 0.1 / 7 * numOfDays)))) // cheks the rangs of the 7 first day.
            return 2;
        else if(numOfDays >= 8 && numOfDays <= 60 && (totalCurrentWeigt <  totalBirthWeigt * 0.9 + 30 * (numOfDays-8)))// cheks the rangs btween 8 to 60 days.
            return 2;
        else if(numOfDays > 60 && numOfDays <= 120 && (totalCurrentWeigt <  + totalBirthWeigt * 0.9 + 30 * (60-8) + 25 * (numOfDays-61)))// cheks the rangs btween 61 to 120 days.
            return 2;
        else if(numOfDays > 120 && numOfDays <= 240 && (totalCurrentWeigt <  totalBirthWeigt * 0.9 + 30 * (60-8) + 25 * (120-61)+ 16 * (numOfDays-121))) // cheks the rangs btween 121 to 240 days.
            return 2;
        else if(numOfDays > 240 && (totalCurrentWeigt<  totalBirthWeigt * 0.9 + 30 * (60-8) + 25 * (120-61)+ 16 * (240-121) + 8 * (numOfDays - 241)))// cheks the rangs btween 241 to 365 days.
            return 2;
        return 3; // case all was good.
    }
}
