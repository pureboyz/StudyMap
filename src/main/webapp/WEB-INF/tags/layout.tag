<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sturdy Map</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="/ckeditor/ckeditor.js?20191218_001"></script>

<link type="text/css" rel="stylesheet" href="/css/style.css?20191219_001">
<link type="text/css" rel="stylesheet" href="/css/default.css?20191209_001">

</head>
<body>
	<!-- header -->
	<header>
		<div class="container">
			<div class="left_menu">
				<div class="navi">
					<ul>
						<li><a href="/">Sturdy Map</a></li>
					</ul>
				</div>
			</div>
			<div class="right_menu">
				<div class="navi">
					<ul>
						<li><a href="/Workspace">Workspace</a></li>
						<li><a href="/Schedule">Schedule</a></li>
					</ul>
				</div>
				<div class="option">
					<img alt="left" src="/images/menu-line.png"/>
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
	// 현재 page에 class="on" 적용
	$("header .navi ul li a").each(function(){
		var url 		= window.location.href;
		var pathname 	= window.location.pathname;
		var aTagHref 	= $(this).attr("href");
		
		$(this).removeClass("on");
		
		if(url.indexOf(aTagHref.split("?")[0]) > -1 )
		{
			$(this).parent("li").addClass("on");
			$(this).addClass("on");
		}
		
		if(pathname == "/")
		{
			$(".right_menu ul li").eq(0).addClass("on");
			$(".right_menu ul li").eq(0).find("a").addClass("on");
		}
	});
	
	// 상단 메뉴 hover event
	$("header .navi ul li a").hover(function(){
		$(this).parent("li").addClass("hover");
		$(this).addClass("hover");
	}, function(){
		$(this).parent("li").removeClass("hover");
		$(this).removeClass("hover");
	});
	
});
</script>

</html>