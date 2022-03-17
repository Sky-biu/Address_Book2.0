package com.member.servlet;

import com.member.Dao.MemberDao;
import com.member.check.Check;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addservlet")
public class addservlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String Name = request.getParameter("Name");
        String Phone_number = request.getParameter("Phone_number");
        Check check = new Check();
        if(!check.isPhone(Phone_number)){
            response.sendRedirect("Phone_number_check.jsp");
        }//正则表达式用于检查字符串有效性
        else{
            MemberDao memberDao = new MemberDao();
            boolean flag = memberDao.addMember(Name,Phone_number);
            if(flag){
                response.sendRedirect("allservlet");
            }else{
                response.sendRedirect("error.jsp");
            }
        }
    }
}
