<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>Greenhouse Graphing</title>

	<link href="css/bootstrap.css" rel="stylesheet" />
	<link href="css/styles.css" rel="stylesheet" />
	
	<script type="text/javascript" src="js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
	
	<d:head />
</head>
<body>
<!-- Fixed top navigation bar -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<s:url action="index" var="homeUrl" />
				<a href="${homeUrl}" class="navbar-brand">Home</a>
			</div>
			<div class="navbar-collapse collapse">
			
				<ul class="nav navbar-nav">
					<li><a href="#">Reports</a></li>
					<li><a href="#">Data Entry</a></li>
					<li><a href="#">Administration</a></li>
				</ul>
				
				<s:if test="%{loggedIn}">
					<form action="logout" method="post"
						class="navbar-form navbar-right">
						<button type="submit" class="btn btn-danger">Log Out</button>
					</form>
				</s:if>
				<s:else>
					<form action="login" method="post"
						class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" name="bean.name" placeholder="Username" class="form-control" />
						</div>
						<div class="form-group">
							<input type="password" name="bean.password" placeholder="Password" class="form-control" />
						</div>
						<button type="submit" class="btn btn-success">Log In</button>
					</form>
				</s:else>
			</div>
		</div>
	</div>

	<div class="jumbotron">
		<div class="container">
			<h1>Greenhouse Graphing</h1>
			<p>An extension of Mango providing additional graphing features.</p>
		</div>
	</div>

	<div class="container">

		<d:body />

	</div>
</body>
</html>