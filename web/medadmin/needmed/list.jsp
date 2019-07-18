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
        <script type="text/javascript">
        function delNeedMed(mid) {
            var b = confirm("您确定要删除吗？");
            if(b){
                window.location.href = "/NeedMeddelServlet?mid="+mid;
            }
        }

	</script>
</HEAD>
<body>
<br>
<form id="Form1" name="Form1"
	  action="${pageContext.request.contextPath}/user/list.jsp"
	  method="post">
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		   bgColor="#f5fafe" border="0">
		<TBODY>
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3"><strong>缺药信息列表</strong>
			</TD>
		</tr>
		<tr>
			<td class="ta_01" align="center" bgColor="#f5fafe">
				<table cellspacing="0" cellpadding="1" rules="all"
					   bordercolor="gray" border="1" id="DataGrid1"
					   style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
					<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

						<td align="center" width="18%">药品编号</td>
						<td align="center" width="17%">药品图片</td>
						<td align="center" width="17%">药品名称</td>
						<td align="center" width="17%">药品价格</td>
						<td align="center" width="17%">药品数量</td>
						<td width="7%" align="center">编辑</td>
						<td width="7%" align="center">删除</td>
					</tr>
					<c:forEach items="${needmedList}" var="med">
						<tr onmouseover="this.style.backgroundColor = 'white'"
							onmouseout="this.style.backgroundColor = '#F5FAFE';">
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="18%">${med.mid}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="17%"><img width="40" height="45" src="${med.mimg}"></td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="17%">${med.mname}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="17%">${med.price}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="17%">${med.number}</td>
							<td align="center" style="HEIGHT: 22px"  ><a
									href="${ pageContext.request.contextPath }SelectNeedMedServlet?mid=${med.mid}" >
								<img
										src="${pageContext.request.contextPath}/images/i_edit.gif"
										border="0" style="CURSOR: hand" >
							</a></td>
							<td align="center" style="HEIGHT: 22px"><a href="#" onclick="delNeedMed('${med.mid}');">
								<img
										src="${pageContext.request.contextPath}/images/i_del.gif"
										width="16" height="16" border="0" style="CURSOR: hand">
							</a></td>
						</tr>
					</c:forEach>

				</table>
			</td>
		</tr>

		</TBODY>
	</table>
</form>
</body>
</HTML>


