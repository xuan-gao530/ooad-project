<!DOCTYPE html>
<html>

<head>
    <style>
        header {
            color:#CCFFFF;
            text-align:center;
            padding:10px;
        }
        section {
            color:#CCFFFF;
            text-align:center;
            padding:10px;
        }
    </style>
</head>

<body background="./groceries.jpg">
<header>
    <h1 style="font-size:50px">Sunny Supermarket</h1>
</header>

<section>
    <div id ="main" style="width:1200px;">
        <div id ="left" style="width:600px;float:left;">
            <input type="button" value="Login" onclick="window.open('login.jsp')" style="color:#CCFFFF;font-size:20px;background-color: transparent; border: 0;">
        </div>
        <div id="right"style="width:600px;float:left;">
            <form action="SearchServlet" mehtod="post">
                <input type ="submit" name="guest" value="continue as a guest" style="color:#CCFFFF;font-size:20px;background-color:transparent;border:0;">
            </form>
        </div>
    </div>
</section>

</body>
</html>
