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
    <link href="css/changemed.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>普药订单</title>
</head>
<jsp:include page="/head.jsp"></jsp:include>
<body>
<div class="con">
    <c:forEach items="${medList}" var="med">
        <ul>
            <li class = "table">

                <img src="${med.mimg}" alt="" class="d_img">
                <div class="d_nam" id="cmid">
                        ${med.mname}
                </div>
                <div class="d_fun" id="cmname">
                        ${med.function}
                </div>
                <div class="d_pri">
                    价格:${med.price}
                </div>
                <div class="d_num">
                    生产日期：${med.mdate}
                </div>
            </li>
        </ul>
    </c:forEach>
</div>
</body>
</html>
--
