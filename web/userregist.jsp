<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="${pageContext.request.contextPath }css/general.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }css/main.css" rel="stylesheet" type="text/css" />

    <style type="text/css">
        body {
            color: white;
        }
    </style>
</head>
<%
    String err =(String) request.getAttribute("res");
    if(!"".equals(err) && err!=null){
        PrintWriter Out = response.getWriter();
        Out.print("<script>alert('"+err+"')</script>");
        }
%>
<body style="background: #278296">
<center></center>
<form method="post" action="userRegistServlet" target="_parent" name='theForm' onsubmit="check()">
    <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
        <tr>
            <td style="padding-left: 50px">
                <table>
                    <tr>
                        <td>用户姓名：</td>
                        <td><input type="text"  placeholder="请输入姓名" name="name"  id="name"/></td>
                    </tr>
                    <tr>
                        <td>用户密码：</td>
                        <td><input type="password"  placeholder="请输入密码" name="password" id="password" /></td>
                    </tr>
                    <tr>
                        <td>密码确认：</td>
                        <td><input type="password"   placeholder="请再次输入密码" name="userpassword" id="repassword"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;</td></td> <td ><input type="submit" name ="提交"/></td>
                        <td><input type="reset" name ="重置"/></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
<script language="JavaScript">
    <!--
    document.forms['theForm'].elements['username'].focus();

    /**
     * 检查表单输入的内容
     */
    function validate()
    {
        var validator = new Validator('theForm');
        validator.required('username', user_name_empty);
        //validator.required('password', password_empty);
        if (document.forms['theForm'].elements['captcha'])
        {
            validator.required('captcha', captcha_empty);
        }
        return validator.passed();
    }

    //-->
</script>
</body>
