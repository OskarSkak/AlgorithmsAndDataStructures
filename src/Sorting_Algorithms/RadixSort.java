//From pseudo https://www.codingeek.com/algorithms/radix-sort-explanation-pseudocode-and-implementation/
package Sorting_Algorithms;

public class RadixSort {

    public static int getMax(int A[])
    {
        int max = A[0];
        for (int i = 1; i < A.length; i++){
            if (A[i] > max)
                max = A[i];
        }
        return max;
    }

    public static void sort(int[] A){
        sort(A, false);
    }

    public static void sort(int A[], boolean printEachIteration)
    {
        int digitPlace = 1;
        int n=A.length;
        int result[]=new int[n]; // resulting array
        // Find the largest number to know number of digits
        int largestNum = getMax(A);
        int printCount = 0;


        //we run loop until we reach the largest digit place
        while(largestNum/digitPlace >0){

            int count[]=new int[10];
            //Initializing counting array C[] to 0
            for (int i=0; i <10; i++)
                count[i] = 0;

            //Store the count of "keys" or digits in count[]
            for (int i = 0; i < n; i++)
                count[ (A[i]/digitPlace)%10 ]++;

            // Change count[i] so that count[i] now contains actual
            //  position of this digit in result[]
            //  Working similar to the counting sort algorithm
            for (int i = 1; i < 10; i++)
                count[i] += count[i - 1];

            // Build the resulting array
            for (int i = n - 1; i >= 0; i--)
            {
                result[count[ (A[i]/digitPlace)%10 ] - 1] = A[i];
                count[ (A[i]/digitPlace)%10 ]--;
            }

            // Now main array A[] contains sorted
            // numbers according to current digit place
            for (int i = 0; i < n; i++)
                A[i] = result[i];

            if (printEachIteration){
                System.out.print("\n" + ++printCount + ". Iteration:\n");
                for(int i = 0; i < A.length; i++){
                    System.out.print(A[i] + ", ");
                }
            }

            // Move to next digit place
            digitPlace *= 10;
        }
    }
}
