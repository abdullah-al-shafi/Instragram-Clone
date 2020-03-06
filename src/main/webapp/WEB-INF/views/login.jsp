<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <form action="${pageContext.request.contextPath }/login-processing"
                  method="POST">
    <div class="l-part">
      <input type="text" name="username" placeholder="username" class="input-1" />
      <div class="overlap-text">
        <input type="password" name="password" placeholder="password" class="input-2" />
        
      </div>
      <button type="submit" class="btn">Login</button>
    </div>
    </form>
  </div>
  <div class="sub-content">
    <div class="s-part">
      Don't have an account?<a href="${pageContext.request.contextPath }/register">Sign up</a>
    </div>
  </div>
</div>


</body>
</html>