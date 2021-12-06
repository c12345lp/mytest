package test;

import dao.NewsDao;
import enity.News;

import java.util.List;

public class TestNewsDao {
    public static void main(String[] args) {
        List<News> li = new NewsDao().findNews();
        for (News news:li){
            System.out.println(news);
        }

        List<News> li2 = new NewsDao().findIdNews("1");
        for (News news:li2){
            System.out.println(news);
        }

        int us = new NewsDao().totalCount();
        System.out.println("us="+us);

        List<News> li3 = new NewsDao().getPageNewsList(1,2);
        for (News news:li3){
            System.out.println(news);
        }
    }

}
