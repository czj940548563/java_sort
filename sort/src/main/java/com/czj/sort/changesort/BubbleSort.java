package com.czj.sort.changesort;

import java.util.Scanner;

/**
 * @Author: clownc
 * @Date: 2019-06-17 14:04
 * 冒泡排序  稳定排序 O(n^2)
 */
public class BubbleSort {
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
            int[] results = bubbleSort(a);

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

    private static int[] bubbleSort(int[] a) {
        for (int i=0;i<a.length;i++){
           for (int j=0;j<a.length-i-1;j++){
               if(a[j]>a[j+1]){
                   swap(a,j,j+1);
               }
           }
        }
        return a;
    }

    // 交换
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    }
