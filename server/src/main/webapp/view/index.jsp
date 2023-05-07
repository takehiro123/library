<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.libease.model.User" %>
      <!DOCTYPE html>
      <html>

      <head>
        <meta charset="UTF-8">
        <title>My Web App</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="js/main.js"></script>
      </head>

      <body>
        <h2>My app works. index.jsp</h2>
        <a href='./api'>Try ./api</a>
        <p><a href="./samplecontroller">Click here</a> to go to the controller.</p>
        <c:set var="attr" value="${requestScope.userList}" />
        <c:forEach var="item" items="${attr}">
          ${item.getId()} : ${item.getName()}<br>
        </c:forEach>
      </body>
      </html>