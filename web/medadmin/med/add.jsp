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
<form id="userAction_save_do" name="Form1" action="MedaddServlet" method="post" >
	&nbsp;
	<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
				height="26">
				<strong><STRONG>添加药品</STRONG>
				</strong>
			</td>
		</tr>

		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				药品名称：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<input type="text" name="mname" value="" id="mname" class="bg"/>
			</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				药品数量：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<input type="text" name="number" value="" id="number" class="bg"/>
			</td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				药品价格：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<input type="text" name="price" value="" id="price" class="bg"/>
			</td>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				生产日期：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<input type="date" name="pdate" value="" id="pdata" class="bg"/>
			</td>

		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				所属分类：
			</td>
			<td class="ta_01" bgColor="#ffffff" colspan="3">
				<select name="pid">
					<c:forEach items="${med_typeList}" var="med_type">
						<option value="${med_type.pid}">${med_type.pname}</option>
					</c:forEach>

				</select>
			</td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				药品描述：
			</td>
			<td class="ta_01" bgColor="#ffffff" colspan="3">
				<textarea name="function" rows="5" cols="30"></textarea>
			</td>
		</tr>
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



