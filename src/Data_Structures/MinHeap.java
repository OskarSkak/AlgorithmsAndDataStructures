package Data_Structures;

public class MinHeap {
    private Element[] elements;
    private int heapSize;

    public MinHeap(int size){
        this.elements = new Element[size];
        heapSize = -1; //Insert changes this to index 0 at first insert
    }

    public void insert(Element e) {
        heapSize++;
        int i = heapSize;
        elements[i] = e;
        while(parent(i) != i && elements[parent(i)].getKey() > elements[i].getKey()){
            exchange(i, parent(i));
            i = parent(i);
        }
    }

    private void exchange(int index_1, int index_2){
        Element temp = elements[index_1];
        elements[index_1] = elements[index_2];
        elements[index_2] = temp;
    }
    private int parent(int i){
        if (i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }

    private int left(int i){
        return 2 * i + 1;
    }

    private int right(int i){
        return 2 * i + 2;
    }

    public Element extractMin() {
        Element min = elements[0];
        elements[0] = elements[heapSize];
        elements[heapSize] = null;
        heapSize--;
        minHeapify(0);
        return min;
    }

    public void minHeapify(int i){
        int left = left(i);
        int right = right(i);
        int smallest = -1;

        if (left <= heapSize && elements[left].getKey() < elements[i].getKey()) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= heapSize && elements[right].getKey() < elements[smallest].getKey()) {
            smallest = right;
        }
        if (smallest != i) {

            exchange(i, smallest);
            minHeapify(smallest);
        }
    }
}

class Element{
    private int key;
    private Object data;

    public Element(int i, Object o){
        this.key = i;
        this.data = o;
    }
    public int getKey(){
        return this.key;
    }
    public Object getData(){
        return this.data;
    }
}
