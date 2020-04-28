<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/27/2020
  Time: 2:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Sunny</title>
    <style>
        body{
            background-image:url("./order05.jpg");
            background-size:cover;
        }
        </style>
</head>
<body>
<h2 style="font-size:30px;">Sunny Supermarket</h2>
<h3 style="font-size:25px;">Have a good day!</h3>

<form method="post" action="OrderServlet">
    <div>
        <table border='1'>
            <%
                ArrayList<String> cartinfo=(ArrayList<String>)request.getAttribute("cartinfo");
                if(cartinfo!=null) {
                    int size = cartinfo.size();
            %>
            <h4>
                <tr><th>pid</th><th>category</th><th>name</th><th>quantity_cart</th><th>price</th></tr>
                <tr>
                    <%
                        int i;
                        for (i = 0; i < size; i = i + 6) {
                    %>
                    <td><input type ="checkbox" name ='pid' value=<%=cartinfo.get(i)%> checked='checked'></td>
                    <td><%=cartinfo.get(i+1)%></td>
                    <td><%=cartinfo.get(i+2)%></td>
                    <td><input type ='text' name = 'qty' value=<%=cartinfo.get(i+3)%> readonly="true"></td>
                    <td><%=cartinfo.get(i+4)%></td>
                </tr>
            </h4>
            <%
                    }
                }
            %>
        </table>
        <%
            if(cartinfo.get(5).equals("9")){
        %>
        <label>Please input your address</label>
        <input type="text" value="">
        <%
            }
        %>
    </div>
    <div><input type = 'submit' name="confirm" value="confirm the order"></div>
    <div>
        <%
            String feedback=(String)request.getAttribute("feedback");
            if(feedback!=null){
        %>
        <label><%=feedback%></label>
        <%
            }
        %>
    </div>
</form>
</body>
</html>
