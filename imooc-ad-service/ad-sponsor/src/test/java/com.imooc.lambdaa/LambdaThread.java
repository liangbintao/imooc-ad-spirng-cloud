package com.imooc.lambdaa;

import org.assertj.core.util.Lists;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName LambdaThread
 * @Description TODO
 * @Auther lbt
 * @Date 2019/2/25/025 11:10
 * @Version 1.0
 */
public class LambdaThread {

    public static void main(String[] args) throws UnsupportedEncodingException {

        /*LambdaThread lt = new LambdaThread();

        lt.streamToFlatMap();*/

        String s = "中";

        byte[] bytes = s.getBytes("ISO-8859-1");

        String str = new String(bytes, "ISO-8859-1");

        System.out.println(str);
    }

    public void streamToFlatMap() {

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );

        inputStream.flatMap(childList -> childList.stream()).forEach(System.out::println);
    }

    /**
     * Stream 转 Map
     */
    public void streamToMap() {

        List<String> list = Arrays.asList("1", "2", "3", "2");

        list.stream().distinct().mapToLong(Long::valueOf).forEach(i -> {

            System.out.println(i);
        });

        // list.stream().mapToInt(Integer::valueOf).forEach(System.out::println);
    }

    /**
     * Stream 去重
     */
    public void streamToDistinct() {

        /*Stream<String> newStream = Stream.of("1", "2", "3", "1");

        newStream.distinct().forEach(System.out::println);*/

        List<String> list = Arrays.asList("1", "2", "3", "2");
        list.stream().distinct().forEach(System.out::println);
    }

    public void streamTest4() {

        // 创建Stream的第一种方式
        List<Integer> list = Stream.of(1, 2, 3).filter(i -> i <= 2).collect(Collectors.toList());

        // list.forEach(System.out::println);

        // 创建Stream的第二种方式
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });

        // 简写
        Stream.generate(() -> Math.random());
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }

    /**
     * 过滤特定的集合元素
     */
    public void streamTest3() {

        List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6);

        System.out.println("过滤前：" + nums);

        List<Integer> filterNums = nums.stream().filter(num -> num != null).collect(Collectors.toList());

        long count = nums.stream().filter(num -> num != null).count();

        System.out.println("过滤后：" + filterNums + " --- 元素个数：" + count);
    }

    public void whatThis() {

        List<String> proStrs = Arrays.asList("Ni", "Hao", "Lambda");

        List<String> execStr = proStrs.stream().map(str -> {
            System.out.println(this.getClass().getName());
            return str.toLowerCase();
        }).collect(Collectors.toList());

        // 遍历集合数据
        execStr.forEach(System.out::println);

        List<String> list = new ArrayList<>();
        proStrs.stream().forEach(i -> {
            list.add(i.toLowerCase());
        });
        // System.out.println("处理后的：" + list);
    }

    /**
     * 为列表中的字符串添加前缀字符串
     */
    public static void streamTest2() {

        String waibu = "lambda :";
        List<String> proStrs = Arrays.asList("Ni", "Hao", "Lambda");

        List<String> execStr = proStrs.stream().map(chuandi -> {
            Long zidingyi = System.currentTimeMillis();
            return waibu + chuandi + "------" + zidingyi;
        }).collect(Collectors.toList());

        execStr.forEach(i -> System.out.println(i));
    }

    public static void streamTest() {

        List<String> proNames = Arrays.asList("Ni", "Hao", "Lambda");

        List<String> lowercaseName = Collections.emptyList();

        // 第一种写法（单语句写法）
        // lowercaseName = proNames.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());

        // 第二种写法（方法引用写法）
        lowercaseName = proNames.stream().map(String::toLowerCase).collect(Collectors.toList());

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
