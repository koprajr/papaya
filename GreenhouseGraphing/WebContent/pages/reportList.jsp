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
                <h2>SYSTEM NAME <small>Reports</small></h2>
            </div><!-- /.page-header-->

            <div class="row reportList">
                <!--ONE OF THESE FOR EACH REPORT TEMPLATE-->
                <div class="col-md-11 col-md-offset-1">
                    <div class="reportEntry">
                        <h4>NAME OF SOME REPORT TEMPLATE
                            <div class="reportButtons">
                                <button type="button" class="btn btn-primaryGreen reportList" data-toggle="modal" data-target="#myModal">Run Report  <span class="glyphicon glyphicon-arrow-right"></span></button>
                                <button type="button" class="btn btn-primary reportList">Edit Report  <span class="glyphicon glyphicon-pencil"></span></button>
                            </div>
                        </h4>
                    </div><!-- /.reportEntry-->
                </div><!-- /.col-md-11 .col-md-offset-1-->

            </div><!-- /.row .reportList-->

            <!--MANUAL ENTER DATA-->
            <!--*for researchers and admins ONLY*-->
            <div class="row manualEnterData">
                <div class="col-md-8 col-md-offset-1">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Manually Enter Data for the: <small>SYSTEM NAME</h3>
                        </div><!-- /.panel-heading-->
                        <div class="panel-body">

                            <form role="form">
                                <!--ONE OF THESE FOR EACH MANUAL DATAPOINT-->
                                <div class="form-group">
                                    <label>NAME OF SOMETHING</label>
                                    <input type="text" class="form-control" id="nameOfSomething" placeholder="last value">

                                </div><!-- /.form-group-->

                                <button type="submit" class="btn btn-primaryGreen manualDataSubmit">Submit  <span class="glyphicon glyphicon-arrow-right"/></button>
                            </form>

                        </div><!-- /.panel .panel-default-->
                    </div><!-- /.panel .panel-default-->
                </div><!-- /.col-md-8 .col-md-offset-1-->
            </div><!-- /.row .manualEnterData-->

        </div><!-- /.col-xs-12 .col-sm-12-->
    </div><!-- /.row .row-offcanvas .row-offcanvas-right-->
</div><!--/.container .container-main-->

<!--TIME MODAL-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Select Data/Time Frame</h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <!--ONE OF THESE FOR EACH MANUAL DATAPOINT-->
                    <div class="form-group">
                        <br>
                        <input type="text" name="date10" value=""> - <input type="text" name="date11" value="">
                    </div><!-- /.form-group-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primaryGreen">Generate Report  <span class="glyphicon glyphicon-arrow-right"/></button>
                    </div>
                </form>
            </div><!-- /.modal-body -->
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->