<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.html">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList.html">账单管理</a></li>
                <li ><a href="providerList.html">供应商管理</a></li>
                <li id="active"><a href="userList.html">用户管理</a></li>
                <li><a href="password.html">密码修改</a></li>
                <li><a href="login.html">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="#" method="post">
            
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label>用户名称：</label>

                    <span >${u.username}</span>
                </div>

                <div>
                    <label >用户性别：</label>
                     <span>
                         <c:if test="${u.gender==1}">女</c:if>
                         <c:if test="${u.gender==2}">男</c:if>
                     </span>
                </div>
                <div>
                    <label>出生日期：</label>
                    <span >${u.birthday }</span>
                </div>
                <div>
                    <label>用户电话：</label>

                    <span >${u.phone }</span>
                </div>
                <div>
                    <label>用户地址：</label>
                   <span>${u.address }</span>
                </div>
                <div>
                    <label >用户类别：</label>
                    <span>
                        <c:choose>
                            <c:when test="${userrole==1}">超级管理员</c:when>
                            <c:when test="${userrole==2}">经理</c:when>
                            <c:otherwise>普通员工</c:otherwise>
                        </c:choose>
                    </span>

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->

                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>

<script src="js/time.js"></script>

</body>
</html>