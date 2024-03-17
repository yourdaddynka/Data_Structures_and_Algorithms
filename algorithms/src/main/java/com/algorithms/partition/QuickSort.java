package com.algorithms.partition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class QuickSort {
    public static void myQuickSort(long[] arr) {
        myQuickSort(arr, 0, arr.length - 1);
    }

    public static boolean isPartiallySorted(long[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int partitionHoar(long[] arr, int low, int high) {
        int grater = low;
        int equals = low;
        int randomNumber = new Random().nextInt(high - low + 1) + low;
        long pivot = arr[randomNumber];
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                long temp = arr[i];
                arr[i] = arr[grater];
                arr[grater] = arr[equals];
                arr[equals] = temp;
                grater++;
                equals++;
            } else if (arr[i] == pivot) {
                long temp = arr[i];
                arr[i] = arr[grater];
                arr[grater] = temp;
                grater++;
            }
        }
        return equals;
    }

    public static void myQuickSort(long[] arr, int low, int high) {
        if (low < high && !isPartiallySorted(arr, low, high)) {
            int partition = partitionHoar(arr, low, high);
            myQuickSort(arr, low, partition);
            myQuickSort(arr, partition + 1, high);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(in.readLine());
        long[] arr = new long[size];
        String[] tempArgs = in.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            arr[i] = Long.parseLong(tempArgs[i]);
        }
        myQuickSort(arr);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}