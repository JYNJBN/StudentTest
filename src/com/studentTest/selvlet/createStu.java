package com.studentTest.selvlet;

import com.studentTest.bean.Course;
import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
* "upStu?admId=${admId}&stuId=${stuId}&a="+a+"&b="+b+"&c="+c+"&d="+d;
* */
@WebServlet("/createStu")
public class createStu extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admId = req.getParameter("admId");
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        System.out.println(admId+a+"  "+b);
        FileService fs = new FileServiceImpl();
        int user_id = fs.createStu(a,b);
        ArrayList<Course> courseArr = fs.getAllCourse();

        for (Course item:courseArr) {
                fs.insertScore(user_id,item.getId(),0);
        }
            /*
        * 修改数据工作完毕
        * 在这里呢就是返回前端界面
        * */
        User user = fs.getAdmine(admId);
        ArrayList<User> arr = fs.getAllStudent();
        req.setAttribute("user",user);
        req.setAttribute("admId",admId);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);


    }
}
