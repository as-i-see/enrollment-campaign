<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<nav class="navbar navbar-expand-md text-uppercase bg-primary navbar-light text-center flex-row d-flex sticky-top align-items-center my-2 justify-content-start p-0">
    <div class="container-fluid flex-row justify-content-start align-items-center d-flex">
        <a class="navbar-brand m-0 text-dark w-50 p-0" href="#">~ENROLLMENT
            CAMPAIGN~
            <br> </a>
        <button class="navbar-toggler navbar-toggler-right" type="button"
                data-toggle="collapse" data-target="#navbar2SupportedContent">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-center"
             id="navbar2SupportedContent">
            <div class="btn-group flex-row align-self-stretch justify-content-center align-items-center d-flex w-75 mx-5 py-3">
                <a class="btn btn-secondary btn-lg text-white m-0 p-1 flex-row align-self-center d-flex justify-content-center align-items-center btn-block"
                   href="">${account.username}&nbsp;
                    <span class="badge badge-secondary ml-1 text-warning badge-pill m-1 p-1 border border-light">1</span>
                </a>
                <a href="#"
                   class="btn btn-secondary m-0 px-1 d-flex flex-row justify-content-center align-items-center">
                    <br>
                    <i class="fa fa-sign-out fa-2x" aria-hidden="true"></i>
                </a>
            </div>
            <div class="btn-group align-self-start align-items-center justify-content-start flex-column d-inline-flex w-50 m-2 btn-group-lg">
                <button class="btn dropdown-toggle btn-secondary text-white"
                        data-toggle="dropdown">&nbsp;
                    <i class="fa fa-pull-left fa-language p-0 d-inline m-0 pull-left fa-fw fa-2x"></i>
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item text-secondary m-0 p-0 text-center"
                       href="#">~EN~</a>
                    <div class="dropdown-divider  align-self-end px-0 mx-0"></div>
                    <a class="dropdown-item text-secondary text-center m-0 p-0"
                       href="#">~RU~</a>
                </div>
            </div>
        </div>
    </div>
</nav>
<div class="p-0 w-100 m-0">
    <div class="container-fluid">
        <div class="row text-center">
            <div class="col-md-12">
                <div class="row bg-primary">
                    <div class="col-md-3 col-lg-3 col-xl-3"></div>
                    <div class="col-md-3 col-lg-3 col-xl-3">
                        <a href="#"
                           class="btn btn-outline-primary btn-lg btn-block text-white">Button</a>
                    </div>
                    <div class="col-md-3 col-lg-3 col-xl-3">
                        <a href="#"
                           class="btn btn-outline-primary btn-lg btn-block text-white">Button</a>
                    </div>
                    <div class="col-md-3"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-5">
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-5"></div>
                            <div class="col-md-3"></div>
                            <div class="col-md-3"></div>
                        </div>
                    </div>
                    <div class="col-md-2"></div>
                    <div class="col-md-2"></div>
                    <div class="col-md-1"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-5">
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-5"></div>
                            <div class="col-md-3"></div>
                            <div class="col-md-3"></div>
                        </div>
                    </div>
                    <div class="col-md-2"></div>
                    <div class="col-md-2"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

</html>
