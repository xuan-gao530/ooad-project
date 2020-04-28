<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/24/2020
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Sunny! </title>
</head>
<body background="./money.jpg">
<div id="container" style="width: 200px;margin:200px auto">
    <div id="box">
        <form action = "LoginServlet" methods="post">
            <div class="main">
                <div>
                    <label style="font-size:20px;color:#330066"> Username: </label>
                    <input name = "username" value="">
                </div>
                <div>
                    <label  style="font-size:20px;color:#330066"> Password:</label>
                    <input type ="password" name="password",value="">
                </div>
                <div>
                    <br /><input type ="submit" value="login" style="color:#330066;font-size:20px;background-color:transparent;">
                </div>
                <div>
                    <%
                        request.setCharacterEncoding("GBK");
                    %>
                    <%
                        List<String> info=(List<String>)request.getAttribute("info");
                        if(info!=null){
                            Iterator<String> iter=info.iterator();
                            while(iter.hasNext()){
                    %>
                    <h4><%=iter.next()%></h4>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

