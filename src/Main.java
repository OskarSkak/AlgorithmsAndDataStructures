import Sorting_Algorithms.*;
import Data_Structures.*;
import Util.ArrayUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        int[] arr = {-1, -2, -3, -4, -5, -6, -7};
        MaxHeap heap = new MaxHeap(10);

        for(int i = 0; i < arr.length; i++)
            heap.insert(arr[i]);


        heap.printHeap();
        heap.extractMax();
        heap.printHeap();

    }
}
