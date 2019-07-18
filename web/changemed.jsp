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
    <link href="css/changemed.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>换购药品</title>
    <script>

        function AddBycmid(cmid) {
            window.location.href = "AddChangemedShopingServlet?cmid="+cmid;
            /*alert(str);*/
        }
    </script>

</head>
<jsp:include page="/head.jsp"></jsp:include>
<body>
<div class="con">
<c:forEach items="${changemedList}" var="Changemed">
        <ul>
            <li class = "table">

                <img src="${Changemed.cimg}" alt="" class="d_img">
                <div class="d_nam" id="cmid">
                      ${Changemed.cmname}
                </div>
                <div class="d_fun" id="cmname">
                        ${Changemed.function}
                </div>
                <div class="d_pri">
                    积分:${Changemed.credit}
                </div>
                <div class="d_num">
                    生产日期：积分:${Changemed.cdate}
                </div>
                <div class="ii">
                    <a href="#"  onclick="AddBycmid('${Changemed.cmid}')">
                        <img src="img/gouwuche-.png" alt="" >
                    </a>
                    <a href="#" style="color: black"><span>加入购物车</span></a>
                </div>
            </li>
        </ul>
</c:forEach>
<%----%>
</div>
</body>
</html>
--