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
                    <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Add user</a>
                </div>

            </div>
            <!-- /.container-fluid -->

<div class="col-xl-12 col-lg-7">
    <div class="card shadow mb-4">
        <!-- Card Header - Dropdown -->
        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">List of users</h6>
        </div>



        <div class="card-body">

            <table  cellpadding="10px " style="width:100%; height: 50px">
                <tr>
                    <th style="width: 10%">Id</th>
                    <th style="width: 30%">Nazwa użytkownika</th>
                    <th style="width: 30%">Email</th>
                    <th style="width: 30%">Akcja</th>
                </tr>

            </table>
            <hr class="sidebar-divider my-0">
            <table  cellpadding="10px " style="width:100%; height: 50px">
            <c:forEach var="user" items="${users}">
                <tr>
                <td style="width: 10%">${user.id}</td>
                <td style="width: 30%">${user.userName}</td>
                <td style="width: 30%">${user.email}</td>
                <td style="width: 30%">
                    <a href="/user/delete?id=${user.id}">delete</a>
                    <a href="/user/edit?id=${user.id}">edit</a>
                    <a href="/user/show?id=${user.id}">show</a>
                    </td>

                </tr>

            </c:forEach>
            </table>



            <hr class="sidebar-divider my-0">
        </div>
    </div>
</div>



<%@include file="/footer.jsp"%>

</body>
</html>