<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
  String uname=(String)request.getSession().getAttribute("username");
  System.out.println(uname);
  try
  {
    String username=(String)request.getSession().getAttribute("username");
    if((String)request.getSession().getAttribute("signedup")!=null)
    {
      String signup=(String)request.getSession().getAttribute("signedup");
      if(signup.equals("yes"))
    {
      response.sendRedirect("http://localhost:8080/ms4/j_security_check?j_username="+username + "&j_password=nothing" );      
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
      
      <!-- <div class="form-outline mb-4" >
        <input type="hidden" id="j_username" class="form-control" name="j_username" value="<%=uname%>"/>
        <label class="form-label" for="j_username">otp</label>
      </div> -->
      <div class="form-outline mb-4">
        <input type="text" id="j_password" class="form-control" name="j_password"/>
        <label class="form-label" for="j_password">otp</label>
      </div>
    
    <button type="submit"  class="btn btn-primary btn-block mb-4">verify OTP</button>
      
      
    </form>
    </div>
    
    <script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.js"
  ></script></body>
</html>