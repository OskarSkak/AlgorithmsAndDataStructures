public class Main {

    public static void main(String[] args) {
        int[] random = ArrayUtil.generateRandom(50, 10, 1000);
        int[] sorted = ArrayUtil.generateSorted(50);
        int[] reverse = ArrayUtil.generateReverse(50);

        ArrayUtil.printArray(random);
        CountingSort.sort(random);
        ArrayUtil.printArray(random);
    }
}
