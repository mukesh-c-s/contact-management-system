<% String name=request.getRemoteUser();
request.getSession().setAttribute("name",name); %>
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
    <title>Menu</title>

    <script src="https://cdn.rawgit.com/davidshimjs/qrcodejs/gh-pages/qrcode.min.js"></script>
  </head>
  <body>
    <h1 text-align="center">CONTACT MANAGEMENT SYSTEM</h1>

    <div class="container text-left">
      <div class="col">
        <form action="category" method="post">
          <div class="p-3">
            <button type="submit" class="btn btn-outline-primary">
              1.ADD CONTACT
            </button>
          </div>
        </form>
      </div>
      <div class="col">
        <form action="display" method="post">
          <div class="p-3">
            <button type="submit" class="btn btn-outline-primary">
              2.DISPLAY CONTACT
            </button>
          </div>
        </form>
      </div>
      <div class="col">
        <div class="p-3">
          <a href="SearchCategory.jsp"
            ><button type="button" class="btn btn-outline-primary">
              3.SEARCH CONTACT
            </button></a
          >
        </div>
      </div>
      <div class="col">
        <form action="display" method="post">
          <div class="p-3">
            <button type="submit" class="btn btn-outline-primary">
              4.EDIT CONTACT
            </button>
          </div>
        </form>
      </div>
      <div class="col">
        <div class="p-3">
          <a href="SortCategory.jsp"
            ><button type="submit" class="btn btn-outline-primary">
              5.SORT CONTACT
            </button></a
          >
        </div>
      </div>
      <div class="col">
        <form action="display" method="post">
          <div class="p-3">
            <button type="submit" class="btn btn-outline-primary">
              6.DELETE CONTACT
            </button>
          </div>
        </form>
      </div>
    </div>
    <div class="col" text-align="center">
      <form action="logout" method="post">
        <div class="p-3">
          <button type="submit" class="btn btn-outline-primary">logout</button>
        </div>
      </form>
      <%String signed=(String)request.getSession().getAttribute("signedup");
      try{
        if(signed.equals("yes"))
        {
          %>
          <button onclick="qr()" class="btn btn-outline-primary">
          SHOW QRCODE
        </button>
        <div id="qrcode">
          <%
        }
      }
      catch(Exception e){

      }
      
      %>

      
        
      
      
        
      </div>
    </div>
    <script>
      function qr() {
        var secreturl;
        fetch("secretkey", {
          method: "POST",
        })
          .then((response) => response.text())
          .then((text) => {
            secreturl = text;
            console.log(secreturl);
            var x = document.createElement("IMG");
            x.setAttribute(
              "src",
              "https://api.qrserver.com/v1/create-qr-code/?data=" + secreturl
            );
            x.setAttribute("width", "150");
            x.setAttribute("height", "150");
            document.getElementById("qrcode").appendChild(x);
          });
      }
    </script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
