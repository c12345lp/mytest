package test;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import dao.UserDao;
import enity.User;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Scanner;

public class testUserDao {
    public static final String SQLSTATE_23000 = "23000";
    public static void main(String[] args) {
//        User user = new UserDao().findUser("peter","123");
//        System.out.println("获取对象="+user);
//        int row = new UserDao().findUserByName("pete");
//        if (row == 1){
//            System.out.println("查询到");
//        }else {
//            System.out.println("未查询到");
//        }


        boolean flag = new UserDao().addUser("asd","1234");
        if (flag==true){
            System.out.println("添加成功");
        }else {
//            try{
                System.out.println("未添加成功");
//            }catch (Exception e){
//                System.out.println();
//                e.printStackTrace();
//
//            }
        }
    }
}
