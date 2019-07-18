<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2019/6/14
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>普药购物车</title>
</head>
<link href="css/shopping.css" rel="stylesheet" type="text/css">
<jsp:include page="/head.jsp"></jsp:include>
<script type="text/javascript">
    function delMedShopping(msid) {
        var b = confirm("您确定要删除吗？");
        if(b){
            window.location.href = "/MedShoppingdelServlet?msid="+msid;
        }
    }
</script>
<%
   double tatal = (double)request.getAttribute("total");
   request.setAttribute("credit",tatal);
    String err =(String) request.getAttribute("res");
    if(!"".equals(err) && err!=null){
        PrintWriter Out = response.getWriter();
        Out.print("<script>alert('"+err+"')</script>");
    }
%>
<body>
<div class="con">
  <c:forEach items="${medList}" var="med">
    <input type="hidden" name="mid" value="${med.mid}">
            <ul>
        <li class = "table">
            <div class="d_nam">
                ${med.mname}
            </div>
            <div class="d_fun">
                功效:${med.function}
            </div>
            <div class="d_pri">
                价格:${med.price}
            </div>
            <div class="d_num">
                生产日期：${med.mdate}
            </div>
            <div class="inp">
                <input type="text" style="width: 20px" name="msnumber" id="msnumber" value="${med.msnumber}">
                <%--<span id="medshopping_del"><a href="UpdateMedshoppingnumberServlet?mid=${med.mid}" style="color: #000;">修改</a></span>--%>
            </div>
            <div class="ii">
                <a href="#" onclick="delMedShopping('${med.msid}')">
                    <img src="img/shanchu.png" alt="" >
                </a>
                <span>删除药品</span>
            </div>
        </li>
    </ul>
    </c:forEach>

    <div class="footer_d">
        <div class="much">共计:<%=tatal%>元</div>
        <div class="ding">
            <a href="SubmitMedServlet?total=<%=tatal%>" style="color: #000">提交订单</a>
        </div>
</div>

</body>
</html>