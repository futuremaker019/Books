package sort;

public class BubbleSort {

    public static void swap (int[] a, int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void bubbleSort(int[]a, int arrLength) {
        for(int i = 0; i < arrLength - 1; i++) {
            for (int j = arrLength - 1; j > i; j--){
                if (a[j-1] > a[j])
                    swap(a, j-1, j);
            }
        }
    }

    public static void main(String[] args) {

    }
}
