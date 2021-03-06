<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <title>Add Book</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- Font awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
        integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;1,300;1,400&display=swap"
        rel="stylesheet">
</head>
<style type="text/css">
    .btn-blue {
        background-color: #5680e9;
        color: white;
    }

    .btn-blue:hover {
        background-color: #5ab9ea;
    }

    body,
    h2,
    h3,
    h5,
    h6 {
        font-family: "Open Sans", sans-serif;
        color: #555;
        font-family: "Open Sans", sans-serif;
        font-size: 14px;
    }

    .m-heading-1.m-bordered {
        border-right: 1px solid #10161c;
        border-top: 1px solid #10161c;
        border-bottom: 1px solid #10161c;
        padding: 15px;
    }

    .m-heading-1 {
        margin: 0 0 20px;
        background: #fff;
        padding-left: 15px;
        border-left: 8px solid #88909a;
    }

</style>

<body>
	

    <div class="container-fluid" style="margin-top: 16px">

        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked">
                <li class="category">
                    <a class="nav-link" href="${pageContext.request.contextPath}/listorder">Qu???n L?? ????n H??ng</a>
                </li>
                <li class="category">
                    <a class="nav-link" href="#">Qu???n L?? S???n Ph???m</a>
                </li>
                <li><a href="#section3" class="bg-primary">Th??m s???n ph???m v??o kho</a></li>
                <li><a href="#section3">Th??m s???n ph???m l??n web</a></li>
            </ul><br>
        </div>


        <div class="col-md-9">

            <!-- Author Start -->
            <div class="row text-center">
                <div class="col-md-12">
                    <div class="m-heading-1 border-grey-mint m-bordered">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <h4 style="font-size: 18px;font-weight: 700; padding-bottom: 20px;">
                                            TH??NG TIN T??C GI???
                                        </h4>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <form action="${pageContext.request.contextPath}/addauthor" method="post">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">T??n t??c gi???
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="name"
                                                placeholder="T??n t??c gi???">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-user-circle"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <br>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Ti???u s???
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <textarea class="form-control" rows="5"
                                                placeholder="Ti???u s??? (Kh??ng B???t Bu???c) | Nh???p t???i ??a 120 k?? t???"
                                                style="width: 605px;" name="biography"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <br>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Email
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="mail" placeholder="Email">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-envelope"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <br>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">?????a ch???
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="address"
                                                placeholder="?????a ch???">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-map-marker"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                             <div class="row text-center" style="padding-top: 30px;">
                            <button type="submit" class="btn btn-blue">Th??m</button>
                        </div>
                        </form>
                       
                    </div>
                </div>
            </div>
            <!-- Author End -->

            <!-- Publisher Start -->
            <div class="row text-center">
                <div class="col-md-12">
                    <div class="m-heading-1 border-grey-mint m-bordered">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <h4 style="font-size: 18px;font-weight: 700; padding-bottom: 20px;">
                                            TH??NG TIN NH?? PH??T H??NH
                                        </h4>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <form action="${pageContext.request.contextPath}/addpublisher" method="post">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">T??n nh?? ph??t h??nh
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="name"
                                                placeholder="T??n nh?? ph??t h??nh">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-building"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <br>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">?????a ch???
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="address" placeholder="?????a ch???">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-map-marker"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row text-center" style="padding-top: 30px;">
                            <button type="submit" class="btn btn-blue">Th??m</button>
                        </div>

                        </form>
                        
                    </div>
                </div>
            </div>
            <!-- Publisher End -->

            <!-- Catedory Start -->
            <div class="row text-center">
                <div class="col-md-12">
                    <div class="m-heading-1 border-grey-mint m-bordered">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <h4 style="font-size: 18px;font-weight: 700; padding-bottom: 20px;">
                                            DANH M???C
                                        </h4>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <form action="${pageContext.request.contextPath}/addcategory" method="post">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">T??n danh m???c
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="name"
                                                placeholder="T??n danh m???c">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-building"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row text-center" style="padding-top: 30px;">
                            <button type="submit" class="btn btn-blue">Th??m</button>
                        </div>

                        </form>
                        
                    </div>
                </div>
            </div>
            <!-- Category End -->

            <!-- Book Start -->
            <div class="row text-center">
                <div class="col-md-12">
                    <div class="m-heading-1 border-grey-mint m-bordered">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <h4 style="font-size: 18px;font-weight: 700; padding-bottom: 20px;">
                                            TH??NG TIN S??CH
                                        </h4>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <form action="${pageContext.request.contextPath}/addbook" method="post">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">T??c gi???
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <select class="form-control" name="author" style="width: 605px;">
                                            	<c:forEach items="${authors}" var="author">
                                            		<option value="${author.getId()}">${author.getName() }</option>
                                            	</c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Nh?? ph??t h??nh
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <select class="form-control" name="publisher" style="width: 605px;">
                                                <c:forEach items="${publishers}" var="publisher">
                                            		<option value="${publisher.getId()}">${publisher.getName() }</option>
                                            	</c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <br>
                            
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Danh m???c
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <select class="form-control" name="category" style="width: 605px;">
                                                <c:forEach items="${categories}" var="category">
                                            		<option value="${category.getId()}">${category.getName() }</option>
                                            	</c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <br>
							 <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">ISBN
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="ISBN" placeholder="ISBN" required>
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-align-center"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <br>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Ti??u ?????
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="title" placeholder="Ti??u ?????" required>
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-align-center"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <br>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Ng??n ng???
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="language"
                                                placeholder="Ng??n ng???" required>
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-globe"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <br>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Ng??y ph??t h??nh
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="publicationDate"
                                                placeholder="Ng??y ph??t h??nh yyyy-mm-dd" required >
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-calendar"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <br>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">S??? trang
                                        <span style="color: #e02222">[*]</span>
                                    </label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="numberOfPage"
                                                placeholder="S??? trang" required>
                                            <span class="input-group-btn">
                                                <button class="btn btn-default tooltips">
                                                    <i class="fa fa-paragraph"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                              <div class="row text-center" style="padding-top: 30px;">
                            <button type="submit" class="btn btn-blue">Th??m</button>
                        </div>
                        </form>
                      
                    </div>
                </div>
            </div>
            <!-- Book End -->
        </div>
    </div>

</body>

</html>