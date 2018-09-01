<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://bootswatch.com/4/lumen/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
          crossorigin="anonymous">

</head>

<body>
<script>
    (function () {
      'use strict';
      window.addEventListener('load', function () {
        var form = document.getElementById('regform');
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      }, false);
    })();
  </script>

<div class="container-fluid w-50">
    <h1 class="display-4 text-center">Enrollee registration</h1>
    <form method="post" action="signup" id="regform" novalidate>

        <div class="input-group input-group-lg mt-3">
            <div class="input-group-prepend">
                <span class="input-group-text fas fa-user"></span>
            </div>
            <input type="text" class="form-control" name="username" placeholder="login" required>
            <div class="invalid-feedback">
                Please choose a username.
            </div>
        </div>

        <div class="input-group input-group-lg mt-3">
            <div class="input-group-prepend">
                <span class="input-group-text fas fa-user"></span>
            </div>
            <input type="password" class="form-control" name="pwd" placeholder="password" required>
        </div>

        <div class="input-group input-group-lg mt-3">
            <div class="input-group-prepend">
                <span class="input-group-text fas fa-user"></span>
            </div>
            <input type="text" class="form-control" name="fName"
                   placeholder="first name" required>
        </div>

        <div class="input-group input-group-lg mt-3">
            <div class="input-group-prepend">
                <span class="input-group-text fas fa-user"></span>
            </div>
            <input type="text" class="form-control" name="sName" placeholder="second name" required>
        </div>

        <div class="input-group input-group-lg mt-3">
            <div class="input-group-prepend">
                <span class="input-group-text fas fa-envelope"></span>
            </div>
            <input type="email" class="form-control" name="email" placeholder="e-mail" required>
        </div>

        <div class="input-group input-group-lg mt-3">
            <div class="input-group-prepend">
                <span class="input-group-text fas fa-envelope"></span>
            </div>
            <input type="tel" class="form-control" name="phone" placeholder="phone in int. format">
        </div>

        <button class="btn btn-primary mt-3" type="submit">Submit form</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl"
        crossorigin="anonymous"></script>

</body>

</html>