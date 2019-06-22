package Data_Structures;

public class MaxElement {
    private int key;
    private Object data;

    public MaxElement(int i, Object o){
        this.key = i;
        this.data = o;
    }
    public int getKey(){
        return this.key;
    }
    public Object getData(){
        return this.data;
    }

    public void setKey(int k){
        this.key = k;
    }
}
