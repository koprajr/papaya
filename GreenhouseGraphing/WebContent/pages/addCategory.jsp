<%@ taglib prefix="s" uri="/struts-tags"%>

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl" />
            <li><a href="${homeUrl}">Home</a></li>
            <s:url action="goTo_adminPrivileges" var="adminPrivileges_Action" />
            <li><a href="${adminPrivileges_Action}">Administrative Privileges</a></li>
            <li class="active">Add Category</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<div class="container container-main">
    <div class="row">
        <div class="col-12">
            <div class="page-header">
                <h2>Administrative Privileges: <small>Add Data to Category</small></h2>
            </div><!-- /.page-header-->
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <form role="form" action="addCategory" method="post">
                        <!--ONE OF THESE FOR EACH MANUAL DATAPOINT-->
                        <span style="font-size: 11px;">Fields marked with an * are required</span><br><br>
                        <div class="form-group">

                            <label for="name">Item Name *<br><small>(ex "GALLONS OF WATER TO ROOM 1" or "GH overall electricity")</small></label>
                            <input type="text" name="bean.item" class="form-control" id="name" placeholder="" required="">

                            <br><label>Type of Data *</label><br>
                            <input type="radio" checked="checked" name="bean.type" value="M">Manually Entered Data<br>
                            <input type="radio" name="bean.type" value="T">Report Template

                            <br><br><label for="select">Category: *</label>
                            <s:select list="categories"
                                      name="bean.category"
                                      id="select"
                                      cssClass="form-control"
                                    />

                        </div><!-- /.form-group-->
                        <button type="submit" class="btn btn-primaryGreen manualDataSubmit">Submit  <span class="glyphicon glyphicon-arrow-right"/></button>
                    </form>
                </div><!-- /.panel .panel-default-->
            </div><!-- /.panel .panel-default-->
        </div>
    </div>
</div>