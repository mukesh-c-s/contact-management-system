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
    
    <title>Sort</title>
    
   
   
</head>
<body>
    <h1>CONTACTS Sort</h1>
    <div class="container text-left">
          <form action="sort" method="post">
        <div class="col">
            
          <div class="p-3"><button type="submit" name="button" class="btn btn-outline-primary" value="1">1.FIRSTNAME</button></div>
        
        </div>
        <div class="col">
          
          <div class="p-3"><button type="submit" name="button" class="btn btn-outline-primary" value="2">2.LASTNAME</button></div>
        
        </div>
        <div class="col">
            
          <div class="p-3"><button type="submit" name="button" class="btn btn-outline-primary" value="3">3.COMPANYNAME</button></div>
            
        </div>
        <div class="col">
            
          <div class="p-3"><button type="submit" name="button"  class="btn btn-outline-primary" value="4">4.BIRTHDAY</button></div>
            
        </div>
        <div class="col">
            
          <div class="p-3"><button type="submit" name="button" class="btn btn-outline-primary" value="5">5.MOBILENUMBER</button></div>
            
        </div>
        <div class="col">
            
          <div class="p-3"><button type="submit" name="button" class="btn btn-outline-primary" value="6">6.EMAIL</button></div>
        
        </div>
        <div class="col">
            
            <div class="p-3"><button type="submit" name="button" class="btn btn-outline-primary" value="7">7.ADDRESS</button></div>
        
        </div>
    </form>

      </div>
      <a href="Menu.jsp"><button id="menu" type="button">menu</button></a>
      
      <form action="logout" method="post">
        <button type="submit" id="log">logout</button> 
     </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>