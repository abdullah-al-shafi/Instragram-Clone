<%--

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!-- GLOBAL HEADER -->

<jsp:include page="../common/header.jsp"></jsp:include>


<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">
</head>

<body>

<header>

<div class="container">

		<div class="profile">

			<div class="profile-image" >

				<img class="dilog_opener" src="${pageContext.request.contextPath}${user.userImage}" alt="" height="150" width="150">

			</div>

			<div class="profile-user-settings">

				<h1 class="profile-user-name">${user.username}</h1>

				<button class="btn profile-edit-btn">Edit Profile</button>

				<a class="btn profile-edit-btn" href="${pageContext.request.contextPath }/logout">Log Out</a>
				<!-- <button class="btn profile-settings-btn" aria-label="profile settings"><i class="fas fa-cog" aria-hidden="true"></i></button> -->

			</div>

			<div class="profile-stats">

				<ul>
					<li><span class="profile-stat-count">${post_size}</span> posts</li>
					<li><span class="profile-stat-count">0</span> followers</li>
					<li><span class="profile-stat-count">0</span> following</li>
				</ul>

			</div>

			<div class="profile-bio">

				<p><span class="profile-real-name">${user.userFullName}</span> Lorem ipsum dolor sit, amet consectetur adipisicing elit 📷✈️🏕️</p>

			</div>

		</div>
		<!-- End of profile section -->

	</div>
	<!-- End of container -->

</header>

<main>

	<div class="container">

		<div class="gallery">
		
		<c:forEach items="${post_list }" var="posts">

			<div class="gallery-item" tabindex="0">
			
			

				<img src="${pageContext.request.contextPath }${ posts.postsImage }" class="gallery-image" alt="">

				<div class="gallery-item-info">

					<ul>
						<li class="gallery-item-likes"><span class="visually-hidden">Likes:</span><i class="fas fa-heart" aria-hidden="true"></i> 0</li>
						<li class="gallery-item-comments"><span class="visually-hidden">Comments:</span><i class="fas fa-comment" aria-hidden="true"></i> 0</li>
					</ul>

				</div>

			</div>

			</c:forEach>

		</div>
		<!-- End of gallery -->

		<div class="loader"></div>

	</div>
	<!-- End of container -->

</main>




	<div id="dialog_pro_pic" title="Update Profile Image">

		<p>
			<img src="${pageContext.request.contextPath}${user.userImage}"
				alt="profile" height="300" width="300" class="align-self-center" />
		</p>



		<form:form method="POST"
			action="${pageContext.request.contextPath}/user/uploadFile"
			enctype="multipart/form-data">
			<p>Change profile picture</p>
			<td><input type="file" name="file" /></td>
			<p><input class="btn btn-primary float-right" type="submit"
					value="Submit" /></p>

		</form:form>
	</div>


<!-- 	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->

	<script>
		$(function() {
			$("#dialog_pro_pic").dialog({
				autoOpen : false,
				show : {
					effect : "blind",
					duration : 1000
				},
				hide : {
					effect : "explode",
					duration : 1000
				}
			});

			$(".dilog_opener").on("click", function() {
				$("#dialog_pro_pic").dialog("open");
			});
		});
		
/* 		$(document).ready(function(){
	        $(".comment-query-submit").click(function(){
	            var queryString = $(".comment-query").val();
	            
	            //   /api/v1/course/search | /course/search
	            $.post("${pageContext.request.contextPath }/api/v1/comment/add?query="+queryString, function( data )  {
	                var searchResContainer = $(".search-result");
	                searchResContainer.html("");
	                if (data.length > 0) {
	                	debugger;
	                    $.each(data, function( index, value ) {
	                        var tblRow = "<tr>\n" +
	                            "        <td class='player-id'>"+ value.palyerId +"</td>\n" +
	                            "        <td class='player-name'>"+ value.firstName + value.lastName + "</td>\n" +
	                            "        <td class='player-Role'>"+ value.playingRole +"</td>\n" +
	                            "    </tr>";
	                        searchResContainer.append(tblRow);
	                    });
	                } else {
	                    searchResContainer.html("<th >Nothing found!</th>");
	                }
	            } 
	        });
	    }); */
	</script>
</body>
</html>

