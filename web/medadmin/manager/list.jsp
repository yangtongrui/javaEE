<%@ page import="med_table.user_d" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/css/Style1.css"
		  rel="stylesheet" type="text/css" />
	<script language="javascript"
			src="${pageContext.request.contextPath}/js/public.js"></script>
	<script>
        function delMed(name) {
            var b = confirm("您确定要删除吗？");
            if(b){
                window.location.href = "/UserdelServlet?name="+name;
            }
        }
	</script>

</HEAD>
<body>
<br>
<table cellSpacing="1" cellPadding="0" width="100%" align="center"
	   bgColor="#f5fafe" border="0">
	<TBODY>
	<tr>
		<td class="ta_01" align="center" bgColor="#afd1f3"><strong>分类列表</strong>
		</TD>
	</tr>
		<td class="ta_01" align="center" bgColor="#f5fafe">
			<table cellspacing="0" cellpadding="1" rules="all"
				   bordercolor="gray" border="1" id="DataGrid1"
				   style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
				<tr
						style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

					<td align="center" width="18%">用户名</td>
					<td align="center" width="17%">用户积分</td>
					<td align="center" width="17%">用户权限</td>
					<td width="7%" align="center">编辑</td>
					<td width="7%" align="center">删除</td>
				</tr>
				<c:forEach items="${managerList}" var="user_d">
					<<input type="hidden" name="id" value="${user_d.id}">
					<tr onmouseover="this.style.backgroundColor = 'white'"
						onmouseout="this.style.backgroundColor = '#F5FAFE';">
						<td style="CURSOR: hand; HEIGHT: 22px" align="center"
							width="18%">${user_d.name}</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center"
							width="18%">${user_d.credit}</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center"
							width="18%"><c:if test="${user_d.sign == 1}">会员</c:if>
							<c:if test="${user_d.sign != 1}">非会员</c:if></td>
					<%--<tr>
						<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
							用户权限：
						</td>
						<td class="ta_01" bgColor="#ffffff" colspan="3">
							<select name="sign">
								<c:if test="${user_d.sign == 1}">会员</c:if>
								<c:if test="${user_d.sign != 1}">非会员</c:if>
							</select>
						</td>
					</tr>--%>

						<td align="center" style="HEIGHT: 22px"><a
								href="${ pageContext.request.contextPath }InsertManagerServlet?id=${user_d.id}">
							<img
									src="${pageContext.request.contextPath}/images/i_edit.gif"
									border="0" style="CURSOR: hand">
						</a></td>

						<td align="center" style="HEIGHT: 22px"><a
								href="#" onclick="delMed('${user_d.name}');">
							<img src="${pageContext.request.contextPath}/images/i_del.gif"
								 width="16" height="16" border="0" style="CURSOR: hand">
						</a></td>
					</tr>
				</c:forEach>

			</table>
		</td>
	</tr>
	</TBODY>
</table>
</body>
</HTML>


