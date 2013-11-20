<%@ taglib prefix="s" uri="/struts-tags"%>

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl" />
            <li><a href="${homeUrl}">Home</a></li>
            <li class="active">Administrative Privileges</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<div class="container container-main">
    <div class="row">
        <div class="col-12">
            <div class="page-header">
                <h2>Administrative Privileges: </h2>
            </div><!-- /.page-header-->
            <div class="row">
                <div class="col-md-4">
                    <s:url action="users" var="createUser" />
                    <a href="${createUser}"><img src="img/user-add.jpg" class="img-rounded"></a>
                    <a href="${createUser}">Add Users</a>

                </div><!-- /.panel .panel-default-->
                <div class="col-md-4">
                    <s:url action="goTo_changePrivilegeLevel" var="changePrivilegeLevel_Action" />
                    <a href="${changePrivilegeLevel_Action}"><img src="img/user-settings.jpg" class="img-rounded"></a>
                    <a href="${changePrivilegeLevel_Action}">Change User Privilege Level</a>

                </div><!-- /.panel .panel-default-->
                <div class="col-md-4">
                    <a href="#"><img src="img/user-edit.jpg" class="img-rounded"></a>
                    <a href="#">Change User's Password</a>

                </div><!-- /.panel .panel-default-->
            </div><!-- /.panel .panel-default-->
        </div>
    </div>
</div>