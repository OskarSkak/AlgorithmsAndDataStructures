package Sorting_Algorithms;

public class QuickSort{
    public QuickSort(){

    }

    public static void sort(int[] arr, int low, int high){
        if (low < high){
            int partitioningIndex = partition(arr, low, high);
            sort(arr, low, partitioningIndex - 1); //Before partition value
            sort(arr, partitioningIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];

        int i = (low - 1);
        for(int j = low; j <= high - 1; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}