package com.member.servlet;

import com.member.Dao.MemberDao;
import com.member.check.Check;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int ID = Integer.parseInt(request.getParameter("ID"));
        String Name = request.getParameter("Name");
        String Phone_number = request.getParameter("Phone_number");
        Check check = new Check();
        if(!check.isPhone(Phone_number)){
            response.sendRedirect("Phone_number_check.jsp");
        }
        else {
            MemberDao memberDao = new MemberDao();
            boolean flag = memberDao.updateMember(ID, Name, Phone_number);
            if (flag) {
                response.sendRedirect("allservlet");
            } else {
                response.sendRedirect("error.jsp");
            }
        }
    }
}
