<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2019/6/13
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/img/校徽.png" rel="icon">
    <meta charset="UTF-8">
    <title>药品管理系统</title>
</head>
<link href="/css/style1.css" rel="stylesheet" type="text/css">
<link href="/css/menu.css" rel="stylesheet">
<style>
    #container img{
        width: 880px;
        height: 360px;
    }
</style>
<%
    String err =(String) request.getAttribute("res");
    if(!"".equals(err) && err!=null){
        PrintWriter Out = response.getWriter();
        Out.print("<script>alert('"+err+"')</script>");
    }
%>
<body>
<jsp:include page="/head.jsp"></jsp:include>
<div id="container" class="clearfix">
    <img src="/image/zuomian/y1.png" class="select">
    <img src="/image/zuomian/y2.jpg">
    <img src="/image/zuomian/y3.jpg">
    <ul id="tab-1">
        <li id="prev">&lt</li>
        <li id="next">&gt</li>
    </ul>
    <ul id="tab-2">
        <li>1</li>
        <li>2</li>
        <li>3</li>
    </ul>
    <div class="wrap">
        <div class="container-list ">
            <ul id="container-list-box">
                <li><a href= "/SelectMedByTypeServlet?pid=1">感冒</a></li>
                <li><a href="/SelectMedByTypeServlet?pid=2">退烧</a></li>
                <li><a href="/SelectMedByTypeServlet?pid=3">咳嗽</a></li>
                <li><a href="/SelectMedByTypeServlet?pid=4">口腔溃疡</a></li>
                <li><a href="/SelectMedByTypeServlet?pid=5">肠胃不适</a></li>
                <li><a href="/SelectMedByTypeServlet?pid=6">皮肤瘙痒</a></li>
                <li><a href="/SelectMedByTypeServlet?pid=7">跌打外伤</a></li>
                <li><a href="/SelectMedByTypeServlet?pid=8">缓解疼痛</a></li>
                <li><a href="/SelectMedByTypeServlet?pid=9">晕车晕船</a></li>
            </ul>
        </div>
    </div>
</div>
<jsp:include page="/foot.jsp"></jsp:include>
</body>
</html>