<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/26/2020
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Sunny</title>
</head>
<body background="./master.jpg">
</body>
<body>
<h2>Sunny Supermarket</h2>
<h3> Have a good day!</h3>

<form method="post" action="SearchServlet">
   <div>
    <%
        String aid=(String)request.getAttribute("aid");
        if(aid!=null) {
            String userid= aid;
    %>
    <label>Your user id :</label>
       <input type ="text" name ='userid' value=<%=aid%> readonly="true">
    <%
        }
    %>
   </div>
    Choose an category:
    <input type="checkbox" name="category" value="Food" />Food
    <input type="checkbox" name="category" value="Beverage" />Beverage
    <input type="checkbox" name="category" value="Household" />Household
    <input type="checkbox" name="category" value="Personal Care" />Personal Care
    <br /><br />
    <input type="submit" value="Search" />
    <input type="reset" value="Clear" />

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
                    <option value="add" selected="selected">add</option>
                </select></td>
                <td><input type ='text' name = qty value =""></td>
            </tr>
        </h4>
        <%
                }
            }
        %>
    </table>
    <br /><br />
    <input type="submit" value="add to cart" />
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
<form method="post" action="OrderServlet">
    <div>
        <input type="submit" value="place the order">
    </div>
</form>
</body>
</html>
