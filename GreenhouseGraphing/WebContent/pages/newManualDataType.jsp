<%@ taglib prefix="s" uri="/struts-tags" %>

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl"/>
            <li><a href="${homeUrl}">Home</a></li>
            <s:if test='#session.level=="admin"'>
                <s:url action="goTo_adminPrivileges" var="adminPrivileges_Action"/>
                <li><a href="${adminPrivileges_Action}">Administrative Privileges</a></li>
            </s:if>
            <s:if test='#session.level=="researcher"'>
                <s:url action="goTo_researcherPrivileges" var="researcherPrivileges_Action"/>
                <li><a href="${researcherPrivileges_Action}">Researchers Privileges</a></li>
            </s:if>
            <li class="active">Create a new manual data type</li>
        </ol>
    </div>
    <!-- /.container-->
</div>
<!-- /.container-breadcrumb-->

<div class="container container-main">
    <div class="row">
        <div class="col-12">
            <div class="page-header">
                <h2>
                    <s:if test='#session.level=="admin"'>
                        Administrative Privileges:
                    </s:if>
                    <s:if test='#session.level=="researcher"'>
                        Researcher Privileges:
                    </s:if>
                    <small>Create a new manual data type</small>
                </h2>
            </div>
            <!-- /.page-header-->
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <form role="form" action="newManualDataType" method="post">
                        <!--ONE OF THESE FOR EACH MANUAL DATAPOINT-->
                        <span style="font-size: 11px;">Fields marked with an * are required</span><br><br>
                        <div class="form-group">
                            <label for="type">Type name *</label>
                            <input type="text" name="bean.name" class="form-control" id="type" placeholder="" required="">
                        </div>
                        <!-- /.form-group-->
                        <button type="submit" class="btn btn-primaryGreen manualDataSubmit">Submit <span
                                class="glyphicon glyphicon-arrow-right"/></button>
                    </form>
                </div>
                <!-- /.panel .panel-default-->
            </div>
            <!-- /.panel .panel-default-->
        </div>
    </div>
</div>