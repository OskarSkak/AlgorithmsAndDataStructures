import Sorting_Algorithms.*;
import Data_Structures.*;
import Util.ArrayUtil;

public class Main {

    public static void main(String[] args) {
        int[] random = ArrayUtil.generateRandom(50, 10, 1000);
        int[] sorted = ArrayUtil.generateSorted(50);
        int[] reverse = ArrayUtil.generateReverse(50);

        InsertionSort.sort(random);
        ArrayUtil.printArray(random);
        System.out.print(ArrayUtil.checkIfSorted(random));
    }
}
