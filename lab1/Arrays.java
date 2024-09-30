/*  c5 = 1 Дія з матрицею(ями) - C = B^T (транспонування)
*   c7 = 5 Тип елементів матриці - char
*   c11 = 4 Дія з матрицею С Обчислити суму найбільших елементів
*           в рядках матриці з парними номерами та найменших елементів
*           в рядках матриці з непарними номерами */

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] arr = {
                        {'a', 'b', 'c', 'd', 'e'},
                        {'f', 'g', 'h', 'i', 'j'},
                        {'k', 'l', 'm', 'n', 'o'},
                        {'p', 'q', 'r', 's', 't'},
                        {'u', 'v', 'w', 'x', 'y'},
                        {'z', '1', '2', '3', '4'},
                     };
        char[][] transposedArray = transposeMatrix(arr);
        int[][] hashedArray = hashedMatrix(transposedArray);

        System.out.println("Original Array:");
        printCharMatrix(arr);

        System.out.println("\nTransposed Array:");
        printCharMatrix(transposedArray);

        System.out.println("\nHashed Array:");
        printIntMatrix2D(hashedArray);

        System.out.println("\nSums of numbers with odd min and even max indexes in each row:");
        printIntArray(findSum(hashedArray));

        sc.nextLine();
    }

    static char[][] transposeMatrix(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            throw new IllegalArgumentException();

        int rows = matrix.length;
        int cols = matrix[0].length;

        char[][] newMatrix = new char[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    static int[][] hashedMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] hashedMatrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                hashedMatrix[i][j] = Character.hashCode(matrix[i][j]);
            }
        }
        return hashedMatrix;
    }

    static int[] findSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] sum = new int[rows];

        for (int i = 0; i < rows; i++) {
            sum[i] = findEvenMax(matrix[i]) + findOddMin(matrix[i]);
        }
        return sum;
    }

    static int findEvenMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    static int findOddMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    static void printCharMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    static void printIntMatrix2D(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}