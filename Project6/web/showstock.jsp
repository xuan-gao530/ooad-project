<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/26/2020
  Time: 6:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show the stock to update</title>
</head>
<body background="./stock.jpg"; marginwidth = "550px">
</body>
<body>
<h3>Please choose the products to update.</h3>
<form method='post' action='UpdateStockServlet'>
<table border='1'>
        <%
    ArrayList info=(ArrayList<String>)request.getAttribute("info");
    if(info!=null) {
        int size = info.size();
%>
    <h4>
        <tr><th>pid</th><th>category</th><th>name</th><th>quantity</th><th>options</th><th>option qty</th></tr>
        <tr>
        <%
        int i;
        for (i = 0; i < size; i = i + 5) {
       %>
        <td><input type ="checkbox" name ='pid' value=<%=info.get(i)%>></td>
            <td><%=info.get(i+1)%></td>
            <td><%=info.get(i+2)%></td>
            <td><%=info.get(i+3)%></td>
            <td><select name="options">
                <option value="minus">minus</option>
                <option value="add">add</option>
                <option selected="selected" style="display:none"> </option>
            </select></td>
            <td><input type ='text' name = qty value =""></td>
        </tr>
    </h4>
    <%
        }
        }
        %>
</table>
    <div>
        <input type ="submit", value="update the stock">
    </div>
</form>
</body>
</html>
