<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/24/2020
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sunny- My Account</title>
</head>
<body background="./master.jpg">
</body>
<body>
<h2>Welcome to Sunny!</h2>
<h3>Your account information</h3>
<%
    request.setCharacterEncoding("GBK");
%>
<%
    ArrayList<String> info=(ArrayList<String>)request.getAttribute("info");
    if(info!=null){
%>

<form action = "SearchServlet" methods="post">
    <table>
        <h4>
            <tr>
                <td>userid</td>
                <td><input type ="text" name ='userid' value=<%=info.get(0)%> readonly="true"></td>
            </tr>
            <tr><td>usertype</td><td><%=info.get(1)%></td></tr>
            <tr><td>email</td><td><%=info.get(2)%></td></tr>
            <tr><td>address</td><td><%=info.get(3)%></td></tr>
        </h4>
        <%
            }
        %>
    </table>
    <div>
        <input type ="submit" value="Shopping now">
    </div>
</form>
<form action = "ViewOrderServlet" methods="post">
    <div>
       <label>View my order history by userid & type:</label>
        <input type ="text" name ="aid" value =<%=info.get(0)%> readonly=true>
        <input type ="text" name = "usertype" value =<%=info.get(1)%> readonly=true>
    </div>
    <div>
        <input type ="submit" value="view all my orders">
    </div>
</form>
</body>
</html>
