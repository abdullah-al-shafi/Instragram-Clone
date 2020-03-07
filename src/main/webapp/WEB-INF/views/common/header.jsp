<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <title>Instagram-clone</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/font/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/fontawesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/responsive.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/slick.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="https:/resources/demos/style.css">
    
</head>

<body>
    
    <section>
        <nav class="navbar navbar-expand-lg navbar-light">
          <div class="container">
              <a class="navbar-brand" href="${pageContext.request.contextPath }/">
                  <img src="images/instagram-img.png" class="img-fluid" alt="instagram-img.png">
              </a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
          
          <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                  <li class="liiii"><a class="link" id="opener" href="#rafi"><i class="flaticon-add"></i></a></li>
                  <li class="liiii"><a class="link" href="${pageContext.request.contextPath }/"><i class="flaticon-home"></i></a></li>
                  <li class="liiii"><a class="link" href="#bgg"><i class="flaticon-explore"></i></a></li>
                  <li class="liiii"><a class="link" href="#"><i class="flaticon-heart"></i></a></li>
            </ul>
            <a href="${pageContext.request.contextPath}/profile"><img class="ista-img" src="${pageContext.request.contextPath }${image}" ></img></a>
          </div>
          </div>
       </nav>
    </section>

	<div id="dialog" title="Create post">

		<p><img src="${pageContext.request.contextPath}${user.userImage}"
			alt="profile" height="400" width="1600" class="align-self-center" />
		</p>

		<form:form method="POST"
			action="${pageContext.request.contextPath}/user/posts"
			enctype="multipart/form-data">
			
			<p>Upload picture</p>
			<p><input type="file" name="file" /></p>
			<p><input type="text" name="userPosts" placeholder="Whats on your mind?" /></p>
			<p><input class="btn btn-primary float-right" type="submit"
						value="Submit" /></p>
			
		</form:form>
	</div>

	<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath }/js/fontawesome.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/js/slick.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/custom.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <script>
  $( function() {
    $( "#dialog" ).dialog({
      autoOpen: false,
      show: {
        effect: "blind",
        duration: 1000
      },
      hide: {
        effect: "explode",
        duration: 1000
      }
    });
 
    $( "#opener" ).on( "click", function() {
      $( "#dialog" ).dialog( "open" );
    });
  } );
  </script>
    
</body>


</html>
