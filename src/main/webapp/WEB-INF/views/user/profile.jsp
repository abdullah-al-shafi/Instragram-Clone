<%--
  Created by IntelliJ IDEA.
  User: bashir
  Date: 2/26/2020
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">
</head>

<body>

<section class="content">
    <div class="container-fluid">
        <div class="row">
            <%--left Menu START--%>
            <div class="left-menu-section col-lg-2 col-md-3 col-sm-4" >


            </div>
            <%--left Menu END--%>

            <%--content body section START--%>
            <div class="right-body-section col-lg-10 col-md-9 col-sm-8">

                <%--nav section START--%>
                <div class="row">
                    <div class="col-sm-12">
                        <nav class="navbar navbar-light bg-light justify-content-between">
                            <a class="navbar-brand">ICC WEB</a>
                            <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Logout</a>
                        </nav>
                    </div>
                </div>
                <%--nav section END--%>

                <div class="row">
                    <div class="col-sm-12 col-md-6 col-lg-6">
                        <div class="card">
                            <div class="card-header">Edit profile</div>
                            <div class="card-body">
                                <img src="${pageContext.request.contextPath}${user.userImage}" alt="profile" height="300" width="300" class="align-self-center"/>

                                <form:form method="POST" action="${pageContext.request.contextPath}/user/uploadFile" enctype="multipart/form-data">
                                    <table>
                                        <tr>
                                            <td><lavel>Change profile picture</lavel></td></tr></br>
                                            <td><input type="file" name="file"/></td>
                                        </tr>
                                            <tr>
                                            <td><input class="btn btn-primary float-right" type="submit" value="Submit" /></td>
                                        </tr>
                                    </table>

                                </form:form>

                            </div>
                        </div>

                    </div>

                </div>



                <%--footer START --%>
                <%--footer END--%>
            </div>
        </div>
        <%--content body section END--%>

    </div>
</section>
</body>
</html>

