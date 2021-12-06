package tools;

import java.sql.*;

public class DaoFactory {
        static PropertiesManager pro = PropertiesManager.getInstance();
        private static String driver = pro.getString("jdbc.driver_class");
        private static String url = pro.getString("jdbc.connection.url");
        private static String username = pro.getString("jdbc.connection.username");
        private static String password = pro.getString("jdbc.connection.password");
        private static Connection conn = null;
    public static Connection getConn(){
            //属性文件（Database.properties）配置
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(
                    url,username,password
            );



            //原有配置方法，数据源（JNDI(Java Naming and Directory Inferface)）见qqzone
/*            Class.forName("com.mysql.jdbc.Driver");//5.X版本的mysql
//			Class.forName("com.mysql.cj.jdbc.Driver");//8.0版本的mysql
            conn = DriverManager.getConnection(   //原存在类型转换(Connection)
                    "jdbc:mysql://localhost:3306/news?"
                            + "useUnicode=true&characterEncoding=utf-8"
                            + "&useSSL=false&serverTimezone=Asia/Shanghai",
                    "root",
                    "123456");*/
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void closeConn(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
