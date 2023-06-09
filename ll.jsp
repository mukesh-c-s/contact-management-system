<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
  try
  {
    String username=(String)request.getSession().getAttribute("username");
    if((String)request.getSession().getAttribute("signedup")!=null)
    {
      String signup=(String)request.getSession().getAttribute("signedup");
      if(signup.equals("yes"))
    {
      response.sendRedirect("http://localhost:8080/ms5/j_security_check?j_username="+username + "&j_password=nothing" );      
    }
    }
    
  }
  catch(Exception e)
  {
    e.printStackTrace(System.out);
  }
 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.css"
  rel="stylesheet"
/>
 <link rel="stylesheet" href="css/login.css">
</head>
<body>
  <div class=" container " >
    <h1>CONTACT MANAGEMENT SYSTEM</h1>
    <form action="j_security_check" method="post" >

      <div class="form-outline mb-4">
        <input type="text" id="form2Example1" class="form-control" name="j_username"/>
        <label class="form-label" for="form2Example1">username</label>
      </div>
    
      <!-- Password input -->
      <div class="form-outline mb-4">
        <input type="password" id="j_password" class="form-control" name="j_password"/>
        <label class="form-label" for="j_password">Password</label>
      </div>
      <!-- 2 column grid layout for inline styling -->
      <div class="row mb-4">
        <div class="col d-flex justify-content-center">
          <!-- Checkbox -->
          <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
            <label class="form-check-label" for="form2Example31"> Remember me </label>
          </div>
        </div>
        <div class="col">
          <!-- Simple link -->
          <a href="#!">Forgot password?</a>
        </div>
      </div>
    
      
      <button type="submit"    class="btn btn-primary btn-block mb-4">Sign in</button>
      
      
    </form>
    </div>
    
      
    
    
    <script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.js"
  ></script></body>
</html>