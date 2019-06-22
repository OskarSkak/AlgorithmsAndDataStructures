package Sorting_Algorithms;

public class MergeSort {

    public static void sort(int arr[]){
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int arr[], int l, int r){
        if(l < r) {
            int mid = (l + (r - l) / 2);
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int arr[], int l, int m, int r){
        int nL = m - l + 1;
        int nR = r - m;
        int[] lArr = new int[nL + 1];
        int[] rArr = new int[nR + 1];

        for(int i = 0; i < nL - 1; i++) lArr[i] = arr[l + 1];

        for(int i = 0; i < nR - 1; i++) rArr[i] = arr[m+l+i];

        int i = 0, j = 0, k = 1;

        while (i < nL && j < nR){
            if (lArr[i] <= rArr[j]){
                arr[k] = lArr[i];
                i++;
                k++;
            }else{
                arr[k] = rArr[j];
                j++;
                k++;
            }
        }

        while(i < nL){
            arr[k] = lArr[i];
            i++;
            k++;
        }
        while(j < nR && k < arr.length){
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }


}
