<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb hide">
            <li class="active">Home</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<div class="container container-main">
    <div class="row">
        <div class="col-12">
            <h2>Invalid username or password. Please try again.</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form class="form-signin" action="login" method="post">
                <h3 class="form-signin-heading">Please sign in:</h3>
                <input type="text" name="bean.name" class="form-control"
                       placeholder="Username" autofocus> <br> <input
                    type="password" name="bean.password" class="form-control"
                    placeholder="Password"> <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign
                    in</button>
            </form>
        </div>
    </div>
</div>

