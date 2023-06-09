<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
      crossorigin="anonymous"
    />

    <title>edit</title>
  </head>
  <body>
    <h1>CONTACTS</h1>
    
    <form class="form">
      <input type="hidden" id="cid" name="cid" value="<c:out value='${contact.cid}'/>"/>
      <div class="form-group">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="<c:out value='${contact.firstname}'/>" required/>
      </div>
      
      <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="<c:out value='${contact.lastname}'/>" required />
      </div>
      <div class="form-group">
        <label for="companyName">Company Name</label>
        <input type="text"  id="companyName" name="companyName" value="<c:out value='${contact.companyname}'/>" required/>
      </div>
      <div class="form-group">
        <label for="birthday">Birthday</label>
        <input type="text"  id="birthday" name="birthday" value="<c:out value='${contact.birthday}'/>"/>
      </div>
      <div class="form-group">
        <label> mobile Number:</label>
        <c:forEach var="mob" items="${contact.mobile}">
        <div class="cm">
          <input id="mobileid" type="hidden" name="mobileid" value="<c:out value='${mob[0]}'/>"/>
          <input id="mobileCategory" name="mobileCategory" value="<c:out value='${mob[1]}'/>"/>
          <input type="tel" id="mobile" name="mobile" value="<c:out value='${mob[2]}'/>" required />    
        </c:forEach> 
        </div>
      </div>
      <div class="form-group">
        <label> EMAIL:</label>
        <c:forEach var="mob" items="${contact.email}">
        <div class="cm">
          <input id="emailid" type="hidden" name="emailid" value="<c:out value='${mob[0]}'/>"/>
          <input id="emailCategory" name="emailCategory" value="<c:out value='${mob[1]}'/>"/>
          <input type="tel" id="email" name="email" value="<c:out value='${mob[2]}'/>" required />    
        </c:forEach> 
        </div>
      </div>
      <div class="form-group">
        <label> address:</label>
        <c:forEach var="mob" items="${contact.address}">
        <div class="cm">
          <input id="addressid" type="hidden" name="addressid" value="<c:out value='${mob[0]}'/>"/>
          <input id="addressCategory" name="addressCategory" value="<c:out value='${mob[1]}'/>"/>
          <input type="tel" id="address" name="address" value="<c:out value='${mob[2]}'/>" required />    
        </c:forEach> 
        </div>
      </div>

      <button id="sub" type="submit">submit</button> 
    </form>
    <a href="Menu.jsp"><button id="menu" type="button">menu</button></a>
      
      <form action="logout" method="post">
        <button type="submit" id="log">logout</button> 
     </form>

    <script>
     const formEl=document.querySelector(".form");
      formEl.addEventListener('submit',event => {
        
        event.preventDefault();
        const formData=new FormData(formEl);
        const data=Object.fromEntries(formData);
        
        data.mobiles=formData.getAll("mobile");
        data.mobileCategorys=formData.getAll("mobileCategory");
        data.mobileids=formData.getAll("mobileid");
        data.emails=formData.getAll("email");
        data.emailCategorys=formData.getAll("emailCategory");
        data.emailids=formData.getAll("emailid");
        data.addresses=formData.getAll("address");
        data.addressCategorys=formData.getAll("addressCategory");
        data.addressids=formData.getAll("addressid");
        fetch("update",{
          method:'POST',
          headers:{
            'Content-Type':'application/json'
          },
          body:JSON.stringify(data)
        }).then(window.location.assign('Menu.jsp'));
        
       
        
      })
    </script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
