package com.studentTest.selvlet;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/del")
public class Delete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
         * "del?v="+v+"&id=${user.getU_id()}";
         * */
        //首先拿到前端传过来的值
        //管理员账号
        String adm = req.getParameter("id");
        //要删除的那个人的信息
        String stu = req.getParameter("v");
        //开始访问服务层
        FileService fs = new FileServiceImpl();
        fs.del(stu);
        /*
        * 获取两个 值
        * 管理员信息对象
        * 所有学生对象
        * */

        //获取管理员信息
        User admUser = fs.getAdmine(adm);
        //所有学生对象
        ArrayList<User> arr = fs.getAllStudent();
        req.setAttribute("user",admUser);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
    }
}
