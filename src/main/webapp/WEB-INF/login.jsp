<%-- 
    Document   : login
    Created on : Aug 15, 2022, 7:53:30 PM
    Author     : roma-cervice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            <input name="username" id="username" type="email"/>
            <br>
            <input name="password" id="password" type="password"/>
            <br>
            <button type="submit">Submit</button>
            <label id="errormessage"></label>
        </form>
    </body>
</html>
