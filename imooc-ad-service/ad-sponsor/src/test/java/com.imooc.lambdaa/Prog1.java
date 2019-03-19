package com.imooc.lambdaa;

import java.util.Scanner;

public class Prog1 {
    public static void main(String[] args) {
        System.out.println("请输入一个大于2的正整数");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (fun(n))
            System.out.println(n + "是素数");
        else
            System.out.println(n + "不是素数");
    }

    public static boolean fun(int n) {

        boolean flag = true;

        for (int i = 2; i <= Math.sqrt(n); i++) { // 1,2,3
            System.out.println(n);
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}