package com.home.insertionsort;

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter the number: ");
        for (int i=0; i<size; i++) {
            numbers[i] = input.nextInt();
        }

        input.close();

        System.out.println("Entered number in non sorting order:");
        for (int number : numbers) {
            System.out.print(number+" ");
        }

        System.out.println("\n");

        numbers = doInsertionSort(numbers);

        System.out.println("Sorted number: ");
        for (int number: numbers) {
            System.out.print(number + " ");
        }
    }


    private static int[] doInsertionSort(int[] numbers) {
        int size = numbers.length;

        for (int i=1; i<size; i++) {
            int newNumber = numbers[i];
            int j = i - 1;

            while (j >= 0 && numbers[j] > newNumber) {
                numbers[j+1] = numbers[j];
                j = j - 1;
            }

            numbers[j+1] = newNumber;
        }

        return numbers;
    }
}
