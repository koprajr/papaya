<%@ taglib prefix="s" uri="/struts-tags"%>
<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb hide"> <!--add class "hide" to get rid of breadcrumbs-->
            <li class="active">Home</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<!--MAIN CONTENT AREA-->
<div class="container container-main">
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-12">

            <s:url action="goTo_greenhouse" var="greenhousePage_Action" />
            <s:url action="goTo_energyCabin" var="energyCabinPage_Action" />
            <s:url action="goTo_digester" var="digesterPage_Action" />

            <!--TOP LEVEL SYSTEM GRAPHIC-->
            <map name="MainPicMap">
                <area href="${greenhousePage_Action}" shape="polygon" coords="34, 240, 35, 193, 124, 161, 154, 162, 235, 194, 235, 243, 34, 243"> <!--Greenhouse-->
                <area href="${energyCabinPage_Action}" shape="polygon" coords="262, 171, 282, 109, 277, 89, 305, 75, 393, 75, 427, 98, 427, 175, 262, 177"> <!--Energy Cabin-->
                <area href="${digesterPage_Action}" shape="polygon" coords="308, 306, 360, 292, 389, 292, 424, 310, 425, 414, 363, 426, 307, 411"> <!--Digester-->
                <area href="#" shape="rect" coords="217, 6, 382, 33"> <!--Overall System-->
            </map>
            <img class="mainSystemNavImage img-responsive hidden-xs" style="width:720px;" src="img/mainNavImage.jpg" usemap="#MainPicMap"/>

            <div class="row visible-xs">
                <div class="col-md-4 col-md-offset-4">
                    <button type="button" class="btn btn-lg btn-primaryGreen btn-block">Greenhouse</button>
                    <button type="button" class="btn btn-lg btn-primaryGreen btn-block">Energy Cabin</button>
                    <button type="button" class="btn btn-lg btn-primaryGreen btn-block">Digester</button>
                    <button type="button" class="btn btn-lg btn-primaryGreen btn-block">Overall System</button>
                    <br>
                </div><!-- /.col-md-4 .col-md-offset-4-->
            </div><!-- /.row .visible-xs-->

            <s:if test="%{admin}">
                <!--CREATE NEW REPORT TEMPLATE BUTTON-->
                <!-- *only for Administrators* -->
                <div class="row row-offcanvas row-offcanvas-right">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="adminONLYblock button">
                            <button type="button" class="btn btn-lg btn-primary btn-block">Create a New Report Template</button>
                        </div><!-- /.adminONLYblock .button-->
                    </div><!-- /.col-md-4 .col-md-offset-4-->
                </div><!-- /.row .row-offcanvas .row-offcanvas-right-->
            </s:if>

        </div><!-- /.col-xs-12 .col-sm-12-->
    </div><!-- /.row .row-offcanvas .row-offcanvas-right-->
</div><!--/.container .container-main-->