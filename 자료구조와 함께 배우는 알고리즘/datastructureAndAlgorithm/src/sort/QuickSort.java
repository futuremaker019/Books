package sort;

import java.util.Scanner;

public class QuickSort {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void partition(int[] a, int arrLength) {
        int pl = 0;                 // 왼쪽 커서
        int pr = arrLength - 1;     // 오른쪽 커서
        int x = a[arrLength / 2];     // 피벗 (가운데 위치의 값)

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr) {
                // pl을 파라미터로 던져주고 증가??
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        System.out.println("피벗의 값은 " + x + "입니다.");

        System.out.println("피벗 이하의 그룹");
        // a[0] ~ a[pl - 1]
        for (int i = 0; i <= pl - 1; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        if (pl > pr + 1) {
            System.out.println("피벗과 일치하는 그룹");
            // a[pr+1] ~ a[pl-1]
            for (int i = pr + 1; i <= pl - 1; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }

        System.out.println("피벗 이상의 그룹");
        // a[pr+1] ~ a[n-1]
        for (int i = pr + 1; i < arrLength; i++)
            System.out.print(a[i] + " ");
        System.out.println();
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
        partition(x, arrLength);
    }
}
