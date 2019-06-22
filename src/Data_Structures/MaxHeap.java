package Data_Structures;

public class MaxHeap {
    private MaxElement[] elements;
    private int heapSize;

    public MaxHeap(int size){
        this.elements = new MaxElement[size];
        heapSize = -1; //Insert changes this to index 0 at first insert
    }

    public void printHeap(){
        System.out.println("\n*******HEAP********");
        for(int i = 0; i <= heapSize; i++){
            System.out.print("( " + this.elements[i].getKey() + " )");
        }
    }

    public void printHeap(String message){
        System.out.println("\n*********HEAP**********\n" + message);
        for(int i = 0; i <= heapSize; i++){
            System.out.print("( " + this.elements[i].getKey() + " )");
        }
        System.out.println("*******************************");
    }

    public void insert(int e){
        insert(new MaxElement(e, null));
    }

    public void insert(MaxElement e) {
        heapSize++;
        int i = heapSize;
        elements[i] = e;
        while(parent(i) != i && elements[parent(i)].getKey() < elements[i].getKey()){
            exchange(i, parent(i));
            i = parent(i);
        }
    }

    private void exchange(int index_1, int index_2){
        MaxElement temp = elements[index_1];
        elements[index_1] = elements[index_2];
        elements[index_2] = temp;
    }
    private int parent(int i){
        if (i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }

    /**
     * NOTE: Heap specified name as Not from book pseudo
     * @param key placement in heap
     * @param increaseTo new value (must be higher)
     */
    public void increaseKey_Heapify(int key, int increaseTo){
        //comment in if 1 indexed! key--;
        if (this.elements[key].getKey() < increaseTo)
            this.elements[key].setKey(increaseTo);
        this.maxHeapify(key);
    }

    /**
     * From book pseudo
     * * @param
     * * @param increaseTo new value (must be higher)
     */
    public void increaseKeyWithoutIndex(int oldValue, int newValue){
        if(oldValue > newValue) return;

        int positionOfNewValue = -1;
        for(int i = 0; i <= this.heapSize; i++){
            if (this.elements[i].getKey() == oldValue){
                positionOfNewValue = i;
                break;
            }
        }
        if(positionOfNewValue < 0) return;

        this.elements[positionOfNewValue].setKey(newValue);
        int i = positionOfNewValue;
        while(this.elements[i] != null && this.elements[this.parent(i)].getKey() < elements[i].getKey()){
            this.exchange(i, parent(i));
            i = parent(i);
        }
    }

    public void increaseKeyWithIndexForExam(int index, int key){
        index--;
        if(key < this.elements[index].getKey()) return;

        this.elements[index].setKey(key);
        while(this.elements[parent(index)] != null &&
                this.elements[parent(index)].getKey() < this.elements[index].getKey()){
            this.exchange(index, parent(index));
            index = parent(index);
        }
    }

    private int left(int i){
        return 2 * i + 1;
    }

    private int right(int i){
        return 2 * i + 2;
    }

    public MaxElement extractMax() {
        MaxElement max = elements[0];
        elements[0] = elements[heapSize];
        elements[heapSize] = null;
        heapSize--;
        maxHeapify(0);
        return max;
    }

    public void maxHeapify(int i){
        int left = left(i);
        int right = right(i);
        int largest = -1;

        if (left <= heapSize && elements[left].getKey() > elements[i].getKey()) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= heapSize && elements[right].getKey() > elements[largest].getKey()) {
            largest = right;
        }
        if (largest != i) {

            exchange(i, largest);
            maxHeapify(largest);
        }
    }
}

