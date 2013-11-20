<%@ taglib prefix="s" uri="/struts-tags"%>

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl" />
            <li><a href="${homeUrl}">Home</a></li>
            <li><a href="#">Environment</a></li> <!--NEEDS TO BE DYNAMIC -->
            <li class="active">EnvironmentName: Reports</li>  <!--NEEDS TO BE DYNAMIC -->
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<!--MAIN CONTENT AREA-->
<div class="container container-main">
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-12">

            <div class="page-header">
                <h2>${reportListBean.system} <small>Reports</small></h2>
            </div><!-- /.page-header-->

            <div class="row reportList">
                <!--ONE OF THESE FOR EACH REPORT TEMPLATE-->
                <div class="col-md-11 col-md-offset-1">
                    <s:iterator value="reportTemplates" var="r">
                    	<s:url action="runReport" var="runReport">
                    		<s:param name="reportName">${r.name}</s:param>
                    	</s:url>
                    
                        <div class="reportEntry">
                            <h4>${r.name}</h4>
                            <div class="reportButtons">
                                <a href="${runReport}" type="button" class="btn btn-primaryGreen reportList">Run Report  <span class="glyphicon glyphicon-arrow-right"></span></a>
                                <button type="button" class="btn btn-primary reportList">Edit Report  <span class="glyphicon glyphicon-pencil"></span></button>
                            </div>
                            
                        </div><!-- /.reportEntry-->
                    </s:iterator>
                </div><!-- /.col-md-11 .col-md-offset-1-->

            </div><!-- /.row .reportList-->

            <s:if test='#session.level=="admin" || #session.level=="researcher"'>
                <!--MANUAL ENTER DATA-->
                <!--*for researchers and admins ONLY*-->
                <div class="row manualEnterData">
                    <div class="col-md-8 col-md-offset-1">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Manually Enter Data:</h3>
                            </div><!-- /.panel-heading-->
                            <div class="panel-body">

                                <form action="insertManualData" method="post">
                                    <!--ONE OF THESE FOR EACH MANUAL DATAPOINT-->
                                    <label for="select">Select a Manual Data Type: </label>
                                    <s:select list="manualDataTypes"
                                              name="bean.type"
                                              id="select"
                                              cssClass="form-control"
                                    />
                                    <br>
                                    <label for="value">Value</label>
                                    <br>
                                    <input type="text" style="margin-left:0px;" name="bean.quantity" class="form-control" id="value">
                                    <br>
                                    <button type="submit" class="btn btn-primaryGreen manualDataSubmit">Submit  <span class="glyphicon glyphicon-arrow-right"/></button>
                                </form>

                            </div><!-- /.panel .panel-default-->
                        </div><!-- /.panel .panel-default-->
                    </div><!-- /.col-md-8 .col-md-offset-1-->
                </div><!-- /.row .manualEnterData-->
            </s:if>

        </div><!-- /.col-xs-12 .col-sm-12-->
    </div><!-- /.row .row-offcanvas .row-offcanvas-right-->
</div><!--/.container .container-main-->

