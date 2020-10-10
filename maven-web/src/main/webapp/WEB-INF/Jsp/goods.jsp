<%--
  Created by IntelliJ IDEA.
  User: Tama
  Date: 2020/10/6
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body id="body">

请选择区域:<select name="goods_district">
    <option value="1">朝阳</option>
    <option value="2">海淀</option>
    <option value="3">丰台</option>
    <option value="4">西城</option>
    <option value="5">昌平</option>
</select>
<input type="button" value="查询" id="searchbutton">
</body>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script>
    $(function () {

    })

    $("#searchbutton").click(function () {
        var goods_district = $("select[name='goods_district']").val();
        alert(goods_district)
        var count = "<tr><td>商品编号</td><td>商品名称</td><td>商品价格</td><td>库存数量</td><td>订单状态</td><td>操作</td></tr>";
        $("#body").html("");
        $.ajax({
            "url": "/sys/goods/list",
            "type": "post",
            "data": "goods_district=" + goods_district,
            "dataType": "json",
            "success": function (result) {
                $(result).each(function () {
                    count += "<tr>" +
                        "<td>" + this.id + "</td>" +
                        "<td>" + this.goods_name + "</td>" +
                        "<td>" + this.goods_price + "</td>" +
                        "<td>" + this.goods_count + "</td>"
                    if (this.bill_status == 0) {
                        count += "<td>待处理</td>";
                    } else if (this.bill_status == 1) {
                        count += "<td>处理中</td>";
                    } else if (this.bill_status == 2) {
                        count += "<td>已处理</td>";
                    }
                    count += "<td><a href='/sys/goods/upd/" + this.id + "'>修改</td></tr>"
                })
                $("#body").html(count);
            },
            "error": function () {
                alert("请求失败");
            }
        })
    })
</script>
</html>
