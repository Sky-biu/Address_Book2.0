<%--
  Created by IntelliJ IDEA.
  User: wxw10
  Date: 2022/1/7
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.member.bean.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="com.member.Dao.MemberDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>通讯录第一版</title>
    <style type="text/css">
        h1 {
            text-align: center;
        }

        body {
            background-color: antiquewhite;
            text-align: center
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
    request.setCharacterEncoding("UTF-8");
    int ID = Integer.parseInt(request.getParameter("ID"));
    MemberDao memberDao = new MemberDao();
    List<Member> memberList1 = memberDao.selectIDMember(ID);
    Member member = memberList1.get(0);
%>
    <h1>编辑页面</h1>
    <div id="head">
        <table width="100%">
            <td align="right" id="headLink">
                <a href="allservlet">返回主页面</a>
            </td>
        </table>
    </div>
    <hr/>
    <br>
    <form action="updateservlet" method="post" name="addForm" align="center">
        <div>
            <tr>

                <input type="hidden" name="ID" id="ID" placeholder="序号" value="<%=member.getID()%>">
            </tr>
        </div>
        <div>
            <tr>
                <label>姓名：</label></td>
                <input type="text" name="Name" id="Name" placeholder="姓名" value="<%=member.getName()%>">
            </tr>
        </div>
        <div>
            <tr>
                <label>电话：</label>
                <input type="text" name="Phone_number" id="Phone_number" placeholder="电话" value="<%=member.getPhone_number()%>">
            </tr>
        </div>
        <br>
        <div id="submit">
            <tr>
                <button type="submit" onclick="return checkForm()">修改</button>
            </tr>
        </div>
    </form>

<br>
    <script type="text/javascript">
        function checkForm() {
            alert('修改已提交！');
            return true;
        }
    </script>

</body>
</html>
