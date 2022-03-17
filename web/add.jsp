<%--通讯录第一版
  Created by IntelliJ IDEA.
  User: wxw10
  Date: 2022/1/6
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>通讯录第一版</title>
    <style type="text/css">
        h1{
            text-align: center;
        }
        body{
            background-color: antiquewhite;
            text-align: center;
        }
        div{
            text-align: center;
        }
        #before{
            text-align: center;
        }
    </style>

</head>
<body>
<h1>新增页面</h1>
<div id="head">
    <table width="100%">
        <td align="center" id="headLink">
            <a href="allservlet">返回主页面</a>
        </td>
    </table>
</div>
<hr/>
<br>
<form action="addservlet" method="post" name="addForm">
    <div>
        <tr>
            <label>姓名：</label></td>
            <input type="text" name="Name" id="Name" placeholder="姓名">
        </tr>
    </div>
    <div>
        <tr>
            <label>电话：</label>
            <input type="text" name="Phone_number" id="Phone_number" placeholder="电话">
        </tr>
    </div>

    <br>
    <div id="submit">
        <tr>
            <button type="submit" onclick="return checkForm()">添加</button>
        </tr>
    </div>
</form>
<br>
<script type="text/javascript">
    function checkForm() {
        alert('数据已提交！');
        return true;
    }
</script>

</body>
</html>
