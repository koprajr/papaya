<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>Clarkson University</title>

    <!-- Bootstrap and Application Specific CSS -->
	<link href="css/bootstrap.css" rel="stylesheet" />
    <link href="css/main.css" rel="stylesheet" />
	
	<script type="text/javascript" src="js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
	
	<d:head />
</head>
<body>
    <!--NAVIGATION BAR-->
    <div class="navbar navbar-inverse">
        <div class="container-navbar">
            <div class="container">

                <div class="navbar-header">
                    <s:if test="#session.loggedIn">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="div.navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </s:if>
                    <s:url action="index" var="homeUrl" />
                    <a class="navbar-brand" href="${homeUrl}"><img class="logo" src="img/logo.jpg"/></a> <!-- Application Logo -->
                    <s:if test="#session.loggedIn">
                        <br><br><br><span class="loggedInAsSmall visible-xs">Logged in as: <strong> ${username} </strong> </span>
                    </s:if>
                </div><!-- /.navbar-header -->

                <div class="collapse navbar-collapse">
                    <s:if test="#session.loggedIn">
                        <span class="loggedInAs hidden-xs">Logged in as: <strong> ${username} </strong> </span><br/>
                        <%-- <s:url action="accountSettings" var="accountSettingsPage" />    in the href - ${accountSettingsPage}--%>
                        <s:url action="logout" var="logoutAction" />
                        <s:url action="goTo_AccountSettings" var="AccountSettingsPage_Action" />
                        <s:url action="goTo_adminPrivileges" var="adminPrivileges_Action" />


                        <ul class="nav navbar-nav hidden-xs"> <!-- Add: class="active"  to the page the browser is currently on-->
                            <s:if test="#session.admin">
                                <li><a href="${adminPrivileges_Action}">Administrative Privileges</a></li> <!-- *only for Administrators* -->
                            </s:if>

                            <li><a href="${AccountSettingsPage_Action}">Account Settings</a></li>
                            <li class="last"><a href="${logoutAction}">Logout</a></li>
                        </ul>
                        <ul class="nav navbar-nav visible-xs"> <!-- Add: class="active"  to the page the browser is currently on-->
                            <s:if test="#session.admin">
                                <li><a href="${adminPrivileges_Action}">Administrative Privileges</a></li> <!-- *only for Administrators* -->
                            </s:if>

                            <li><a href="${AccountSettingsPage_Action}">Account Settings</a></li>
                            <li><a href="${logoutAction}">Logout</a></li>
                        </ul>
                    </s:if>
                </div><!-- /.collapse .nav-collapse -->

        </div><!-- /.container -->
    </div><!-- /.container-navbar -->
</div><!-- /.navbar .navbar-inverse-->

<d:body />

<div class="container container-main">
    <!--FOOTER-->
    <hr/>
    <footer>
        <p class="copyright">&copy; Copyright: Clarkson University</p>
        <p class="developedBY">Created By: Software Engineering Class of 2014</p>
    </footer>

</div><!--/.container .container-main-->

</body>
</html>