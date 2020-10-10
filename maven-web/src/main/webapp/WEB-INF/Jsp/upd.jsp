<%--
  Created by IntelliJ IDEA.
  User: Tama
  Date: 2020/10/6
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/sys/goods/upd.do">
    商品编号:<input type="text" value="${goods.id}" name="id"/>
    商品名称:<input type="text" value="${goods.goods_name}" name="goods_name"/>
    商品价格:<input type="text" value="${goods.goods_price}" name="goods_price"/>
    商品数量:<input type="text" value="${goods.goods_count}" name="goods_count"/>
    订单状态:<select name="bill_status">
    <c:if test="${goods.bill_status==0}">
        <option disabled value="0">待处理</option>
    </c:if>
    <c:if test="${goods.bill_status==1}">
        <option disabled value="1">处理中</option>
    </c:if>
    <c:if test="${goods.bill_status==2}">
        <option disabled value="2">已处理</option>
    </c:if>
    <option value="0">待处理</option>
    <option value="1">处理中</option>
    <option value="2">已处理</option>
</select>
    <input type="submit" value="修改">
</form>
</body>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script>
    $(function () {
        var a = $("input[name='id']").val();
        var b = $("select[name='bill_status']").val();
        alert(a)
        alert(b)
    })
</script>
</html>
