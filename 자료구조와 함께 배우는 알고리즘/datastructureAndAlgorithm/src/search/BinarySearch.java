package search;

import java.util.Scanner;

public class BinarySearch {
    static int binSearch(int[] a, int arrLength, int key) {
        int pl = 0;                     //검색 범위의 첫 인덱스
        int pr = arrLength - 1;         // 검색 범위의 끝 인덱스

        while (pl <= pr) {
            int pc = (pl + pr) / 2;     //중앙 요소의 인덱스
            if (a[pc] == key)           // 키값과 중앙값이 같을때
                return pc;
            if (a[pc] < key)            // 키값이 중앙값보다 클때
                pl = pc + 1;
            if (a[pc] > key)
                pr = pc - 1;     // 키값이 중앙값보다 작을때
        }
        return -1;                      // 검색 실패
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소수 : ");
        int arrLength = stdIn.nextInt();
        int[] a = new int[arrLength];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("a[0]: ");
        a[0] = stdIn.nextInt();

        for (int i = 1; i < arrLength; i++) {
            do {
                System.out.print("a[" + i + "]: ");
                a[i] = stdIn.nextInt();
            } while (a[i] < a[i - 1]);
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int result = binSearch(a, arrLength, key);

        if (result == -1)
            System.out.println("선택하신 값은 요소에 없습니다.");
        else
            System.out.print(key + "는 a[" + result + "]에 있습니다." );
    }
}
