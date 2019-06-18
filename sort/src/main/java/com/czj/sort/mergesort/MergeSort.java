package com.czj.sort.mergesort;

import java.util.Scanner;

/**
 * @Author: clownc
 * @Date: 2019-06-17 15:35
 * 归并排序是稳定的排序方法。
 * 归并排序的时间复杂度为O(nlogn)。
 * 速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String inStr = in.nextLine();
            String[] str = inStr.split(" ");
            int a[] = new int[str.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            // 调用方法得到数组
            int[] results = sort(a);

            //将数组转换成字符串输出
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < results.length; i++) {
                result.append(results[i]).append(",");
            }
            // 删除最后一个逗号
            if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
            System.out.println(result);
        }
    }

    private static int[] sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
        return a;
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            //左右进行归并排序的递归
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
            //合并
            merge(a, middle, left, right);
        }
    }

    private static void merge(int[] a, int middle, int left, int right) {
        int[] tmpArr = new int[a.length];//中间数组
        int mid = middle + 1; // 右边的起始位置
        int tmp = left;
        int third = left;
        while (left <= middle && mid <= right) {
            // 从两个数组中选取较小的数放入中间数组
            if (a[left] <= a[mid]) {
                tmpArr[third++] = a[left++];
            } else {
                tmpArr[third++] = a[mid++];
            }
        }
        // 将剩余的部分放入中间数组
        while (left <= middle) {
            tmpArr[third++] = a[left++];
        }
        while (mid <= right) {
            tmpArr[third++] = a[mid++];
        }
        // 将中间数组复制回原数组
        while (tmp <= right) {
            a[tmp] = tmpArr[tmp++];
        }
    }
}
