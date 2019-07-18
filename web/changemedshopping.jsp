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
    <title>购物车</title>
    <script>
        function delchangeMedShopping(cmsid) {
            var b = confirm("您确定要删除吗？");
            if(b){
                window.location.href = "/ChangeMedShoppingdelServlet?cmsid="+cmsid;
            }
        }
        function ChangeMedsubmit() {
            window.location.href = "SubmitChangeMedServlet";

        }
    </script>
</head>
<link href="css/shopping.css" rel="stylesheet" type="text/css">
<jsp:include page="/head.jsp"></jsp:include>
<%
    double tatal = (double)request.getAttribute("total");
    String err = (String) request.getAttribute("res");
    if(!"".equals(err) && err != null){
        PrintWriter pw = response.getWriter();
        pw.print("<script>alert('"+err+"'); </script>");
    }


%>
<body>

<div class="con">
    <c:forEach items="${changemedList}" var="Changemed">

        <ul>
            <li class = "table">
                <div class="d_nam">
                    ${Changemed.cmname}
                </div>
                <div class="d_fun">
                    功效:${Changemed.function}
                </div>
                <div class="d_pri">
                    积分:${Changemed.credit}
                </div>
                <div class="d_num">
                    生产日期：${Changemed.cdate}
                </div>
                <div class="ii">
                    <a href="#" onclick="delchangeMedShopping('${Changemed.cmsid}')">
                    <img src="img/shanchu.png" alt=""></a>
                        <span>删除药品</span>
                </div>
            </li>
        </ul>
            </c:forEach>

        <div class="footer_d">
            <div class="much">共计:<%=tatal%>元</div>
            <%--<div class="ding" onclick="ChangeMedsubmit()">提交订单--%>
            <%--</div>--%>
            <div class="ding">
                <a href="SubmitChangeMedServlet?total=<%=tatal%>" style="color: #000">提交订单</a>
            </div>
</div>
</body>
</html>
