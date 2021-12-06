package dao;

import enity.Topic;
import tools.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* 查询所有 */
public class TopicDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Topic> findTopic() {
        List<Topic> list = new ArrayList<>();
        String sql = "Select * from topic;";
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Topic topic = new Topic(
                        rs.getString("tid"),
                        rs.getString("tname")
                );
                list.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

/* 查询名字值 */
    public List<Topic> findNewsByName(String tname){
        List<Topic> list = new ArrayList<>();
        conn = DaoFactory.getConn();
        try{
            ps = conn.prepareStatement("Select * from topic where tname=?;");
            ps.setString(1,tname);
            rs = ps.executeQuery();
            while (rs.next()){
                    Topic topic = new Topic(
                        rs.getString("tid"),
                        rs.getString("tname")
                );
                list.add(topic);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

/* 添加 */
    public boolean addTopic(String tname){
        boolean flag = false;
        conn = DaoFactory.getConn();
//        int rows = 0;
        try {
            ps = conn.prepareStatement("insert into topic(tname) value (?)");
            ps.setString(1,tname);
            flag = ps.executeUpdate()==1;
//            if (rows != 0){
//                flag = true;
//            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

/* 删除 */
    public boolean delTopic(String tid){
        boolean flag = false;
        conn = DaoFactory.getConn();
//        int rows = 0;
        try {
            ps = conn.prepareStatement("delete from topic where tid = ?");
            ps.setString(1,tid);
            flag = ps.executeUpdate()==1;
//            if (rows != 0){
//                flag = true;
//            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

/* 修改 */
public boolean upTopic(String tid,String tname){
    boolean flag = false;
    conn = DaoFactory.getConn();
//    int rows = 0;
    try {
        ps = conn.prepareStatement("update topic set tname = ? where tid = ?");
        ps.setString(1,tname);
        ps.setString(2,tid);
        flag = ps.executeUpdate()==1;
//        if (rows != 0){
//            flag = true;
//        }
    }catch (SQLException e){
        e.printStackTrace();
    }
    return flag;
}
}
