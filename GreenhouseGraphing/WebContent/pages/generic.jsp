<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb hide">
            <li class="active">Home</li>
        </ol>
    </div><!-- /.container -->
</div><!-- /.container-breadcrumb -->

<!--MAIN CONTENT AREA-->
<div class="container container-main">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form class="form-signin" action="login" method="post">
				<h3 class="form-signin-heading">Please sign in:</h3>
				<input type="text" name="bean.name" class="form-control" placeholder="Username" autofocus>
                <br>
                <input type="password" name="bean.password" class="form-control" placeholder="Password">
                <br>
				<button onclick="gowait();" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</form>
		</div>
	</div>
</div>
