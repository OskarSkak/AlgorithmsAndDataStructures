package Util;

import java.util.Random;

public class ArrayUtil {
    public static void printArray(int[] arr){
        System.out.println("\n****************************Printing array of size: " + arr.length + "****************************");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
            if((i + 1) % 10 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void printArray(String message, int[] arr){
        System.out.print("\n" + message);
        printArray(arr);
    }

    public static int[] generateSorted(int size){
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverse(int size){
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr.length - i;
        }
        return arr;
    }

    public static int[] generateRandom(int size, int min, int max){
        Random rand = new Random();
        int[] arr = new int[size];

        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(max - min) + min + 1;
        }
        return arr;
    }

    public static int[] generateRandom(int size){
        return generateRandom(size, 1, 100);
    }

    public static boolean checkIfSorted(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
