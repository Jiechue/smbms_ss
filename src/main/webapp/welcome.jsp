<%@page import="com.smbms.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> 
       <%--  <%
         Object obj=request.getAttribute("user");
         User user=(User)obj;
         
         String name=request.getParameter("userCode");
         
        
        %>
        <%=user.getUsername() %>
        <%=name %>
        <%
        
        %>
        --%>
        </span>${user.username}, 欢迎你！</p>
        <a href="login.html">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
<!-- 把left.jsp包含进来 -->
   <%@include file="left.jsp" %>
    
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath}/img/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>Admin</h2>
            <p>欢迎来到超市账单管理系统!</p>
        </div>
    </div>
</section>

<script src="${pageContext.request.contextPath}/js/time.js"></script>
</body>
</html>