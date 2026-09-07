
/**
 * Number of operations in the MatrixList classתת
 * which represents a matrix by a list of class IntNodeMat.
 *
 * @author (Tova Noyman)
 * @version (25/05/25)
 */

public class MatrixList{
    IntNodeMat _m00;

    public MatrixList(){
        _m00 = null;
    }

    /**
     * Constractor of class MatrixList, 
     * creates a mat out of list that each node represented by class IntNodeMat.
     * @param mat the list to build.
     */
    public MatrixList(int[][] mat){
        IntNodeMat currRow = null, up = null, left;
        for(int i = 0; i < mat.length; i++){
            left = null;
            for(int j = 0; j < mat[0].length; j++){
                IntNodeMat curr = new IntNodeMat(mat[i][j]);
                if (j == 0)// the first place in each row.
                {
                    currRow = curr;
                    if (i == 0) // the firs place in row&col.
                        _m00 = curr; 
                }
                if (left != null) // connecting right & left, when there is what to connect to.
                {
                    left.setNextCol(curr); //right.
                    curr.setPrevCol(left);
                }
                if (up != null)// connecting up & down, when there is what to connect to. 
                {
                    up.setNextRow(curr); // down
                    curr.setPrevRow(up);
                    if(j < mat[0].length-1) // case there is more cols.
                        up = up.getNextCol();
                }
                left = curr;
            }
            up = currRow;
        }
    }

    /**
     * gets indexs and return the number in that place.
     * @param i & j that represent a place at the matrix list.
     * @return the data insaed this place.
     */
    public int getDataIJ (int i, int j){
        IntNodeMat temp = _m00;
        for(int a = 0; a < j ; a++)// gets to the right col.
        {
            if(temp == null)
                return Integer.MIN_VALUE;
            temp = temp.getNextCol();
        }
        for(int k = 0; k < i ; k++)// gets to the right row.
        {
            if(temp == null)
                return Integer.MIN_VALUE;
            temp = temp.getNextRow();
        }
        if(temp == null || i < 0 || j < 0)//there is no such place.
            return Integer.MIN_VALUE;
        return temp.getData(); 
    }

    /**
     * gets indexs and num to set the place that the indexs represent.  
     *  @param i & j that represent a place at the matrix list.
     *  @param the data to set at the place.
     */
    public void setDataIJ (int data, int i, int j){
        if(getDataIJ(i,j) == Integer.MIN_VALUE)//there is no such place.
            return;
        IntNodeMat temp = _m00;
        for(int a = 0; a < j ; a++)// gets to the right col.
            temp = temp.getNextCol();
        for(int k = 0; k < i ; k++)// gets to the right row.
            temp = temp.getNextRow();
        temp.setData(data);
    }

    /**
     *retuen string that represent the all matrix.
     *@return String with all matrix data in the right order.
     */
    public String toString(){
        String string ="";
        IntNodeMat nextRow = null,temp = _m00;

        while( nextRow != null || temp != null){
            nextRow = temp.getNextRow();
            while(temp.getNextCol() != null){
                string += temp.getData() + "\t";
                temp = temp.getNextCol();
            }
            string += temp.getData()  + "\n"; 
            temp = nextRow;
        }
        return string;
    }

    /**
     *recorsive method that checks if the all mat descending.
     *@return true in case of descending row&cols values.
     */
    public boolean isDescending(){
        IntNodeMat temp = _m00;
        return isDescending(temp,'r');
    }
    //helps to chek the mat.
    private boolean isDescending(IntNodeMat temp, char direction){
        if(temp == null)
            return true;
        if( direction == 'r'){
            if (temp.getNextCol() != null && temp.getNextCol().getData() >= temp.getData())// col is'nt descending.
                return false;
            if (temp.getNextRow() != null && temp.getNextRow().getData() >= temp.getData())//row is'nt descending.
                return false;
        }
        else{
            if (temp.getPrevCol() != null && temp.getPrevCol().getData() <= temp.getData())// col is'nt descending.
                return false;
            if (temp.getPrevRow() != null && temp.getPrevRow().getData() <= temp.getData())//row is'nt descending.
                return false;
        }
        return  temp.getNextCol() == null ? isDescending(temp.getNextRow(),'l') : isDescending(temp.getNextCol(),'r');//cheks the next col, case the next is null cheks the nxt row.
    }
    /**
     *  An efficient method that counts the number of nodes with a negative value.
     * time complexity O(n+m) - in the worst case running on all row +col off the given mat.
     * space complexity O(1) - use a knowen number of space.
     * @return number of negetive datas at that matrix.
     */
    public int howManyNegative(){
        if(_m00 == null)//edge case.
            return 0;
        int length = 0, currLength=0, sumNegative =0;
        IntNodeMat temp = _m00;//pointer.
        while(temp!= null)// counting length.
        {
            length++;
            temp = temp.getNextCol();
        }
        temp = _m00;// starting over.
        while(temp.getNextRow()!= null)// geting to the left buttom.
            temp = temp.getNextRow();
        while(temp!= null){
            if(temp.getData() < 0)// from now on this row is negetive.
            {
                sumNegative += length - currLength;
                temp = temp.getPrevRow();// cheking the previous row.
            }
            else{
                temp = temp.getNextCol();// maybe the one in right is negetive.
                currLength++; // for the summary of negetives.
            }
        }
        return sumNegative;
    }
}
//done ;)