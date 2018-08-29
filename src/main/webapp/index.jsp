<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="theme.css" type="text/css">
</head>

<body class="">
<nav class="navbar navbar-expand-md bg-primary text-uppercase text-center navbar-dark sticky-top py-1">
    <div class="container-fluid">
        <a class="navbar-brand mx-auto w-50" href="#">Navbar</a>
        <button class="navbar-toggler navbar-toggler-right" type="button"
                data-toggle="collapse" data-target="#navbar2SupportedContent">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-center"
             id="navbar2SupportedContent">
            <a class="btn navbar-btn btn-primary ml-2 text-white btn-lg mr-auto w-50"
               data-toggle="modal" data-target="#login-modal">
                <i class="fa d-inline fa-lg fa-user-circle-o"></i> Sign in</a>
            <div class="btn-group btn-group-sm px-5 ml-auto w-25">
                <button class="btn btn-primary dropdown-toggle"
                        data-toggle="dropdown"> Language
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">English</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Russian</a>
                </div>
            </div>
        </div>
    </div>
</nav>
<div class="modal fade" id="login-modal">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Log in to your account</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span>×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <form class="" method="post" action="login">
                            <div class="form-group">
                                <label>Email address</label>
                                <input type="text" class="form-control"
                                       placeholder="Enter login"
                                       name="login">
                                <small class="form-text text-muted">We'll never
                                    share your email with anyone else.
                                </small>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control"
                                       placeholder="Password" name="pwd"></div>
                            <button type="submit"
                                    class="btn btn-primary btn-block">Submit
                            </button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <a href="signup.jsp" type="button"
                   class="btn btn-primary mx-auto">Register
                </a>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>