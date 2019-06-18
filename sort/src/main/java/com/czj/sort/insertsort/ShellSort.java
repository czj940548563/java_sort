package com.czj.sort.insertsort;

import java.util.Scanner;

/**
 * @Author: clownc
 * @Date: 2019-06-13 17:30
 * 希尔排序， 非稳定， 平均时间复杂度O（nlogn）
 * 5 9 3 6 1 7 8
 */
public class ShellSort {
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
            int[] results = shellSort(a);
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

    private static int[] shellSort(int[] a) {
      int d= a.length;
      while (true){
          d=d/2;//增量排序的增量d
          for (int x=0;x<d;x++){
              for (int i=x+d;i<a.length;i=i+d){//在每个组中进行直接插入排序
                  int temp=a[i];
                  int j;
                  for ( j=i-d;j>=0;j=j-d){
                      if(temp<a[j]){
                          a[j+d]=a[j];
                      }else break;
                  }
                  a[j+d]=temp;
              }
          }
          if(d==1) break;
      }
      return a;
    }
}
