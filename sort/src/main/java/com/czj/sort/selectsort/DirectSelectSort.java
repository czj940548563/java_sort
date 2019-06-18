package com.czj.sort.selectsort;

import java.util.Scanner;

/**
 * @Author: clownc
 * @Date: 2019-06-14 16:20
 * 简单的选择排序不是稳定的排序，时间复杂度O(n^2)
 */
public class DirectSelectSort {
    public static void main(String[] args) {
        //输入参数
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String inStr = in.nextLine();
            String[] str = inStr.split(" ");
            int a[] = new int[str.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            //输出结果
            int[] results = directSelectSort(a);
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < results.length; i++) {
                result.append(results[i]).append(",");
            }
            //删除最后一个逗号
            if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
            System.out.println(result);
        }
    }

    private static int[] directSelectSort(int[] a) {
        for (int i=0;i<a.length;i++){
            int min=a[i];//最小数
            int n=i;//最小数的下标
            for (int j=i+1;j<a.length;j++){
                if (a[j]<min){
                    min=a[j];
                    n=j;
                }
            }
            a[n]=a[i];
            a[i]=min;
        }
         return a;
    }
}
