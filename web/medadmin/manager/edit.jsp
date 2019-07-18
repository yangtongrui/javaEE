<%@ page import="med_table.user_d" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
</HEAD>


<body>
<form id="userAction_save_do" name="Form1" action="ManagerUpdateServlet" method="post">
	<input type="hidden" name="method" value="save">

	&nbsp;
	<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
				height="26">
				<strong><STRONG>修改权限</STRONG>
				</strong>
			</td>
		</tr>
<c:forEach items="${user_dList}" var="user_d">
		<input type="hidden" name = "id" value="${user_d.id}">
		<input type="hidden" name = "id" value="${user_d.credit}">
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				用户名：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<input type="text" name="name" value= "${user_d.name}" class="bg"/>
			</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				修改权限：
			</td>
			<td width="20%" class="ta_01" bgColor="#ffffff">
				<select name="sign" id="sign">
					<option ><c:if test="${user_d.sign == 1}">会员</c:if>
						<c:if test="${user_d.sign != 1}">非会员</c:if></option>
					<option>会员</option>
					<option>非会员</option>
				</select>
			</td>
		</tr>
</c:forEach>
		<tr>
			<td class="ta_01" style="WIDTH: 100%" align="center"
				bgColor="#f5fafe" colSpan="4">
				<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
					&#30830;&#23450;
				</button>

				<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
				<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

				<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
				<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
				<span id="Label1"></span>
			</td>
		</tr>

	</table>
</form>
</body>
</HTML>