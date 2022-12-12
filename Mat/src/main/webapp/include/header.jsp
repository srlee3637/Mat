<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required Meta Tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Page Title -->
    <title>JMT 배달</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/logo/favicon.png" type="image/x-icon">

    <!-- CSS Files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate-3.7.0.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome-4.7.0.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-4.1.3.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl-carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery.datetimepicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    
    <style>
	table{color:white;}
	span{color:white;}
	a{color:orange;  font-weight: bolder; }
	
	h3{color:white; font-weight: bolder;}
	h4{
	font-weight: bolder;
	}
	</style>
</head>
<body>
    <!-- Preloader Starts -->
    <div class="preloader">
        <div class="spinner"></div>
    </div>
    <!-- Preloader End -->

    <!-- Header Area Starts -->
	<header class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="logo-area">
                        <a href="${pageContext.request.contextPath}/MainPage.jsp"><img src="${pageContext.request.contextPath}/assets/images/logo/logo2.png" alt="logo"></a>
                    </div>
                </div>
                <div class="col-lg-10">
                    <div class="custom-navbar">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>  
                    <div class="main-menu">
                        <ul>
                            <li class="active"><a href="${pageContext.request.contextPath}/MainPage.main">home</a></li>
                            <li><a href="${pageContext.request.contextPath}/store/store_main.store">search</a></li>
                            
                            <!--조건에 따른 표시  -->
                    <c:if test="${sessionScope.user_id==null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/user_login.user">LOGIN</a>
                    </li>
                    </c:if>
                    
                    <c:if test="${sessionScope.user_id!=null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/user_mypage.user">MYPAGE</a>
                        <ul class="sub-menu">
                        <li>
                        <a href="${pageContext.request.contextPath}/user/user_modify.user">MODIFY</a>
                        </li>
                        <li>
                        <a href="${pageContext.request.contextPath}/user/user_logout.user">LOGOUT</a>
                        </li>
                        <li>
                        <a href="${pageContext.request.contextPath}/order/order_history.order">ORDERLIST</a>
                        </li>
                        </ul>
                    </li>
                  	</c:if>
                            	
                               
                           
                            <li><a href="${pageContext.request.contextPath}/user/user_favorite.user">Favorites</a></li>
                          
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
    
    <!-- Header Area End -->

    
