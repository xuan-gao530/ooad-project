<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
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
            <td><%=info.get(0)%></td>
        </tr>
        <tr><td>usertype</td><td><%=info.get(1)%></td></tr>
        <tr><td>email</td><td><%=info.get(2)%></td></tr>
    </h4>
    <%
        }
    %>
</table>
<%
    List<String> infor=(List<String>)request.getAttribute("infor");
    if(infor!=null){
        Iterator<String> iter=infor.iterator();
        while(iter.hasNext()){
%>
<h4><%=iter.next()%></h4>
<%
        }
    }
%>

<h3>view the stock</h3>
<form action = "ViewStockServlet" methods="post">
    <div class="main">
        <div>
            <label> Product:</label>
            <input type ="text" name="productname",value="">
        </div>
        <div>
            <input type ="submit", value="view the stock">
        </div>
    </div>
</form>
<form action = "ShowServlet" methods="post">
    <div class="main">
        <div>
            <input type ="submit", value="update the stock">
        </div>
    </div>
</form>

</body>
</html>
