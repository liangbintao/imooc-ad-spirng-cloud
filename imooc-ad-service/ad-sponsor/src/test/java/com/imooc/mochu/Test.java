package com.imooc.mochu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @ClassName Test
 * @Description TODO 爬出魔厨科技的菜品名称
 * @Auther lbt
 * @Date 2019/3/19/019 10:36
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 5; i++) {

            System.out.println("----------------------第" + i + "页---------------------------");

            String url = "http://www.xiachufang.com/explore/rising/?page=" + i;

            reptileName(url);
        }
    }

    private static void reptileName(String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();

        //doc获取整个页面的所有数据
        Elements ulList = doc.select("ul[class='list']");
        Elements liList = ulList.select("li");

        // 循环liList的数据
        liList.stream().forEach(item -> {

            System.out.println(item.select("div[class='info pure-u']").select("p[class='name']").text());
        });
    }
}
