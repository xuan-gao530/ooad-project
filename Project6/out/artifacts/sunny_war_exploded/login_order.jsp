<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/25/2020
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sunny My account--Order</title>
</head>
<body background="./master.jpg">
</body>
<body>
<h2>Welcome to Sunny!</h2>
<h3>Your account information</h3>
<form action = "ViewOrderServlet" methods="post">
    <table>
        <%
            request.setCharacterEncoding("GBK");
        %>
        <%
            ArrayList<String> info=(ArrayList<String>)request.getAttribute("info");
            if(info!=null){
        %>
        <h4>
            <tr>
                <td>userid</td>
                <td><input type ="text" name ='userid' value=<%=info.get(0)%> readonly="true"></td>
            </tr>
            <tr><td>usertype</td><td><input type ="text" name ='usertype' value=<%=info.get(1)%> readonly="true"></td></tr>
            <tr><td>email</td><td><%=info.get(2)%></td></tr>
        </h4>
        <%
            }
        %>
    </table>
    <div>
        <input type ="submit" value="view all orders">
    </div>
</form>
</body>
</html>
