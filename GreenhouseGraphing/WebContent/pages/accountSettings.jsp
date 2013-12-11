<%@ taglib prefix="s" uri="/struts-tags"%>

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl" />
            <li><a href="${homeUrl}">Home</a></li>
            <li class="active">Account Settings</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<div class="container container-main">
    <div class="row">
        <div class="col-12">
            <div class="page-header">
                <h2>Account Settings: <small>Change Password for ${username}</small></h2>
            </div><!-- /.page-header-->
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <form role="form" action="userChangePassword" method="post">
                        <!--ONE OF THESE FOR EACH MANUAL DATAPOINT-->
                        <span style="font-size: 11px;">Fields marked with an * are required</span><br><br>
                        <div class="form-group">
                            <input type="hidden" name="bean.username" class="form-control" id="username" value="${username}" placeholder="">
                            <label for="oldPassword">Old Password *</label>
                            <input type="password" name="bean.oldPass" class="form-control" id="oldPassword" placeholder=""required="">
                            <label for="oldPassword">New Password *</label>
                            <input type="password" name="bean.newPass" class="form-control" id="newPassword1" placeholder="" required="">
                            <label for="newPassword2">New Password (again for confirmation) *</label>
                            <input type="password" name="bean.newPass2" class="form-control" id="newPassword2" placeholder="" required="">
                        </div><!-- /.form-group-->
                        <button type="submit" class="btn btn-primaryGreen manualDataSubmit">Submit  <span class="glyphicon glyphicon-arrow-right"/></button>
                    </form>
                </div><!-- /.panel .panel-default-->
            </div><!-- /.panel .panel-default-->
        </div>
    </div>
</div>