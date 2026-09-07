
/**
 * The HealthCare class manages data about babies in a healthcare branch,
 * such as tracking their weights and birth information.
 *
 * @author Tova Noyman
 * @version 08/01/2025
 */
//1:
public class HealthCare
{
    private String _name;
    private Baby[] _babies;
    private int MAX_NUM_BABIES = 300;
    //constctor:
    /**
     * Initializes a new HealthCare branch with the given name.
     * @param The name of the healthcare branch. 
     */
    public HealthCare(String name)
    {
        _name = name;
        _babies = new Baby[MAX_NUM_BABIES];
    }
    /**
     * Retrieves the name of the healthcare branch.
     * @return The name as a String.
     */
    public String getName()
    {
        return _name;
    }

    /**
     * Retrieves the number of babies in the branch.
     * @return The number of babies as an integer.
     */
    public int numOfBabies()
    {
        for(int i = 0; i < MAX_NUM_BABIES; i++)// loop that goes all over the array of babies.
            if(_babies[i] == null) //if this index empty.
                return i;
        return MAX_NUM_BABIES;// case the array is'nt empty.
    }

    /**
     * Adds a new baby to the healthcare branch.
     * @param baby: The Baby object to add.
     * @return true if the baby came in.
     */
    public boolean addBaby(Baby baby)
    {
        int index=0;
        if( numOfBabies() == MAX_NUM_BABIES || baby == null)// case the array is full or the given baby is'nt intlize.
            return false;
        if ( numOfBabies() == 0)// case the array is empty.
        {
            _babies[0]=baby; // insert the givenn baby to the first place.
            return true;
        }
        while(_babies[index] != null && _babies[index].older(baby))  // loop that premot the index till the array at this index older than the given baby.       
            index++ ; 
        for(int i = numOfBabies(); i > index; i--)// loop that mooves each baby that younger than the given baby to the next place.
            _babies[i]=_babies[i-1];           
        _babies[index]=baby;// insert the given baby at the enpty fit place.
        return true;
    }

    /**
     * Finds all babies whose weight exceeds a given threshold.
     * @param weight: The weight threshold as a Weight object.
     * @return An array of Baby objects.
     */
    public int howManyAboveWeight(Weight weight)
    {
        int count = 0;
        for(int i = 0; i < numOfBabies(); i++) //  loop that goes over the array till the last baby.
            if(_babies[i].getCurrentWeight().heavier(weight))// case the current baby is heavier tnan the given weight.
                count++;
        return count;
    }

    private int babyTotalWeight(Baby baby)// return the total weiht of the baby
    {
        return baby.getCurrentWeight().getKilos() * 1000 + baby.getCurrentWeight().getGrams();
    }

    /**
     * Calculates the average weight of all babies in the branch.
     * @return The average weight as a Weight object.
     */
    public Weight averageWeight()
    {
        int sum = 0 , count = 0;
        if( numOfBabies() == 0) // case there is no baby.
            return null;
        for(int i = 0; i < numOfBabies(); i++)// loop that foes over the array till the last baby.
        { 
            count++;
            sum +=  babyTotalWeight(_babies[i]);// add the weight in int sum.
        }
        sum /= (double)count;// avarage.
        return new Weight((sum/1000), (sum%1000));// return the avarage in weight type.
    }

    /**
     *@return the heaviest baby at the clinic. 
     */
    public Baby mostHeaviestBaby()
    {
        int max = babyTotalWeight(_babies[0]);// present the first baby in total weight.
        Baby baby = _babies[0];
        for(int i = 1; i < numOfBabies(); i++)// loop that goes over the array from baby 2 to the last one.
        {
            if( babyTotalWeight(_babies[i]) > max)// case the curret baby's total weight is bigger than the kippen max.
            {
                max = babyTotalWeight(_babies[i]);
                baby = new Baby (_babies[i]);
            }
        }
        return baby;
    }

    /**
     * @param weiht to check.
     * @return array of babies that above the given weight.
     */
    public Baby[] babiesAboveWeight(Weight weight)
    {
        int currnetBaby = 0, numAbove = howManyAboveWeight(weight);
        if(numAbove == 0)// case there is no baby above weight.
            return null;
        Baby[] newBabies = new Baby[numAbove];//intlize an array to the length of num above the given weight.
        for(int i = 0; i < numOfBabies(); i++)// loop that go over the array till the last baby.
        {
            if(_babies[i].getCurrentWeight().heavier(weight))// case the baby is havier than the given weight.
            {
                newBabies[currnetBaby] = _babies[i];// insert the current baby to the new array.
                currnetBaby++; // premot to the next place at the new array . 
            }
        }
        return newBabies;
    }
    /**
     * Generates a string representation of the healthcare branch and its babies.
     * @retutn A String representation of the branch.
     */
    public String toString()
    {
        if(numOfBabies() == 0)//case empty.
            return "There are no babies in this Health Care branch.";
        String string = "Branch " + _name + " has 3 babies:" + "\n";
        for(int i = 0; i< numOfBabies(); i++)//loop that prints the baby at the clinic.
            string += _babies[i] + "\n";
        return string;
    }
}// end of class.

