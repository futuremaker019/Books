package sort;

import java.util.Scanner;

public class QuickSort2 {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;                // 왼쪽 커서
        int pr = right;               // 오른쪽 커서
        int x = a[(pl + pr) / 2];     // 피벗 (가운데 위치의 값)

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr) {
                // pl을 파라미터로 던져주고 증가??
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (right > pl) quickSort(a, pl, right);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("배열을 나눕니다.");
        System.out.print("요소수 : ");
        int arrLength = stdIn.nextInt();
        int[] x = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }
        quickSort(x, 0, arrLength -1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < arrLength; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
