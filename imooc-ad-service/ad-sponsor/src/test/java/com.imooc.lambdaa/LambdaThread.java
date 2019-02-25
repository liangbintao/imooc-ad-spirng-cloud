package com.imooc.lambdaa;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName LambdaThread
 * @Description TODO
 * @Auther lbt
 * @Date 2019/2/25/025 11:10
 * @Version 1.0
 */
public class LambdaThread {

    public static void main(String[] args) {

        streamTest();
    }

    public static void streamTest() {

        List<String> proNames = Arrays.asList("Ni", "Hao", "Lambda");

        List<String> lowercaseName = new ArrayList<>();

        lowercaseName = proNames.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());

        System.out.println(lowercaseName);
    }

    public static void sortTest() {

        List<String> list = Arrays.asList("b", "c", "a");
        // 匿名类写法
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("匿名内部类的方式：" + list);

        // Lambda表达式方式
        List<String> list1 = Arrays.asList("b", "c", "a");
        Collections.sort(list1, (str1, str2) -> str1.compareTo(str2));
        System.out.println("Lambda方式：" + list);
    }

    public static void threadTest() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("普通方式启动多线程");
            }
        });
        t.start();

        new Thread(() -> System.out.println("Lamdba方式启动多线程")).start();
    }
}
