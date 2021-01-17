package search;

import java.util.Scanner;

public class LinearSearch {

    static int seqSearch(int[] a, int arrLength, int key){
        int i = 0;

        // 보초를 추가
        a[arrLength] = key;

        while (true) {
            if (a[i] == key)
                break;
            i++;
        }

        for (int j = 0; j < arrLength; j++) {
            System.out.println("x["+ j + "] jj: " + a[j]);
        }

        return i == arrLength ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소수: ");
        int arrLength = stdIn.nextInt();
        int[] x = new int[arrLength + 1];

        for (int i = 0; i < arrLength; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int idx = seqSearch(x, arrLength, key);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(key + "는 x[" + idx + "]에 있습니다.");

        for (int i = 0; i < arrLength; i++) {
            System.out.println("x["+ i + "] : " + x[i]);
        }
    }

}
