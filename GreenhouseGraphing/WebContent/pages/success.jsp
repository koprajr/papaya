<%@ taglib prefix="s" uri="/struts-tags"%>
<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl" />
            <li><a href="${homeUrl}">Home</a></li>
            <li class="active">Success</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<!--MAIN CONTENT AREA-->
<div class="container container-main">
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-12">
            <s:url action="index" var="homeUrl" />
            <div class="alert alert-success">
                Congratulations!  Your submission/change was successful.
                <a href="${homeUrl}" class="alert-link">Please click here to return home.</a>
            </div>

        </div><!-- /.col-xs-12 .col-sm-12-->
    </div><!-- /.row .row-offcanvas .row-offcanvas-right-->
</div><!--/.container .container-main-->