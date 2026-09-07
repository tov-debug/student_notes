
/**
 * This class represents a Weight Object.
 * @author (Tova Noyman). 
 * @version (09/12/24).
 */
public class Weight
{
    private int _kilos;
    private int _grams;
    private static final int MAX_GRAMS = 999;
    private static final int MIN_GRAMS = 0;
    private static final int MIN_KILOS = 1;
    private static final int DEFAULT_KILOS = 1;
    private static final int DEFUALT_GRAMS = 0;
    private static final int TWO_DIGIT_NUM = 10;
    private static final int THREE_DIGIT_NUM = 100;
    private static final int GRAMS_IN_KILO = 1000;
    //constructors:
    /**
     * Weight constructor - If the given weight is valid - creates a new Weight object, otherwise if one of the parameters in not valid initialize it to 1.
     * @param kilos the number of kilos in Weight (greater or equal to 1).
     * @param grams the number of grams in Weight (0-999).
     */
    public Weight(int kilos, int grams)
    {
        if(isRealWeight(kilos, grams))
        {
            _kilos = kilos;
            _grams = grams;
        }
        else
        {
            _kilos = 1;
            _grams = 0;
        }
    }

    /**
     * Copy constructor.
     * @param other - the weight to be copied.
     */
    public Weight (Weight other)
    {
        _kilos = other._kilos;
        _grams = other._grams;
    }

    /**
     * Constructor with only one parameter.
     * @param totalGrams - the total number of grams.
     */
    public Weight(int totalGrams) 
    {
        _kilos = totalGrams / GRAMS_IN_KILO;
        _grams = totalGrams % GRAMS_IN_KILO;
        if(totalGrams < 1000) // totalGrams is not real gram.
        {
            _kilos = 1;
            _grams = 0;
        }
    }

    /** 
     * Gets the kilos.
     * @return the number of kilos for this weight.
     */
    public int getKilos()
    {
        return _kilos; 
    }

    /** 
     * Gets the grams.
     * @return the number of grams for this weight.
     */
    public int getGrams()
    {
        return _grams; 
    }

    /**
     * Checks if two weights are the same.
     * @param other - the weight to compare this weight to.
     * @return if the weights are the same.
     */
    public boolean equals (Weight other)
    {
        return _kilos == other._kilos && _grams == other._grams;
    }

    /**
     * Checks if this weight is lighter than another weight.
     * @param other - weight to compare this weight to.
     * @return true if this weight is lighter than the other weight.
     */
    public boolean lighter (Weight other)
    {
        int totalGrams = _kilos * GRAMS_IN_KILO + _grams;
        int totalGramsOther = other._kilos * GRAMS_IN_KILO + other._grams;
        return totalGrams < totalGramsOther ;
    }

    /**
     * Checks if this weight is heavier than another weight.
     * @param other - weight to compare this weight to.
     * @return true if this weight is heavier than the other weight.
     */
    public boolean heavier (Weight other)
    {
        return other.lighter(this);
    }

    /**
     * Returns a String that represents this weight.
     * @return a String that represents this weight in the following format: kiols.grmas(3 digits) for example: 4.07 or 3.055 or 4.005.
     */
    public String toString()
    {
        String grams = "" ;
        if( _grams % THREE_DIGIT_NUM == MIN_GRAMS)  // case grams has  two extra zeros.
            grams +=  _grams / THREE_DIGIT_NUM; 
        else 
        {
            if( _grams % TWO_DIGIT_NUM == MIN_GRAMS) // case grams has extra zero.
                grams +=  _grams / TWO_DIGIT_NUM;
            else // case grams doesne't have extra zero. 
                grams +=  _grams; 
        }
        if(_grams < THREE_DIGIT_NUM && _grams != 0 ) // case grams missing zero or two.
        {
            if( _grams / TWO_DIGIT_NUM == MIN_GRAMS) // case grams missing 2 zeros.
                grams =  "00" + grams ;
            else // case grams missing zero.
                grams = "0" + grams; 
        }
        return (_kilos + "." + grams);
    }

    /**
     * Return a new weight with the additional grams given as parameter.
     * @param grams - the additional grams to add to the new returned weight.
     * @return a new weight with the additional grams given as parameter.
     */
    public Weight add (int grams)
    {
        int totalWeight = _kilos * 1000 + _grams + grams;
        Weight newWeight = new Weight(totalWeight);
        if(!isRealWeight(newWeight._kilos,newWeight._grams))
        {
            newWeight._kilos = _kilos;
            newWeight._grams = _grams;
        }
        return newWeight;
    }

    private static boolean isRealWeight(int kilos, int grams)// checks if the kilos and grams represent a real weight.
    {
        if(kilos < MIN_KILOS || grams < MIN_GRAMS || grams > MAX_GRAMS)
            return false;
        return true;
    }
}
