<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://bootswatch.com/4/lumen/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
          crossorigin="anonymous">
</head>

<body class="">
<fmt:setBundle basename="pagecontent" var="lang"/>
<nav class="navbar navbar-expand-md bg-primary text-uppercase text-center navbar-dark sticky-top py-1">
    <div class="container-fluid">
        <a class="navbar-brand mx-auto w-50" href="#">
            sos
        </a>
        <button class="navbar-toggler navbar-toggler-right" type="button"
                data-toggle="collapse" data-target="#navbar2SupportedContent">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-center"
             id="navbar2SupportedContent">
            <a class="btn navbar-btn btn-primary ml-2 text-white btn-lg mr-auto w-50"
               data-toggle="modal" data-target="#login-modal">
                <i class="fa d-inline fa-lg fa-user-circle-o"></i> ~Sign in~</a>
            <div class="btn-group btn-group-sm px-5 ml-auto w-25">
                <button class="btn btn-primary dropdown-toggle"
                        data-toggle="dropdown"> ~Language~
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
                                       name="username">
                                <small class="form-text text-muted">We'll never
                                    share your email with anyone else.
                                </small>
                            </div>
                            <fmt:message key="title" bundle="${lang}"/>
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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js"
        integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl"
        crossorigin="anonymous"></script>
</body>

</html>