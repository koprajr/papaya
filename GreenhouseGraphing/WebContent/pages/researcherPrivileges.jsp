<%@ taglib prefix="s" uri="/struts-tags"%>

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl" />
            <li><a href="${homeUrl}">Home</a></li>
            <li class="active">Researcher Privileges</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<div class="container container-main">
    <div class="row">
        <div class="col-12">
            <div class="page-header">
                <h2>Researcher Privileges: </h2>
            </div><!-- /.page-header-->
            <div class="row">
                <div class="col-md-4" style="margin-bottom:30px;">
                    <s:url action="goTo_newManualDataType" var="newManualDataType_Action" />

                    <a href="${newManualDataType_Action}"><img src="img/manualData-types.jpg" class="img-rounded"></a>
                    <a href="${newManualDataType_Action}">Create New Manual Data Type</a>

                </div><!-- /.panel .panel-default-->
            </div><!-- /.panel .panel-default-->
        </div>
    </div>
</div>