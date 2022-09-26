<%@page import="com.smbms.pojo.User"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
       <%@include file="left.jsp" %>
      
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <form action="${pageContext.request.contextPath}/user/ad">
                <span>用户名：</span>
                <input type="text" placeholder="请输入用户名"/>
                <input type="submit" value="查询"/>
                <a href="${pageContext.request.contextPath}/useradd.jsp">添加用户</a>
            </form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                 <c:forEach items="${userList }" var="user">
                  <tr>
                   <td>${user.usercode }</td>
                    <td>${user.username }</td>
                     <td>${user.gender }</td>
                      <td>${user.birthday }</td>
                       <td>${user.phone }</td>
                        <td>
                           <c:if test="${user.userrole==1}">系统管理员</c:if>
                            <c:if test="${user.userrole==2}">经理</c:if>
                            <c:if test="${user.userrole==3}">普通员工</c:if>
                        </td>
                        
                         <td>
                        <a href="${pageContext.request.contextPath}/user/show?id=${user.id }"><img src="${pageContext.request.contextPath}/img/read.png" alt="查看" title="查看"/></a>
                        <a href="${pageContext.request.contextPath}/user/find?id=${user.id }"><img src="${pageContext.request.contextPath}/img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="javascript:void(0)" class="removeUser" id="${user.id}" ><img src="${pageContext.request.contextPath}/img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                   
                  </tr>
                 
                 </c:forEach>
                
                  
               
                
               
            </table>

        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
        <a href="javascript:void(0)" id="yes" onclick="del()">确定</a>
        <a href="javascript:void(0)" id="no">取消</a>
    </div>
    </div>
</div>



<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/js.js"></script>
<script src="${pageContext.request.contextPath}/js/time.js"></script>


<script type="text/javascript">


    //用户管理页面上点击删除按钮弹出删除框(userList.html)
    $(function () {
        $('.removeUser').click(function () {//a标签
            obj=$(this);//获取a标签
            id=$(this).attr("id");//获取a标签的id属性值。
            $('.zhezhao').css('display', 'block');
            $('#removeUse').fadeIn();
        });
    });


    $(function () {
        $('#no').click(function () {
            $('.zhezhao').css('display', 'none');
            $('#removeUse').fadeOut();
        });


    });
    var id;
    var obj;//a标签

    function del(){


        $('.zhezhao').css('display', 'none');
        $('#removeUse').fadeOut();
	  //1.要删除哪条数据，要id?
      //2.发送ajax
        $.ajax({
            url:"${pageContext.request.contextPath}/user/delele",
            type:"post",
            data:{id:id},
            dataType:"text",
            success:function (data) {//true表示删除成功，false表示删除失败
                if(data=="true"){
                    //3.删除当前tr
                    var tr=obj.parent().parent();
                     tr.remove();
                }

            }
        })




	  
  }


</script>


</body>
</html>