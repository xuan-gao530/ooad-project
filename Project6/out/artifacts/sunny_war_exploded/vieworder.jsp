<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/27/2020
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View the Order</title>
</head>
<body background="./money.jpg"; marginwidth = "300px"; marginheight="200px">
</body>
<body>
<h2>The history of Orders</h2>
<table border="1">
    <%
        ArrayList infor=(ArrayList<String>)request.getAttribute("infor");
        if(infor!=null) {
            int size = infor.size();
    %>
    <h4>
        <tr><th>aid</th><th>pid</th><th>category</th><th>name</th><th>quantity</th><th>price</th></tr>
        <%
            int i;
            for (i = 0; i < size; i = i + 6){
        %>
        <tr>
            <td><%=infor.get(i)%></td>
            <td><%=infor.get(i+1)%></td>
            <td><%=infor.get(i+2)%></td>
            <td><%=infor.get(i+3)%></td>
            <td><%=infor.get(i+4)%></td>
            <td><%=infor.get(i+5)%></td>
        </tr>
        <%
                }
            }
        %>
    </h4>
</table>
</body>
</html>
