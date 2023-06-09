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

    <title>display</title>
  </head>
  <body>
    <h1>CONTACTS</h1>
    <form class="form">
      <div class="form-group">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required />
      </div>
      <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required />
      </div>
      <div class="form-group">
        <label for="companyName">Company Name</label>
        <input type="text" id="companyName" name="companyName" />
      </div>
      <div class="form-group">
        <label for="birthday">Birthday</label>
        <input type="date" id="birthday" name="birthday" />
      </div>
      <div class="form-group">
        <label> mobile Number:</label>
        <button id="addNumberBtn">Add</button>
        <div class="cm">
          <select id="mobileCategory" name="mobileCategory">
            <c:forEach var="cat" items="${cat}">
              <option value="${cat.ctid}">
                <c:out value="${cat.category}" />
              </option>
            </c:forEach>
          </select>
          <input type="tel" id="mobile" name="mobile" required />
        </div>
      </div>

      <div class="form-group">
        <label>email:</label>
        <button id="addNumberBtn1">Add</button>
        <div class="ce">
          <select id="emailCategory" name="emailCategory">
            <c:forEach var="cat" items="${cat}">
              <option value="${cat.ctid}">
                <c:out value="${cat.category}" />
              </option>
            </c:forEach>
          </select>
          <input type="email" id="email" name="email" required />
        </div>
      </div>

      <div class="form-group">
        <label>address:</label>
        <button id="addNumberBtn2">Add</button>
        <div class="ca">
          <select id="addressCategory" name="addressCategory">
            <c:forEach var="cat" items="${cat}">
              <option value="${cat.ctid}">
                <c:out value="${cat.category}" />
              </option>
            </c:forEach>
          </select>
          <input type="text" id="address" name="address" required />
        </div>
      </div>

      <button id="sub" type="submit">submit</button>
    </form>
    <a href="Menu.jsp"><button id="menu" type="button">menu</button></a>

    <form action="logout" method="post">
      <button type="submit" id="log">logout</button>
    </form>

    <script>
      const formEl = document.querySelector(".form");
      formEl.addEventListener("submit", (event) => {
        event.preventDefault();
        const formData = new FormData(formEl);
        const data = Object.fromEntries(formData);

        data.mobiles = formData.getAll("mobile");
        data.mobileCategorys = formData.getAll("mobileCategory");
        data.emails = formData.getAll("email");
        data.emailCategorys = formData.getAll("emailCategory");
        data.addresses = formData.getAll("address");
        data.addressCategorys = formData.getAll("addressCategory");
        fetch("add", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(data),
        }).then(window.location.assign("Menu.jsp"));
      });
      const addFormGroup = (btnId, inputId, inputType, selectId, className) => {
        document.getElementById(btnId).addEventListener("click", (event) => {
          event.preventDefault();
          let formGroup = document.createElement("div");
          formGroup.classList.add("form-group");

          let select = document.createElement("select");
          select.id = selectId;
          select.name = selectId;
          select.innerHTML = `
  <c:forEach var="cat" items="${cat}">
    <option value="${cat.ctid}"><c:out value="${cat.category}"/></option>
  </c:forEach>
`;
          let input = document.createElement("input");
          input.type = inputType;
          input.id = inputId;
          input.name = inputId;
          input.required = true;

          formGroup.appendChild(select);
          formGroup.appendChild(input);
          document.querySelector(className).appendChild(formGroup);
        });
      };

      addFormGroup("addNumberBtn", "mobile", "tel", "mobileCategory", ".cm");
      addFormGroup("addNumberBtn1", "email", "email", "emailCategory", ".ce");
      addFormGroup(
        "addNumberBtn2",
        "address",
        "text",
        "addressCategory",
        ".ca"
      );
    </script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
