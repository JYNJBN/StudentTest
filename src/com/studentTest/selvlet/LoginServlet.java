package com.studentTest.selvlet;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;
import com.studentTest.service.loginService;
import com.studentTest.service.loginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
* 这个注解就是我们起的名字，为了让前端的页面来访问
* */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u_id=req.getParameter("u_id");
        String u_pwd = req.getParameter("u_pwd");
        User u = new User();
        u.setU_id(Integer.valueOf(u_id));
        u.setU_pwd(u_pwd);

        //实现登录服务层的业务逻辑层
        loginService l = new loginServiceImpl();
        User user=l.loginService(u);
        /*
        * 如果user为空  就说明账户和密码不一致 就跳转到登陆界面
        *
        * 如果不为空  账户和密码一致  这就跳转到主界面
        *
        * */
        if(user!=null){

            /*
            * 获取Arr对象
            * */
            FileService fs = new FileServiceImpl();
            ArrayList<User> arr = fs.getAllStudent();

            req.setAttribute("user",user);
            req.setAttribute("arr",arr);

            if(user.getRole() == 1){
                ArrayList<Major> studentUser = fs.getPersonFile(String.valueOf(user.getU_id()));
                req.setAttribute("arr",studentUser);
                req.getRequestDispatcher("stuPage.jsp").forward(req,resp);
            }
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        }else {
            req.setAttribute("error","账户和密码不一致!");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        System.out.println("账户:"+u.getU_id()+"   密码:"+u.getU_pwd());
    }
}
