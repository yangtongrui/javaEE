<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2019/6/20
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>普通药品</title>
    <script>

        function selectpriceBymid(mid) {
            var  str = document.getElementById("submit").value;
            window.location.href = "SelectpriceByMidServlet?mid="+mid+"&number="+str;
            /*alert(str);*/
        }
    </script>
    <%
        String allLogin = (String)request.getAttribute("allLogin");
        String s ="1";
        String res = "";
        String ress = "添加成功！";
        String ress1 = "添加失败！";
       /* System.out.println("alllogin"+allLogin);*/
        if(!"".equals(allLogin) && allLogin != null) {
            if ("1".equals(allLogin)) {
                res = "添加成功";
            }
            if ("0".equals(allLogin)) {
                res = "添加失败，生成缺药信息表";
            }
            PrintWriter pw = response.getWriter();
            pw.print("<script>alert('"+res+"'); </script>");

        }

    %>
</head>
<link href="css/med_show.css" rel="stylesheet" type="text/css">
<jsp:include page="/head.jsp"></jsp:include>
<body>
<div class="con">
<c:forEach items="${medList}" var="med">
        <ul>
            <li class = "table">
                <div class="d_nam">
                    ${med.mname}
                </div>
                <div class="d_number">
                    数量：${med.number}
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
                    <input id="submit" type="text" name="number" style="width: 20px">
                </div>
                <div class="ii">
                    <a href="#" onclick="selectpriceBymid('${med.mid}')">
                        <img src="img/gouwuche-.png" alt="" >
                    </a>
                    <a href="#" style="color: black"><span>加入购物车</span></a>
                </div>
            </li>
        </ul>

</c:forEach>
</div>
</body>
</html>
