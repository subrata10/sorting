package com.home.insertionsort.com.home.selectionsort;

import java.util.Scanner;

public class SelectionSort {

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

        numbers = doSelectionSort(numbers);

        System.out.println("Sorted number: ");
        for (int number: numbers) {
            System.out.print(number+" ");
        }

    }

    private static int[] doSelectionSort(int[] numbers) {
        int minIndex, temp;

        for(int i=0; i<numbers.length; i++) {
            minIndex = i;

            for(int j=i+1; j<numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }

            temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }

        return numbers;
    }

}
