
/**
 * given int node class, for Ex14.
 */
public class IntNodeMat
{
    private int _data;
    private IntNodeMat _nextRow, _nextCol, _prevRow, _prevCol;

    public IntNodeMat(int data)
    {
        _data = data;
        _nextRow = null;
        _nextCol = null;
        _prevRow = null;
        _prevCol = null;
    } 
    
    public IntNodeMat(int data, IntNodeMat nextR, IntNodeMat nextC,
    IntNodeMat prevR, IntNodeMat prevC)
    {
        _data = data;
        _nextRow = nextR;
        _nextCol = nextC;
        _prevRow = prevR;
        _prevCol = prevC;
    }

    public int getData() {return _data;}
    
    public IntNodeMat getNextRow() {return _nextRow;}

    public IntNodeMat getNextCol() {return _nextCol;}

    public IntNodeMat getPrevRow() {return _prevRow;}

    public IntNodeMat getPrevCol() {return _prevCol;}  
    

    public void setData(int data) {_data = data;}
    
    public void setNextRow(IntNodeMat next) {_nextRow = next;}

    public void setNextCol(IntNodeMat next) {_nextCol = next;}

    public void setPrevRow(IntNodeMat next) {_prevRow = next;}

    public void setPrevCol(IntNodeMat next) {_prevCol = next;}
}
