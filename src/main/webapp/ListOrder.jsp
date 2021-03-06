<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <title>View List Order</title>
    <link rel="shortcut icon" type="image/jpg" href="assets/photo/shortcut.png" />
    <link rel="stylesheet" href="assets/css/style.css">
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
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@400;500;600;700;800;900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
        integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
        crossorigin="anonymous" />
</head>
<style type="text/css">
    .btn-blue {
        background-color: #5680e9;
        color: white;
    }

    .btn-blue:hover {
        background-color: #5ab9ea;
    }



    body {
        font-family: "Azeret Mono", monospace;
        font-family: "Roboto Slab", serif;
    }
    .btn-cancel {
        background-color: white;
        border-color: #e1e1e1;
    }

    .btn-cancel:hover {
        background-color: aliceblue;
    }

    .text-de {
        color: #5ab9ea;
        text-decoration: line-through;
    }
    .btn-blue {
        background-color: #5680e9;
        color: white;
    }

    .btn-blue:hover {
        background-color: #5ab9ea;
    }

    .btn-cancel {
        background-color: white;
        border-color: #e1e1e1;
    }

    .btn-cancel:hover {
        background-color: aliceblue;
    }

    .text-de {
        color: #5ab9ea;
        text-decoration: line-through;
    }
</style>

<body>

    <div class="container-fluid" style="padding-top: 16px;">

        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked">
                <li class="category" >
                    <a class="nav-link bg-primary" href="#">Qu???n L?? ????n H??ng</a>
                </li>
                <li class="category">
                    <a class="nav-link" href="#">Qu???n L?? S???n Ph???m</a>
                </li>
                <li><a href="#section3" class="">Th??m s???n ph???m v??o kho</a></li>
                <li><a href="#section3">Th??m s???n ph???m l??n web</a></li>
            </ul><br>
        </div>


        <div class="col-md-9">
        	<c:forEach items="${orders}" var="order">
        		<div class="col-md-12">
					<div style="padding: 16px 32px;background-color: rgb(245, 245, 245); margin-bottom: 20px;">
	                    <div class="row">
	                        <div class="col-6">
	                            <img src="https://cf.shopee.vn/file/6b1ffcde1ff12621088110f419a5283a"
	                                style="width: 20px; height: 20px;">
	                            <h7>Qu??n quen</h7>
	                        </div>
	                        <div class="col-6 text-right">
	                        	
	                            <c:if test = "${order.getStatus()!='cancel'&&order.getStatus()!='complete'}">
									<span class="" style="color:var(--primary_color)" href="">
		                                <i class="fa fa-truck" aria-hidden="true"></i>
		                                <span>??ang giao h??ng</span>
		                            </span>
								</c:if>
	                        	<c:if test = "${order.getStatus()=='process'}">
									<i class="fa fa-question-circle" aria-hidden="true"></i>
	                            	<span>CH??? L???Y H??NG</span>
								</c:if>
								<c:if test = "${order.getStatus()=='confirm'}">
									<i class="fa fa-question-circle" aria-hidden="true"></i>
	                            	<span>???? X??C NH???N</span>
								</c:if>
								<c:if test = "${order.getStatus()=='complete'}">
									<i class="fa fa-question-circle" aria-hidden="true"></i>
	                            	<span>???? HO??N TH??NH</span>
								</c:if>
								<c:if test = "${order.getStatus()=='cancel'}">
									<i class="fa fa-question-circle" aria-hidden="true"></i>
	                            	<span>???? H???Y</span>
								</c:if>
	                        </div>
	                    </div>
	                    <div style=" width: 90%; display: block; margin: 0px auto; border-bottom: 1px solid
	                    #e1e1e1;padding-top:10px;">
	                    </div>
	                    <div class="row" style="padding-top: 10px;">
	                        <div class="col-sm-1">
	                            <img src="${order.getHeaderItem().getImage().get(0)}"
	                                style="width:80px; height: 80px;">
	                        </div>
	                        <div class="col-sm-9" style="padding-left: 32px; padding-top:16px">
	                            <span>${order.getHeaderItem().getHeader()}</span>
	                        </div>
	                        <div class="col-sm-2 text-right">
	                            <div class="text-de"><fmt:formatNumber
																value="${order.getHeaderItem().getPrices()+order.getHeaderItem().getPrices()*(order.getHeaderItem().getDiscount())}"
																minFractionDigits="0" maxFractionDigits="0" />???</div>
	                            <span><fmt:formatNumber
																value="${order.getHeaderItem().getPrices()}"
																minFractionDigits="0" maxFractionDigits="0" />??</span>
	
	                        </div>
	                    </div>
	                    <div class="col-12 text-right">
	                        <c:if test = "${order.getStatus()!='cancel'&&order.getStatus()!='complete'}">
								<a href="${pageContext.request.contextPath}/handleorder?id=${order.getId()}&status" class="btn btn-cancel">H???y ????n h??ng</a>
							</c:if>
	                        <c:if test = "${order.getStatus()=='confirm'}">
								<a href="${pageContext.request.contextPath}/handleorder?id=${order.getId()}&status=complete" class="btn btn-info">X??c nh???n ???? ho??n th??nh</a>
							</c:if>
							<a href="${pageContext.request.contextPath}/orderdetail?id=${order.getId()}" class="btn btn-blue">Xem chi ti???t</a>
	                    </div>
	                </div>
	                </div>
				</c:forEach>

        </div>
    </div>

</body>

</html>