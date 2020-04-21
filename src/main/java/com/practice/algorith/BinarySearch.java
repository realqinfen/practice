package com.practice.algorith;

/***
 * @Description 循环和递归分别实现二分查找。时间复杂度，最坏情况下，两种方式一样，都是O(log2N);最好情况是O(1)
 * 递归方式的时间复杂度计算方式：最坏情况下，递归X次找到，则：n/(2^X)=1,X=log2n
 * @Author fen.qin  16:30 2020/4/15
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        /*int i = commonSearch(arr, 1);
        System.out.println(i);*/
        int j = recursionSearch(arr, 1, 0, arr.length - 1);
        System.out.println(j);
    }

    //循环实现，相比递归节省空间
    private static int commonSearch(int arr[], int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (key < arr[mid]) {
                right = mid - 1;
            } else if (key > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //递归方式实现
    public static int recursionSearch(int arr[], int key, int left, int right) {
        if (left > right || key < arr[left] || key > arr[right]) {
            return -1;
        }
        int mid = (left + right) >>> 1;
        if (key > arr[mid]) {
            return recursionSearch(arr, key, mid + 1, right);
        } else if (key < arr[mid]) {
            return recursionSearch(arr, key, left, mid - 1);
        } else {
            return mid;
        }
    }
}
