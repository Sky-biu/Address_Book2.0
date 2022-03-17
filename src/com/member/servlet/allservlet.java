package com.member.servlet;

import com.member.Dao.MemberDao;
import com.member.bean.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allservlet")
public class allservlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        MemberDao memberDao = new MemberDao();
        List<Member> memberList2 = memberDao.selectAll();
        request.setAttribute("memberListx", memberList2);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

