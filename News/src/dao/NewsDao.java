package dao;

import enity.News;
import tools.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    List<News> list = new ArrayList<>();
    Connection conn = DaoFactory.getConn();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    public List<News> findNews(){
        String sql = "Select * from news;";
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                News news = new News(
                        rs.getString("nId"),
                        rs.getString("nTid"),
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary")

                );
                list.add(news);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }



    public List<News> findIdNews(String nTid){
        String sql = "Select * from news where nTid=?;";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,nTid);
            rs = ps.executeQuery();
            while (rs.next()){
                News news = new News(
                        rs.getString("nId"),
                        rs.getString("nTid"),
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary")

                );
                list.add(news);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public int totalCount(){
        int count = 0;
        try{
            sql = "select count(*) from news";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }


    public List<News> getPageNewsList(int currPageNo,int pageSize){
        String sql = "Select * from news limit "+(currPageNo-1)*pageSize+","+pageSize;
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                News news = new News(
                        rs.getString("nId"),
                        rs.getString("nTid"),
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary")

                );
                list.add(news);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


}













