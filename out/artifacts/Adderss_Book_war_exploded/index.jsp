<%--
  Created by IntelliJ IDEA.
  User: wxw10
  Date: 2022/1/5
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" deferredSyntaxAllowedAsLiteral="true"  pageEncoding="UTF-8" %>
<%@ page import="com.member.bean.Member" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>通讯录第二版</title>
  <style type="text/css">
    h1 {
      text-align: center;
    }

    body {
      background-color: antiquewhite;
    }

    th, td {
      width: 70px;
      height: 35px;
      text-align: center;
    }

    #before {
      text-align: center;
    }

  </style>
</head>
<body>
<%
  List<Member> memberList = (List<Member>) request.getAttribute("memberListx");
%>
<h1>通讯录</h1>
<hr/>

</div>
<br>
<table align="center" cellspacing="5">
  <tr bgcolor="#5f9ea0">
    <th>姓名</th>
    <th>电话</th>
    <th colspan="2">选项</th>
  </tr>
  <%
    for (int i = 0;i<memberList.size();i++){
      Member s =memberList.get(i);
  %>
  <tr>
    <td><%=s.getName()%></td>
    <td><%=s.getPhone_number()%></td>
    <td>
      <a href="update.jsp?ID=<%=s.getID()%>">编辑</a>
      <a href="deleteservlet?ID=<%=s.getID()%>">删除</a>
    </td>
  </tr>
  <%
    }
  %>
</table>
<table align="center">
  <tr>
    <td><a href="select.jsp">查找数据</a></td>
    <td><a href="add.jsp">添加数据</a></td>
  </tr>
</table>

</body>
</html>