<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <!-- GLOBAL HEADER -->
<jsp:include page="common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Instagram-clone</title>
<%--     <link rel="stylesheet" href="${pageContext.request.contextPath }/css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/fontawesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/responsive.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/font/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/slick.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"> --%>
</head>
<body>

		<c:forEach items="${post_list }" var="posts">
		
	    <section id="gallary">
        <div class="container">
            <div class="row">
                <div class="col-lg-8  border">
                    <div class="row">
                        <div class="col-lg-1">
                            <div class="pro">
                                <a class="proimg" href="#"><img src="${pageContext.request.contextPath }${ posts.user.userImage }" alt=""></a>
                            </div>
                        </div>
                        <div class="col-lg-10 padd">
                            <div class="text1">
                                <a class="tx-a1" href="#">${posts.user.username}</a>
                            </div>
                            <div class="text2">
                                <a class="tx-a2" href="#">${posts.user.userEmail }</a>
                            </div>
                        </div>
                        <!-- <div class="col-lg-1">
                            <a class="tx-icon" href="#"><i class="flaticon-add"></i></a>
                        </div> -->
                    </div>
                    
                    <div class="row">
                        <div class="col-lg-12 p-0">
                            <div class="big-img">
                                <img src="${pageContext.request.contextPath }${ posts.postsImage }" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-11">
                            <div class="icon_3">
                                <ul class="i3-ul">
                                    <li class="i3-li"><a href="#"><i class="flaticon-heart"></i></a></li>
                                    <li class="i3-li"><a href="#"><i class="flaticon-comment"></i></a></li>
                                    <li class="i3-li"><a href="#"><i class="flaticon-plane"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-1">
                            <!-- <a class="icon_1" href="#"><i class="flaticon-add"></i></a> -->
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-lg-12 eye">
                            <div class="like">
                                    <a href="lve-like">1 like</a>
                                    <span><a href="love-like"><b>${posts.user.username}</b> ${posts.postsText}</a></span>
                                    <span><a href="love-like">3 hour ago</a></span>
                            </div>
                        </div>
                    </div>
                    <div class="row top">
                        <div class="col-lg-10 p-0">
                            <form action="">
                                <input type="text" placeholder="Add a comment" class="comments comment-query">
                                
                            </form>
                        </div>
                        <div class="col-lg-2">
                            <input class="btn comment-query-submit" type="submit" value="Submit">
                        </div>
                    </div>
                    <div class="row"></div>
                </div>
                
                <div class="col-lg-4">
                    <!-- <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam eum fuga impedit soluta. Blanditiis fuga corporis incidunt eius atque earum.</p> -->
                </div>
            </div>
        </div>
        
    </section>		
			
			
		</c:forEach>

<script>
    
</script>
</body>
</html>