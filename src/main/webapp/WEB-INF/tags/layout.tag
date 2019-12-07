<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jobis</title>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<link type="text/css" rel="stylesheet" href="/css/style.css?20191207_008">
<link type="text/css" rel="stylesheet" href="/css/default.css?20191207_001">

</head>
<body>
	<!-- header -->
	<header>
		<div class="container">
			<div class="left_menu">
				<div class="navi">
					<ul>
						<li><a href="/">Home</a></li>
					</ul>
				</div>
			</div>
			<div class="right_menu">
				<div class="navi">
					<ul>
						<li><a href="/">Menu</a></li>
						<li><a href="#">Menu</a></li>
						<li><a href="#">Menu</a></li>
						<li><a href="#">Menu</a></li>
						<li><a href="#">Menu</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<!-- //header -->
	
	<!-- contents -->
	<jsp:doBody/>
	<!-- //contents -->
	
	<!-- footer -->
	<!-- //footer -->
	
</body>

<script type="text/javascript">
$(document).ready(function(){
	$("header .navi ul li a").each(function(){
		var url 		= window.location.href;
		var aTagHref 	= $(this).attr("href");
		
		$(this).removeClass("on");
		
		if(url.indexOf(aTagHref.split("?")[0]) > -1 )
		{
			$(this).parent("li").addClass("on");
			$(this).addClass("on");
		}
	});
	
	$("header .navi ul li").hover(function(){
		$(this).addClass("hover");
		$(this).find("a").addClass("hover");
	}, function(){
		$(this).removeClass("hover");
		$(this).find("a").removeClass("hover");
	});
	
});
</script>

</html>