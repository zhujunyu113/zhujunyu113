<%@ page import="zjy.web.bin.hotelObj" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 29170
  Date: 2022/6/25
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%List<hotelObj> obj =(List<hotelObj>)request.getAttribute("房间结果集合");%>

<html>
<head>
    <title>房间表</title>


    房间号,房间状态,房间类型<br>

    <%
        for (hotelObj objs:obj){
            out.print(objs.getRoomno());
            out.print(",");
            out.print(objs.getHotel_status().equals("True")?"已入住":"未入住");
            out.print(",");
            out.print(objs.getRoom_type());
            out.print("<br>");


        }%>
   <%-- <%ServletContext servletContext = request.getServletContext();%>
    <%List<hotelObj> hotelobj = (List<hotelObj>)servletContext.getAttribute("房间结果集合");%>--%>
<a href="exit">退出登录</a>
</head>
<body>

</body>
</html>
