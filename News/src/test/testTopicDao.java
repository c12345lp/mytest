package test;


import dao.NewsDao;
import dao.TopicDao;
import enity.News;
import enity.Topic;

import java.util.List;

public class testTopicDao {
    public static void main(String[] args) {

        /* 查所有 */
//        List<Topic> li = new TopicDao().findTopic();
//        for (Topic tmp : li) {
//            System.out.println(tmp);
//        }

        /* 查标题 */
//        List<Topic> li2 = new TopicDao().findNewsByName("天气");
//        for (Topic tmp:li2){
//            System.out.println(tmp);
//        }

        /* 添加 */
        if(new TopicDao().addTopic("测试")){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }

        /* 删除 */
//        if(new TopicDao().delTopic("10")){
//            System.out.println("删除成功");
//        }else {
//            System.out.println("删除失败");
//        }

        /* 修改 */
//        if(new TopicDao().upTopic("11","测试3")){
//            System.out.println("修改成功");
//        }else {
//            System.out.println("修改失败");
//        }
    }
}
