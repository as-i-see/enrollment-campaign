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
    <link rel="stylesheet"
          href="https://bootswatch.com/4/lumen/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
          crossorigin="anonymous">
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
                <a class="btn btn-primary btn-lg text-white m-0 p-1 flex-row align-self-center d-flex justify-content-center align-items-center btn-block"
                   href="#">${account.username}&nbsp;
                    <span class="badge badge-secondary ml-1 text-warning badge-pill m-1 p-1 border border-light">1</span>
                </a>
                <a href="logout"
                   class="btn btn-primary m-0 px-1 d-flex flex-row justify-content-center align-items-center">
                    <br>
                    <i class="fas fa-sign-out-alt fa-2x" aria-hidden="true"></i>
                </a>
            </div>
            <div class="btn-group align-self-start align-items-center justify-content-start flex-column d-inline-flex w-50 m-2 btn-group-lg">
                <button class="btn dropdown-toggle btn-primary text-white"
                        data-toggle="dropdown">&nbsp;
                    <i
                            class="fas fa-pull-left fa-language p-0 d-inline m-0 pull-left fa-fw fa-2x"></i>
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
<div class="">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>Subject</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Result</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${assessments}" var="assessment">
                        <tr>
                            <td>${assessment.subject.name}</td>
                            <td>${assessment.enrollee.firstName}</td>
                            <td>${assessment.enrollee.lastName}</td>
                            <td>
                                <form class="form-inline"
                                      action="assess?id=${assessment.id}"
                                      method="post">
                                    <div class="input-group">
                                        <input type="number"
                                               class="form-control"
                                               placeholder="Grade"
                                               name="grade"
                                        >
                                        <div class="input-group-append">
                                            <button class="btn btn-primary"
                                                    type="submit">Set
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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
