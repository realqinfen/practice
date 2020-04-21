package com.practice.algorith;

public class QuickSort {

    public static void main(String[] args) {
        System.out.println("hello");
        int arr[] = {3, 5, 7, 2, 9, 4, 8, 1, 6};
        m1(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void quick(int arr[], int left, int right) {
        if (left > right) return;
        int key = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && key < arr[j]) {
                j--;
            }
            while (i < j && key > arr[i]) {
                i++;
            }
            if (i < j) {
                int k = arr[i];
                arr[i] = arr[j];
                arr[j] = k;
            }
        }
        arr[left] = arr[i];
        arr[i]=key;
        quick(arr,left,i-1);
        quick(arr,i+1,right);
    }

    public static void m1(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (i < j && temp <= arr[j]) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) {
                int k = arr[i];
                arr[i] = arr[j];
                arr[j] = k;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        m1(arr, left, i - 1);
        m1(arr, i + 1, right);
    }

}
