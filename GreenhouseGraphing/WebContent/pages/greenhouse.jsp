<%@ taglib prefix="s" uri="/struts-tags" %>
<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
            <s:url action="index" var="homeUrl"/>
            <li><a href="${homeUrl}">Home</a></li>
            <li class="active">Greenhouse</li>
        </ol>
    </div>
    <!-- /.container-->
</div>
<!-- /.container-breadcrumb-->

<!--MAIN CONTENT AREA-->
<div class="container container-main">
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-12">

            <%--<s:url action="reportListAndManualData" var="reportListAndManualData" />--%>

            <s:url action="reportListAndManualData" var="greenhouseWater">
                <s:param name="category">greenhouseWater</s:param>
                <s:param name="name">Greenhouse Water</s:param>
            </s:url>
            <s:url action="reportListAndManualData" var="greenhouseLight">
                <s:param name="category">greenhouseLighting</s:param>
                <s:param name="name">Greenhouse Lighting</s:param>
            </s:url>
            <s:url action="reportListAndManualData" var="greenhouseTemp">
                <s:param name="category">greenhouseTemperature</s:param>
                <s:param name="name">Greenhouse Temperature</s:param>
            </s:url>
            <s:url action="reportListAndManualData" var="greenhouseElec">
                <s:param name="category">greenhouseElectricity</s:param>
                <s:param name="name">Greenhouse Electricity</s:param>
            </s:url>

            <!--GREENHOUSE GRAPHIC-->
            <map name="greenhouseMap">
                <area href="${greenhouseWater}" onclick="gowait();" shape="rect" coords="26, 59, 141, 97">
                <!-- Water System Room 1 -->
                <area href="${greenhouseLight}" onclick="gowait();" shape="rect" coords="26, 102, 141, 140">
                <!-- Lighting System Room 1 -->
                <area href="${greenhouseTemp}" onclick="gowait();" shape="rect" coords="25, 145, 139, 179">
                <!-- Temperature Control Room 1 -->
                <area href="${greenhouseElec}" onclick="gowait();" shape="rect" coords="24, 184, 140, 220">
                <!-- Electricity Room 1 -->
                <area href="${greenhouseWater}" onclick="gowait();" shape="rect" coords="213, 61, 324, 96">
                <!-- Water System Room 2 -->
                <area href="${greenhouseLight}" onclick="gowait();" shape="rect" coords="213, 103, 324, 139">
                <!-- Lighting System Room 2 -->
                <area href="${greenhouseTemp}" onclick="gowait();" shape="rect" coords="213, 144, 324, 180">
                <!-- Temperature Control Room 2 -->
                <area href="${greenhouseWater}" onclick="gowait();" shape="rect" coords="395, 60, 507, 95">
                <!-- Water System Room 3 -->
                <area href="${greenhouseLight}" onclick="gowait();" shape="rect" coords="395, 102, 508, 140">
                <!-- Lighting System Room 3 -->
                <area href="${greenhouseTemp}" onclick="gowait();" shape="rect" coords="395, 144, 508, 179">
                <!-- Temperature Control Room 3 -->
                <area href="${greenhouseElec}" onclick="gowait();" shape="rect" coords="396, 185, 507, 221">
                <!-- Electricity Room 3 -->
                <area href="${greenhouseElec}" onclick="gowait();" shape="rect" coords="432, 331, 541, 367">
                <!-- Electricity Total -->
            </map>

            <img class="mainSystemNavImage img-responsive hidden-xs" style="width:581px" src="img/greenhouse.png"
                 usemap="#greenhouseMap"/>

            <div class="row visible-xs">
                <div class="col-md-4 col-md-offset-4">
                    <a href="${greenhouseWater}" onclick="gowait();" type="button"
                       class="btn btn-lg btn-primaryGreen btn-block">Water
                        System</a>
                    <a href="${greenhouseLight}" onclick="gowait();" type="button"
                       class="btn btn-lg btn-primaryGreen btn-block">Lighting System</a>
                    <a href="${greenhouseTemp}" onclick="gowait();" type="button"
                       class="btn btn-lg btn-primaryGreen btn-block">Temperature Control</a>
                    <a href="${greenhouseElec}" onclick="gowait();" type="button"
                       class="btn btn-lg btn-primaryGreen btn-block">Electricity</a>
                    <br>
                </div>
                <!-- /.col-md-4 .col-md-offset-4-->
            </div>
            <!-- /.row .visible-xs-->

        </div>
        <!-- /.col-xs-12 .col-sm-12-->
    </div>
    <!-- /.row .row-offcanvas .row-offcanvas-right-->
</div>
<!--/.container .container-main-->