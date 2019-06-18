package com.czj.sort.insertsort;

import java.util.Scanner;

/**
 * @Author: clownc
 * @Date: 2019-06-13 16:30
 * 二分法插入排序 稳定，平均时间复杂度O（nlogn）
 */
public class DichotomyInsertSort {
    public static void main(String[] args) {
        // 输入参数
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String inStr = in.nextLine();
            String[] str = inStr.split(" ");
            int a[] = new int[str.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            // 调用方法得到数组
            int[] results = dichotomyInsertSort(a);

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

    /**
     *
     * @param a
     * @return
     * 先用二分查找法定位到该插入的位置，当left<=right时，left的下标则是应该查入的位置，然后将left以及它后面的数都后移一位，再把数插到left下标处
     */
    private static int[] dichotomyInsertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid=0;
            while (left<=right){
                mid=(right+left)/2;
                if (temp<a[mid]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            for (int j=i-1;j>=left;j--){
                a[j+1]=a[j];
            }
            if (left!=i){
                a[left]=temp;
            }
        }
        return a;
    }
}
