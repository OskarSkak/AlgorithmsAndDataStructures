package Data_Structures;

public class DirectAdressTable<T> {

    private static final int DEFAULT_MAX_KEY = 100;
    private T[] table;

    public DirectAdressTable(int maxKey){
        this.table = (T[])new Object[maxKey + 1];
    }

    public DirectAdressTable(){
        this(DEFAULT_MAX_KEY);
    }

    public void insert(T t, int key){ this.table[key] = t; }

    public T directAddressSearch(int key){return this.table[key];}

    public void directAddressDelete(int key){this.table[key] = null;}
}
