package com.studentTest.selvlet;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* "upTo?stuId="+v+"&admId=${user.getU_id()}";
* */
@WebServlet("/upTo")
public class ToUp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String admId = req.getParameter("admId");
        String stuId = req.getParameter("stuId");
        FileService fs = new FileServiceImpl();
        /*
        * 跳到修改界面
        *admId  stuId
        * */
        User user = fs.getAdmine(admId);
        req.setAttribute("admId",admId);
        req.setAttribute("stuId",stuId);
        req.setAttribute("user",user);
        req.getRequestDispatcher("upPage.jsp").forward(req,resp);
    }
}
