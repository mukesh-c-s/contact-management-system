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
    
    <form name="logonform" action="j_security_check" method="POST">
      Username: <input type="text" name="j_username"/>
      <br/>
      Password:<input type="password" name="j_password"/>
      <br/>
      <input type="submit" value="Submit"/>
    </form>
    <script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.js"
  ></script></body>
</html>