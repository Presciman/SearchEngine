<%--
  Created by IntelliJ IDEA.
  User: ericsun
  Date: 2/9/19
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
  <head>
    <title>SouMao</title>
  </head>
  <body>
    <h1>Informations</h1>
    <form action="/indexController/hi.do" method="post">
      <input type="submit" value="submit">
    </form>
    ${info}
  </body>
</html>
