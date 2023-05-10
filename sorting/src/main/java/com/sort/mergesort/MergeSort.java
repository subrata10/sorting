package com.sort.mergesort;

/**
 * Merge sort which follows the divide and conquer algorithm
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 7, 5, 4, 2, 1};
        MergeSort mergeSort = new MergeSort();
        arr = mergeSort.mergeSort(arr, 0, arr.length - 1);

        System.out.println("\n");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println("\n");
    }

    /**
     * This is base method which invoke itself (recursive call)
     *
     * @param arr   -- which needs to sort
     * @param start - start index of the array
     * @param end   - end index of the array
     * @return return the sorted array form start index to end index
     */
    public int[] mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (int) Math.ceil(start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            arr = merge(arr, start, mid, end);
            return arr;
        }
        return arr;
    }

    /**
     * This method first divide the array by its start, middle and end index.
     * Then create two partition between range of start and end index.
     * <p>
     * In first or left array it assign the value from start index to middle index.
     * In second or right side array it assigns the value from middle+1 index to end index.
     * <p>
     * Then compare and do in place operation to put the element in right place
     *
     * @param arr    - given array which will be sorted
     * @param start  - start of the index
     * @param middle - middle index of the array
     * @param end    - end index of the array
     * @return return the array in sorted order by its start and end index
     */
    public int[] merge(int[] arr, int start, int middle, int end) {
        int l_size = (middle - start) + 1;
        int[] leftArray = new int[l_size];

        for (int i = 0; i < l_size; i++) {
            leftArray[i] = arr[start + i];
        }

        int r_size = (end - middle);
        int[] rightArray = new int[r_size];

        for (int i = 0; i < r_size; i++) {
            rightArray[i] = arr[i + (middle + 1)];
        }

        int actualIndex = start;
        int i = 0;
        int j = 0;

        while (i < l_size && j < r_size) {
            if (leftArray[i] <= rightArray[j]) {
                arr[actualIndex] = leftArray[i];
                i = i + 1;
            } else {
                arr[actualIndex] = rightArray[j];
                j = j + 1;
            }

            actualIndex = actualIndex + 1;
        }

        while (j < r_size) {
            arr[actualIndex] = rightArray[j];
            j = j + 1;
            actualIndex = actualIndex + 1;
        }

        while (i < l_size) {
            arr[actualIndex] = leftArray[i];
            i = i + 1;
            actualIndex = actualIndex + 1;
        }

        return arr;
    }
}

