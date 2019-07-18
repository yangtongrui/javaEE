<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
</HEAD>

<body>
<!--  -->
<form id="userAction_save_do" name="Form1" action="MedUpdateServlet" method="post">
	&nbsp;
	<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
				height="26">
				<strong>编辑药品</STRONG>
				</strong>
			</td>
		</tr>
		<c:forEach items="${medList}" var="med">
			<<input type="hidden" name="mid" value="${med.mid}">
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					药品名称：
				</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="mname" value="${med.mname}" id="mname" class="bg"/>
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					药品数量：
				</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="number" value="${med.number}" id="number" class="bg"/>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					药品价格：
				</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="price" value="${med.price}" id="price" class="bg"/>
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					生产日期：
				</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="date" name="pdata" value="${med.mdate}" id="pdata" class="bg"/>
				</td>

			</tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				药品描述：
			</td>
			<td class="ta_01" bgColor="#ffffff" colspan="3">
				<textarea name="function" value="" rows="5" cols="30">${med.function}</textarea>
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