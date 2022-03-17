<%--
  Created by IntelliJ IDEA.
  User: wxw10
  Date: 2022/2/15
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//CN">
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
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript">
        var xmlHttp;
        function createXMLHttpRequest(){
            if(window.ActiveXObject){
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }else if(window.XMLHttpRequest){
                xmlHttp=new XMLHttpRequest();
            }
        }
        function searchPerson(Name){
            createXMLHttpRequest();
            var queryString="ajaxselect?Name="+Name;
            xmlHttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    myFunction(this);
                }
            };
            xmlHttp.open("GET",queryString,true);
            xmlHttp.send(null);
        }

        function myFunction(xml) {
            var i;
            var xmlDoc = xml.responseXML;
            var x = xmlDoc.getElementsByTagName("person");
            if(x.length == 0){
                var table = "<tr>没有查询到任何数据</tr>";
            }
            else{
                var table="<tr bgcolor=\"#5f9ea0\"><th>姓名</th><th>电话</th><th colspan=\"3\">选项</th></tr>";
                for (i = 0; i <x.length; i++) {
                    table += "<tr><td>" +
                        x[i].getElementsByTagName("pname")[0].childNodes[0].nodeValue +
                        "</td><td>" +
                        x[i].getElementsByTagName("phone")[0].childNodes[0].nodeValue +
                        "</td><td><a href=\"update.jsp?ID=" +
                        x[i].getElementsByTagName("pid")[0].childNodes[0].nodeValue +
                        "\">编辑</a><a>" +
                        " " +
                        "</a><a href=\"deleteservlet?ID="+
                        x[i].getElementsByTagName("pid")[0].childNodes[0].nodeValue +
                        "\">删除</a></td></tr>";
                }
            }
            document.getElementById("mytable").innerHTML = table;
        }
    </script>
</head>
<body>
<h1>通讯录</h1>
<div id="head">
    <table width="100%">
        <td align="right" id="headLink">
            <a href="allservlet">返回主页面</a>
        </td>
    </table>
</div>
<hr/>
<div id="before">
    <p><input type="text" id="txt1" placeholder="输入姓名进行查找" onkeyup="searchPerson(this.value)"></p>
    <p>欢迎使用通讯录查找功能</p>
</div>
<br>

<table align="center" id="mytable" cellspacing="5">

</table>
</body>
</html>
