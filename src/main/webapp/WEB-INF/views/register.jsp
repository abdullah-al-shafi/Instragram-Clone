<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/css/login.css">
</head>
<body>
<c:if test="${error == 'true'}">
    <div class="alert alert-danger" role="alert">Wrong username or
        password
    </div>
</c:if>

<div id="wrapper">
  <div class="main-content">
    <div class="header">
      <img src="https://i.imgur.com/zqpwkLQ.png" />
    </div>
    <h1 class="vvzhL ">Sign up to see photos and videos from your friends.</h1>
    
    
    <form:form action="${pageContext.request.contextPath }/register" modelAttribute="user"
                  method="POST">
    <div class="l-part">
      <form:input path="userEmail" type="text" name="userEmail" placeholder="Email" class="input-1" />
      <form:input path="userFullName" type="text" name="userFullName" placeholder="Full Name" class="input-1" />
      <form:input path="username" type="text" name="username" placeholder="username" class="input-1" />
      <div class="overlap-text">
        <input type="password" name="password" placeholder="password" class="input-2" />
        
        
      </div>
      <br>
      <button type="submit" class="btn">Sign up</button>
    </div>
    </form:form>
  </div>
  <div class="sub-content">
    <div class="s-part">
      Have an account?<a href="${pageContext.request.contextPath }/login">Login</a>
    </div>
  </div>
</div>


</body>
</html>