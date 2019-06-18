package com.czj.sort.insertsort;

import java.util.Scanner;

/**
 * @Author: clownc
 * @Date: 2019-06-13 15:18
 * 直接插入排序 稳定排序  直接插入排序的平均时间复杂度为O(n^2)。
 * 5 9 3 6 1 7 8
 */
public class DirectInsertSort {
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
            int[] results = directInsertSort(a);
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


    /**
     * 每次遍历都与之前排序好的所有数再比较一遍
     * @param a
     * @return
     */
    private static int[] directInsertSort(int[] a) {
        for (int i=1;i<a.length;i++){
            // 待插入元素
            int temp= a[i];
            int j;
            for (j=i-1;j>=0;j--){
                // 将大于temp的往后移动一位
                if (a[j]>temp){
                    a[j+1]=a[j];
                }else break;
            }
            //后移完成后因为j多减了一次，所以插入位置为j+1
            a[j+1]=temp;
        }
        return a;
    }
}
