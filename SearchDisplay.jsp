<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    
    <title>display</title>
    
   
   
</head>
<body>
    <h1>CONTACTS</h1>
    <c:choose>
    <c:when test="${found =='0'}">
       <h1>Contact not found</h1>
        <br />
    </c:when>    
    <c:otherwise>
        <table class="table table-bordered">
            <thead>
                <th>fname</th>
                <th>lname</th>
                <th>cname</th>
                <th>bday</th>
                <th>mob</th>
                <th>email</th>
                <th>address</th>
            </thead>
            <tbody>
                
                    <c:forEach var="contacts" items="${contacts}">
                 <tr>
                    <td><c:out value="${contacts.firstname}"/></td>
                     <td><c:out value="${contacts.lastname}"/></td>
                    <td><c:out value="${contacts.companyname}"/></td>
                    <td><c:out value="${contacts.birthday}"/></td> 
                    <td><c:forEach items="${contacts.mobile}" var="entry">
                        <c:out value="${entry[0]}" />:-<c:out value="${entry[1]}" />
                        <br />       
                        </c:forEach>
                    </td> 
                    <td><c:forEach items="${contacts.email}" var="entry">
                        <c:out value="${entry[0]}" />:-<c:out value="${entry[1]}" />
                        <br />       
                        </c:forEach>
                    </td> 
                    <td><c:forEach items="${contacts.address}" var="entry">
                        <c:out value="${entry[0]}" />:-<c:out value="${entry[1]}" />
                        <br />       
                        </c:forEach>
                    </td> 
        </c:forEach>
    </tr>
            
            </tbody>
            
        </table>
        <br />
    </c:otherwise>
</c:choose>
    
<a href="Menu.jsp"><button id="menu" type="button">menu</button></a>
      
<form action="logout" method="post">
  <button type="submit" id="log">logout</button> 
</form>
        
  
   </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>