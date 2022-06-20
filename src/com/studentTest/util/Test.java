package com.studentTest.util;

import com.studentTest.bean.User;
import com.studentTest.dao.LoginDaoImpl;

public class Test {
    public static void main(String[] args) {
        int id=1001;
        String pwd="a11";
        User u = new User();
        u.setU_id(id);
        u.setU_pwd(pwd);
        LoginDaoImpl l = new LoginDaoImpl();
        User retUse = l.logindao(u);
        if(retUse!=null){
            /*
            * 不为空 说明账户和密码是一致的，
            * */
            System.out.println(retUse.toString());
            System.out.println("账户和密码一致");
        }else{
            /*
            * 否则账户和密码有误
            * */
            System.out.println("账户和密码不一致");
        }

    }
}
