package com.czj.sort.selectsort;

import java.util.Scanner;

/**
 * @Author: clownc
 * @Date: 2019-06-14 16:37
 * 堆排序，不稳定排序，平均时间复杂度O(nlogn)
 */
public class HeapSort {
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
            int[] results = heapSort(a);
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

    private static int[] heapSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            //建堆
            buildMaxMap(a, a.length - 1 - i);
            //交换堆顶和最后一个元素
            swap(a, 0, a.length - 1 - i);
        }
        return a;
    }

    public static void buildMaxMap(int[] data, int lastIndex) {
        //从最后一个节点的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //保存当前判断的索引
            int k = i;
            //当前节点存在子节点
            while ((2 * k + 1) <= lastIndex) {
                //在k,k的子节点中找出他们的最大值，然后交换
                int biggerIndex = 2 * k + 1;
                //证明该父节点存在右子节点
                if (biggerIndex < lastIndex) {
                    if (data[biggerIndex] < data[biggerIndex+1]) {
                        //左节点值小于右节点，则最大节点索引为右节点的索引
                        biggerIndex++;
                    }
                }
                //父节点小于子节点，交换
                if (data[k] < data[biggerIndex]) {
                    swap(data, k, biggerIndex);
                } else break;

            }
        }
    }

    // 交换
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
