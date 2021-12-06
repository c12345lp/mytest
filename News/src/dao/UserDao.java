package dao;

import enity.User;
import tools.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    Connection conn = DaoFactory.getConn();
    PreparedStatement ps = null;
    ResultSet rs = null;
    public  User findUser(String username, String upwd){
        User user = null;
        String sql = "select * from news_user where username=? and upwd=?";

        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,upwd);
            rs = ps.executeQuery();
            while (rs.next()){
                user = new User();
//                user.setUid(rs.getString("uid"));
                user.setUsername(rs.getString("username"));
                user.setUpwd(rs.getString("upwd"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public int findUserByName(String username){
        String sql = "select * from news_user where username=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()){
                return 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public boolean addUser(String username, String upwd){
        boolean flag = false;
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("insert into news_user(username,upwd) VALUES(?,?);");
            ps.setString(1,username);
            ps.setString(2,upwd);
            flag = ps.executeUpdate()==1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    //            User user = new User();
//            user.setUsername(username);
//            user.setUpwd(upwd);
//            HttpSession session = request.getSession();
//            session.setAttribute("loginUser",user);
}
