<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="/css/style1.css" rel="stylesheet" type="text/css">
<link href="/css/menu.css" rel="stylesheet">
<%
    String mid = (String)request.getAttribute("mid");
    String username = (String)session.getAttribute("username");
    String cre = "";
    if(session.getAttribute("credit") != null){
        cre = session.getAttribute("credit").toString();
    }

    if(("").equals(username) || username == null){
        username = "未登录";
    }

if("".equals(username)||username == null) {
    String res = "您还未登录，请先登录！";
    request.setAttribute("res", res);
    request.getRequestDispatcher("userlogin.jsp").forward(request, response);
}
%>
<div id="header" >
    <div id="header-content"class="wrap">
        <p>欢迎来到药品管理系统!</p>
        <ul>
            <li>English|</li>
            <li>한국어|</li>
            <li> 信息门户|</li>
            <li>应用门户</li>
            <li ><a href="userlogin.jsp" style="color: #28a4c9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户登录</a> </li>
            <li ><a href="#" style="color: #28a4c9">&nbsp;&nbsp;&nbsp;用户名：<%=username%>&nbsp; 积分：<%=cre%> </a> </li>
            <li ><a href="medadmin/login.jsp" style="color: #28a4c9">&nbsp;&nbsp;&nbsp;管理员登录</a> </li>
        </ul>
    </div>
    <div id="img" style="width: 1520px" align="center">
        <img src="img/header.png">
    </div>
</div>
<div id="nav">
    <div id="nav-content" class="wrap">
        <div class="nav-left ">
            <h1><a href="index.jsp">全部分类</a></h1>
        </div>
        <div class="clearfix">
            <ul class="nav-center ">
                <li><a href="ChangemedServlet">换购药品</a> </li>
                <li><a href="MedshoppingServlet">普药购物车</a></li>
                <li><a href="ChangeMedshoppingServlet">换药购物车</a></li>
                <li><a href="U_MMedServlet">普药订单</a></li>
                <li><a href="U_MChangeMedServlet">换药订单</a></li>
            </ul>
        </div>
    </div>
</div>
