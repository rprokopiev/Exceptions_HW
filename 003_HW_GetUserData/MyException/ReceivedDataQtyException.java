package MyException;

public class ReceivedDataQtyException extends BaseException{
    private int index;
    
    public ReceivedDataQtyException(String message, int index){
        super(message);
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

}
