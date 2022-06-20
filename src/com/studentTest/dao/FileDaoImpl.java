package com.studentTest.dao;

import com.studentTest.bean.Course;
import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class FileDaoImpl implements FileDao{

    /*
    * 获取所有的信息代码就完成了！
    *
    * */
    @Override
    public ArrayList<User> getAllStudent() {
        ArrayList<User> arr = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT * FROM u_user WHERE u_role=1 AND u_isdelete=0";

        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            /*
             * 如果信息正确->返回来一条数据
             * 如果信息错误->返回null
             *
             * */
            while (res.next()){
                User user = new User();
                user.setU_id(res.getInt("u_id"));
                user.setU_name(res.getString("u_name"));
                user.setU_pwd(res.getString("u_pwd"));
                user.setU_phone(res.getString("u_phone"));
                user.setRole(res.getInt("u_role"));
                user.setRole(res.getInt("u_isdelete"));
                arr.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public User getFileByNameOrId(String v) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT * FROM u_user WHERE u_name='"+v+"'";

        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            /*
             * 如果信息正确->返回来一条数据
             * 如果信息错误->返回null
             *
             * */
            while (res.next()){
                User user = new User();
                user.setU_id(res.getInt("u_id"));
                user.setU_name(res.getString("u_name"));
                user.setU_pwd(res.getString("u_pwd"));
                user.setU_phone(res.getString("u_phone"));
                user.setRole(res.getInt("u_role"));
                user.setRole(res.getInt("u_isdelete"));
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getAdmine(String id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT * FROM u_user WHERE u_id="+id;
        System.out.println(sql);

        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            /*
             * 如果信息正确->返回来一条数据
             * 如果信息错误->返回null
             *
             * */
            while (res.next()){
                User user = new User();
                user.setU_id(res.getInt("u_id"));
                user.setU_name(res.getString("u_name"));
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList getPersonFile(String studentId) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT c_name courseName,c_score score FROM" +
                " course a,userchoose b WHERE a.c_id=b.c_id AND b.u_id="+studentId;
        System.out.println(sql);
        ArrayList<Major> arr = new ArrayList<>();
        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            /*
             * 如果信息正确->返回来一条数据
             * 如果信息错误->返回null
             *
             * */

            while (res.next()){
                Major m = new Major();
                m.setA(res.getString("courseName"));
                m.setB(res.getString("score"));
                arr.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return arr;

    }

    @Override
    public void del(String stu) {
        /*
        * 要查询：询问一类的(kind):res = pre.executeQuery();
        * 增加  删除  修改 (kind) 这三个都是属于更新类的   pre.executeUpdate();
        * */

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql1 = "DELETE FROM u_user WHERE u_id="+stu;
        String sql2 = "DELETE FROM userchoose WHERE u_id="+stu;
        try {
            pre = connection.prepareStatement(sql1);
            pre.executeUpdate();
            pre = connection.prepareStatement(sql2);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void upScore(String stuId, String a, String b, String c, String d) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        String[] file = {a,b,c,d};//4
        int index=0;
        try {
            for(int i=1001;i<=1004;i++){
                String sql = "UPDATE userchoose SET c_score = "+file[index]+" WHERE u_id="+stuId+" AND c_id="+i;
                index++;
                pre = connection.prepareStatement(sql);
                pre.executeUpdate();
            }

            /*pre = connection.prepareStatement(sql1);
            pre.executeUpdate();
            pre = connection.prepareStatement(sql2);
            pre.executeUpdate();*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertScore(int u_id, String c_id, int c_score) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        try {
            String sql = "INSERT INTO userchoose(u_id,c_id,c_score) VALUES ("+u_id+","+c_id+","+c_score+")";
            System.out.println(sql);
            pre = connection.prepareStatement(sql);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int createStu(String name, String phone) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        int index=0;
        try {
            String sql = "INSERT INTO u_user(u_pwd,u_phone,u_role,u_isdelete,u_name) VALUES ('123456',"+phone+",1,0,"+"'"+name+"'"+")";
            System.out.println(sql);
            index++;
            pre = connection.prepareStatement(sql,RETURN_GENERATED_KEYS);
            pre.executeUpdate();
            /*pre = connection.prepareStatement(sql1);
            pre.executeUpdate();
            pre = connection.prepareStatement(sql2);
            pre.executeUpdate();*/
            ResultSet rs=pre.getGeneratedKeys();
            rs.next();
            int userno= rs.getInt(1);
            System.out.println("插入用户id："+userno);
            return userno;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public ArrayList<Course> getAllCourse() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        int index=0;
        ArrayList<Course> arr = new ArrayList<>();
        try {
            String sql = "SELECT * FROM course";
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            /*
             * 如果信息正确->返回来一条数据
             * 如果信息错误->返回null
             *
             * */

            while (res.next()){
                Course m = new Course();
                m.setC_name(res.getString("c_name"));
                m.setId(res.getString("c_id"));
                m.setC_teacher(res.getString("c_teacher"));
                arr.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;
    }


    public void ins(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句

        try {
            pre = connection.prepareStatement(sql);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
