<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="#" class="navbar-brand">Northeastern University</a>
    </div>

    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="${contextPath}">Home</a><br/></li>
        <li><a href="#">Information</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">Staff</a></li>
        <li><a href="#">Help</a></li>        
      </ul> 
      <ul class="nav navbar-nav navbar-right">
              <li><a href="#">Hi, ${user.firstName}</a></li>
      </ul>   
    </div>
  </div>
</nav>




<h1>Hi, ${user.firstName}</h1>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<a href="${contextPath}/product/add" >Add Product</a> <br />


</body>
</html>