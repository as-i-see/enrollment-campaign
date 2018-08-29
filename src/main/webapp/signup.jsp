<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet"
          href="https://v40.pingendo.com/assets/4.0.0/default/theme.css"
          type="text/css">
</head>

<body>
<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form class="text-justify" method="post" action="#">
                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label">Your
                            First name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                  <span class="input-group-addon">
                    <i class="fa fa-user fa lead fa-fw pull-left d-block mx-auto py-2 fa-5x"
                       aria-hidden="true"></i>
                  </span>
                                <input type="text" class="form-control"
                                       name="name" id="name"
                                       placeholder="first name"
                                       required="required"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label">Your
                            Last name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                  <span class="input-group-addon">
                    <i class="fa fa-user fa lead fa-4x fa-fw pull-left d-block mx-auto py-2"
                       aria-hidden="true"></i>
                  </span>
                                <input type="text" class="form-control"
                                       name="name" id="name"
                                       placeholder="last name"
                                       required="required"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="username" class="cols-sm-2 control-label">Choose a username</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                  <span class="input-group-addon">
                    <i class="fa fa-users fa mx-auto py-2 fa-fw pull-left d-block lead"
                       aria-hidden="true"></i>
                  </span>
                                <input type="text" class="form-control"
                                       name="username" id="username"
                                       placeholder="3 to 15 latin symbols"
                                       required="required"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">Your
                            Email</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                  <span class="input-group-addon">
                    <i class="fa fa-envelope fa py-2 mx-auto lead pull-left d-block fa-fw"
                       aria-hidden="true"></i>
                  </span>
                                <input type="email" class="form-control"
                                       name="email" id="email"
                                       placeholder="Enter your Email"
                                       required="required"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm" class="cols-sm-2 control-label">Your phone number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                  <span class="input-group-addon">
                    <i class="fa mx-auto py-2 fa-phone lead fa-fw pull-left d-block"
                       aria-hidden="true"></i>
                  </span>
                                <input type="text" class="form-control"
                                       name="confirm" id="confirm"
                                       placeholder="Enter your phone"
                                       required="required"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">Choose a password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                  <span class="input-group-addon">
                    <i class="fa fa-lock mx-auto py-2 lead fa-fw pull-left d-block"
                       aria-hidden="true"></i>
                  </span>
                                <input type="password" class="form-control"
                                       name="password" id="password"
                                       placeholder="Enter your Password"
                                       required="required"></div>
                        </div>
                    </div>
                    <div class="form-group ">
                        <a href="https://ccp.cloudaccess.net/aff.php?aff=5188"
                           target="_blank" type="button" id="button"
                           class="btn btn-primary btn-lg btn-block login-button">Register</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>