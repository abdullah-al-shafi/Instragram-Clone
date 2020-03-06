<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>${ pageTitle }</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>

    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath }/">Batch-1</a>

        <sec:authorize access="isAuthenticated()">

        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown"><a
                        class="nav-link dropdown-toggle" href="#"
                        role="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">Countries</a>
                    <div class="dropdown-menu"
                         aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath }/country/add">Add</a>
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath }/country/show-all">Show
                            All</a>
                    </div>
                </li>
                <li class="nav-item dropdown"><a
                        class="nav-link dropdown-toggle" href="#"
                        role="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">Students</a>
                    <div class="dropdown-menu"
                         aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath }/student/add">Add</a>
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath }/student/show-all">Show
                            All</a>
                    </div>
                </li>
                <li class="nav-item dropdown"><a
                        class="nav-link dropdown-toggle" href="#"
                        role="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">Courses</a>
                    <div class="dropdown-menu"
                         aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath }/course/add">Add</a> <a
                            class="dropdown-item"
                            href="${pageContext.request.contextPath }/course/show-all">Show
                        All</a>
                    </div>
                </li>
                <sec:authorize access="hasRole('ADMIN')">
                    <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle" href="#"
                            role="button" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">Users</a>
                        <div class="dropdown-menu"
                             aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath }/user/add">Add</a> <a
                                class="dropdown-item"
                                href="${pageContext.request.contextPath }/user/show-all">Show
                            All</a>
                        </div>
                    </li>
                </sec:authorize>
            </ul>

            <form class="form-inline my-2 my-lg-0" style="display: none">
                <input class="form-control mr-sm-2" type="search"
                       placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-secondary" type="submit">Search</button>
            </form>

            <div class="dropdown ">
                <button class="btn btn-outline-secondary dropdown-toggle ml-3"
                        type="button" id="dropdownMenuButton" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    <sec:authentication property="principal.username"/>
                    <sec:authorize access="hasRole('ADMIN')">(ADMIN)</sec:authorize>
                    <sec:authorize access="hasRole('USER')">(USER)</sec:authorize>
                    <sec:authorize access="hasRole('PREMIUM_USER')">(PREMIUM_USER)</sec:authorize>
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <%--                    <a class="dropdown-item"--%>
                        <%--                       href="${pageContext.request.contextPath}/edit_profile">Edit Profile</a>--%>
                    <a class="dropdown-item"
                       href="${pageContext.request.contextPath}/logout">Logout</a>
                </div>
            </div>
            <div class="Fifk5"><div class="oZBNB"></div>
            <a class="_2dbep qNELH kIKUG" href="${pageContext.request.contextPath}/profile"  style="width: 22px; height: 22px;">
            <img alt="shafi.sbf's profile picture" class="_6q-tv" 
            src="${pageContext.request.contextPath}/${image}">
          
            
            </a></div>
            
            </sec:authorize>

        </div>
    </div>
</nav>