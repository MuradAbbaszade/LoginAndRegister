<%-- 
    Document   : register
    Created on : Aug 15, 2022, 7:53:39 PM
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
        <%
            String message="";
            if(request.getAttribute("message")!=null){
            message = request.getAttribute("message").toString();
        }%>
        <form action="register" method="POST">
            <input name="name" id="name" type="text"/>
            <br>
            <input name="email" id="email" type="email"/>
            <br>
            <input name="password" id="password" type="password"/>
            <br>
            <input name="matchingPassword" id="matchingPassword" type="password"/>
            <br>
            <button type="submit">Submit</button>
            <label id="errormessage"><%= message %></label>
        </form>
    </body>
</html>
