<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List" %>
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

  <% List<User> userList = (List<User>)request.getAttribute("userList");
      if(userList != null) {
      for(User user : userList) {
  %>
      <p>User ID: <%= user.getId() %></p>
      <p>User Name: <%= user.getName() %></p>
  <% } } %>
</body>

  </html>