package com.czj.sort.changesort;

import java.util.Scanner;

/**
 * @Author: clownc
 * @Date: 2019-06-17 15:03
 * 不稳定的排序。
 *快速排序的时间复杂度为O(nlogn)。
 *当n较大时使用快排比较好，当序列基本有序时用快排反而不好。
 */
public class QuickSort {
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
            int[] results = quick(a);

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

    private static int[] quick(int[] a) {
        quickSort(a,0,a.length-1);
        return a;
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low<high){
            int middle = getMiddle(a, low, high);
            quickSort(a,0,middle-1);
            quickSort(a,middle+1,high);
        }
    }

    private static int getMiddle(int[] a, int low, int high) {
        //基准元素
        int temp=a[low];
        while (low<high){
            while (low<high&&a[high]>=temp) high--;
            a[low]=a[high];
            while (low<high&&a[low]<=temp) low++;
            a[high]=a[low];
        }
        a[low]=temp;
        return low;

    }
}
