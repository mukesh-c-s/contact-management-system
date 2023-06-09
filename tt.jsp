<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% System.out.println((String)request.getSession().getAttribute("username"));%>
<%@ page isErrorPage="true" %>
<%@ page import="javax.security.auth.login.AccountExpiredException" %>
<%@ page import="javax.security.auth.login.CredentialExpiredException" %>
<%@ page import="javax.security.auth.login.FailedLoginException" %>

<%
  Exception ex = (Exception) request.getAttribute("javax.servlet.error.exception");

  if (ex instanceof AccountExpiredException) {
    out.println("Your account has expired. Please contact support.");
  } else if (ex instanceof CredentialExpiredException) {
    out.println("Your credentials have expired. Please reset your password.");
  } else if (ex instanceof FailedLoginException) {
    out.println("Invalid username or password. Please try again.");
  } else {
    out.println("An unexpected error occurred. Please try again later.");
  }
%>

<html>
  <head><title></title>
  </head>
  <body>
       <h3>Login Error</h3>   
       <a href="Home.jsp">Click to Login Again</a>  
       <form action="j_security_check" method="post">
        <p><%=exception%></p>
        <label for="otp"></label>
        <input type="text" id="otp" name="j_password">
        <button type="submit">verify</button>
       </form>   
  </body>
</html>