package com.member.servlet;

import com.member.Dao.MemberDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteservlet")
public class deleteservlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int ID = Integer.parseInt(request.getParameter("ID"));

        MemberDao memberDao = new MemberDao();
        boolean flag = memberDao.deleteMember(ID);
        if(flag){
            response.sendRedirect("allservlet");
        }else{
            response.sendRedirect("error.jsp");
        }

    }

}
