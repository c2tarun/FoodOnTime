<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Food On Time</title>
<link rel="shortcut icon" href="favicon.ico" />


<script type="text/javascript" src="js/header.js"></script>

</head>

<body onload="changeActiveMenu('index');">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sideBars.jsp"></jsp:include>

  Hello <%=session.getAttribute("savedUsername") %> -->

<div id="Content">
  <h2> Welcome To Food On Time!!!</h2>
	<h1>Motivation</h1>
		<p>The motivation behind this website is that nobody wants to stand in queue even to buy fast food. Standing and waiting in line kind of voids the point for fast food. There are websites, which will allow you to order food online. However, they’ll deliver it to some address and not at random places like bus stops, railway stations etc.<br/>In the fast paced world its good even to save 10-15 minutes. Using our service you can save same amount of time almost everyday, that’s an hour over a week and a movie time over a month.</p>	
    <h1>Why Food On Time???</h1>
    	<p>What we are offering will merge your waiting time at home and waiting time at bus stop. So if you have to order a pizza and catch a bus in 30 minutes we’ll deliver the food at the bus stop in 30 minutes time frame.
		Or you want something from your favorite fast food restaurant for your journey we’ll provide it on the way at your given time.</p>
    	
	<h1>&nbsp;</h1>
</div>
<div class="spacer">&nbsp;</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>