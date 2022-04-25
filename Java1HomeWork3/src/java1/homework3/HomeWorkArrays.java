package java1.homework3;

import java.util.Arrays;

public class HomeWorkArrays {

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1};
        changeArray(arr);
        System.out.println("----------------------------");
        createArray(100);
        System.out.println("----------------------------");
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeElementsArray(arr2);
        System.out.println("----------------------------");
        int[][] arr3 = new int[5][5];
        initialArray(arr3);
        printArray(arr3);
        System.out.println("----------------------------");
        System.out.println(Arrays.toString(createArray(10, 8)));
        System.out.println("----------------------------");
        int[] arr5 = {8, 9, -2, 3, 10, 15, -20, 0};
        mixMaxElement(arr5, arr5[0], arr5[0]);


    }

    public static void changeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void createArray(int len) {
        int[] arr1 = new int[len];
        for (int i = 0; i <= len - 1; i++) {
            arr1[i] = i + 1;
            System.out.print(arr1[i] + " | " + "\t");
            if (arr1[i] % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void changeElementsArray(int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 6) {
                arr2[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr2));
    }

    public static void initialArray(int[][] arr3) {
        for (int i = 0; i < arr3.length; i++) {
            arr3[i][i] = 1;
            arr3[i][arr3.length - 1 - i] = 1;
        }
    }

    public static void printArray(int[][] arr3) {
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[] createArray(int leng, int initialValue) {
        int[] arr4 = new int[leng];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = initialValue;
        }
        return arr4;
    }

    public static void mixMaxElement(int[] arr5, int min, int max) {
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] < min) {
                min = arr5[i];
            }
            if (arr5[i] > max) {
                max = arr5[i];
            }
        }
        System.out.println("Min = " + min + " | Max = " + max);
    }


}
