<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->

    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">

</head>

<body id="page-top">
<%@include file="/header.jsp"%>


            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">UserCRUD</h1>
                    <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> List of users</a>
                </div>

            </div>
            <!-- /.container-fluid -->

<div class="col-xl-12 col-lg-7">
    <div class="card shadow mb-4">
        <!-- Card Header - Dropdown -->
        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">Add user</h6>
        </div>

        <hr class="sidebar-divider my-0">

        <div class="card-body">
            <form method="post">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="userName" placeholder="User name">
                </div>
                <div class="form-group">
                    <label for="InputEmail1">Email</label>
                    <input type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp" name="email" placeholder="User email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="InputPassword1">Password</label>
                    <input type="password" class="form-control" id="InputPassword1" name="password" placeholder="User password">
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>



<%@include file="/footer.jsp"%>

</body>
</html>