<%@ taglib prefix="s" uri="/struts-tags"%>

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl" />
            <li><a href="${homeUrl}">Home</a></li>
            <s:url action="goTo_adminPrivileges" var="adminPrivileges_Action" />
            <li><a href="${adminPrivileges_Action}">Administrative Privileges</a></li>
            <li class="active">Change Privilege Level</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<div class="container container-main">
    <div class="row">
        <div class="col-12">
            <div class="page-header">
                <h2>Administrative Privileges: <small>Change Privilege Level</small></h2>
            </div><!-- /.page-header-->
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <form role="form" action="privilegeChangeAction" method="post">
                        <!--ONE OF THESE FOR EACH MANUAL DATAPOINT-->
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" name="bean.username" class="form-control" id="username" placeholder="">
                            <br><label>Privilege Level</label><br>
                            <input type="radio" name="bean.level" value="A">Administrator<br>
                            <input type="radio" name="bean.level" value="R">Researcher<br>
                            <input type="radio" name="bean.level" value="S">Student
                        </div><!-- /.form-group-->
                        <button type="submit" class="btn btn-primaryGreen manualDataSubmit">Submit  <span class="glyphicon glyphicon-arrow-right"/></button>
                    </form>
                </div><!-- /.panel .panel-default-->
            </div><!-- /.panel .panel-default-->
        </div>
    </div>
</div>