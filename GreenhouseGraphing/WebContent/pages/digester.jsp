<%@ taglib prefix="s" uri="/struts-tags"%>
<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl" />
            <li><a href="${homeUrl}">Home</a></li>
            <li class="active">Digester</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<!--MAIN CONTENT AREA-->
<div class="container container-main">
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-12">
            <s:url action="reportListAndManualData" var="digester">
                <s:param name="category">digester</s:param>
                <s:param name="name">Digester</s:param>
            </s:url>
            <!--DIGESTER GRAPHIC-->
            <a href="${digester}" onclick="gowait();"><img class="mainSystemNavImage img-responsive" style="width:581px"src="img/digester.png"/></a>

        </div><!-- /.col-xs-12 .col-sm-12-->
    </div><!-- /.row .row-offcanvas .row-offcanvas-right-->
</div><!--/.container .container-main-->